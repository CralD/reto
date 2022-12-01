package com.example.reto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;

import com.example.reto.controller.TestController;
import com.example.reto.models.TestModel;
import com.example.reto.service.TestService;





@ExtendWith(MockitoExtension.class)
class TestTest {

     @Mock
     private TestService testServicioMock;
     
     @InjectMocks
     private TestController  testController;
     
	@Test
	public void obtenerTestNotContent() {
		ArrayList<TestModel> noContent = new ArrayList<TestModel>();
		Mockito.when(testServicioMock.obtenerTest())
		        .thenReturn(noContent);
		var status = testController.obtenerTest(); 
		assertEquals(HttpStatus.NO_CONTENT,status.getStatusCode());	
	}
	@Test
	public void obtenerTestOk() {
		ArrayList<TestModel> contentOk = new ArrayList<TestModel>();
		contentOk.add(new TestModel());
		Mockito.when(testServicioMock.obtenerTest())
		        .thenReturn(contentOk);
		var status = testController.obtenerTest(); 
		assertEquals(HttpStatus.OK,status.getStatusCode());
	}
	@Test
	public void guardarTestOk() {
		TestModel contentOk = new TestModel();
		contentOk.setId((long)1);
		contentOk.setName("pedro perez");
		contentOk.setDescription("persona para el test");
		Mockito.when(testServicioMock.guardarTest(contentOk))
		        .thenReturn(contentOk);
		var status = testController.guardarTest(contentOk); 
		assertEquals(HttpStatus.CREATED,status.getStatusCode());
	}
	@Test
	public void guardarTestNotFound() {
		TestModel noContent = new TestModel();
		noContent.setId((long)1);
		noContent.setName("pedro perez");
		noContent.setDescription("persona para el test");
		Mockito.when(testServicioMock.guardarTest(noContent))
		        .thenThrow(NullPointerException.class);
		var status = testController.guardarTest(noContent); 
		assertEquals(HttpStatus.NOT_FOUND,status.getStatusCode());
	}
	@Test
	public void obtenerTestIdYRetorneNotContent() {
		Mockito.when(testServicioMock.obtenerPorId((long) 1))
		        .thenReturn(Optional.empty());
		var status = testController.obtenerTestPorId((long)1); 
		assertEquals(HttpStatus.NOT_FOUND,status.getStatusCode());	
	}
	@Test
	public void obtenerTestIdYRetorneOK() {
		Optional<TestModel> contentOk = Optional.of(new TestModel());
		Mockito.when(testServicioMock.obtenerPorId((long) 1))
		        .thenReturn(contentOk);
		var status = testController.obtenerTestPorId((long)1); 
		assertEquals(HttpStatus.OK,status.getStatusCode());	
	}
	@Test
	public void actualizarTestYRetorneOK() {
		TestModel contentOk = new TestModel();
		Mockito.when(testServicioMock.actualizarTest(contentOk))
		        .thenReturn(contentOk);
		var status = testController.update(contentOk); 
		assertEquals(HttpStatus.CREATED,status.getStatusCode());	
	}
	@Test
	public void actualizarTestYRetorneNotFound() {
		TestModel noContent = new TestModel();
		Mockito.when(testServicioMock.actualizarTest(null))
		        .thenReturn(null);
		var status = testController.update(null); 
		assertEquals(HttpStatus.NOT_FOUND,status.getStatusCode());	
	}
	@Test
	public void eliminarTestOk() {
		TestModel contentOk = new TestModel();
		contentOk.setId((long)1);
	    doNothing().when(testServicioMock).eliminarTest((long)1);
		       
		var status = testController.eliminarPorId((long)1); 
		assertEquals(HttpStatus.OK,status.getStatusCode());
	}
	@Test
	public void eliminarTestNotContent() {
		TestModel contentOk = new TestModel();
		
	    doThrow(NullPointerException.class).when(testServicioMock).eliminarTest(null);
	 
		var status = testController.eliminarPorId(null); 
		assertEquals(HttpStatus.NO_CONTENT,status.getStatusCode());
	}
}
