package com.example.reto.controller;

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
import org.springframework.http.ResponseEntity;

import com.example.reto.models.TestModel;
import com.example.reto.service.TestService;

@ExtendWith(MockitoExtension.class)
class TestControllerTest {

	@Mock
	private TestService testServicioMock;

	@InjectMocks
	private TestController testController;

	@Test
	public void obtenerTestNoContent() {
		ArrayList<TestModel> noContent = new ArrayList<TestModel>();

		Mockito.when(testServicioMock.obtenerTest()).thenReturn(noContent);

		ResponseEntity<ArrayList<TestModel>> httpStatus = testController.obtenerTest();

		assertEquals(HttpStatus.NO_CONTENT, httpStatus.getStatusCode());
	}

	@Test
	public void obtenerTestOk() {
		ArrayList<TestModel> contentOk = new ArrayList<TestModel>();
		contentOk.add(new TestModel());

		Mockito.when(testServicioMock.obtenerTest()).thenReturn(contentOk);

		ResponseEntity<ArrayList<TestModel>> httpStatus = testController.obtenerTest();

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
	}

	@Test
	public void guardarTestOk() {
		TestModel contentOk = new TestModel();
		contentOk.setId((long) 1);
		contentOk.setName("pedro perez");
		contentOk.setDescription("persona para el test");

		Mockito.when(testServicioMock.guardarTest(contentOk)).thenReturn(contentOk);

		ResponseEntity<TestModel> httpStatus = testController.guardarTest(contentOk);

		assertEquals(HttpStatus.CREATED, httpStatus.getStatusCode());
	}

	@Test
	public void guardarTestNotFound() {
		TestModel noContent = new TestModel();
		noContent.setId((long) 1);
		noContent.setName("pedro perez");
		noContent.setDescription("persona para el test");

		Mockito.when(testServicioMock.guardarTest(noContent)).thenThrow(NullPointerException.class);

		ResponseEntity<TestModel> httpStatus = testController.guardarTest(noContent);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());
	}

	@Test
	public void obtenerTestIdYRetorneNotContent() {
		Mockito.when(testServicioMock.obtenerPorId((long) 1)).thenReturn(Optional.empty());

		ResponseEntity<Optional<TestModel>> httpStatus = testController.obtenerTestPorId((long) 1);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());
	}

	@Test
	public void obtenerTestIdYRetorneOK() {
		Optional<TestModel> contentOk = Optional.of(new TestModel());

		Mockito.when(testServicioMock.obtenerPorId((long) 1)).thenReturn(contentOk);

		ResponseEntity<Optional<TestModel>> httpStatus = testController.obtenerTestPorId((long) 1);

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
	}

	@Test
	public void actualizarTestYRetorneOK() {
		TestModel contentOk = new TestModel();

		Mockito.when(testServicioMock.actualizarTest(contentOk)).thenReturn(contentOk);

		ResponseEntity<TestModel> httpStatus = testController.actualizarTest(contentOk);

		assertEquals(HttpStatus.CREATED, httpStatus.getStatusCode());
	}

	@Test
	public void actualizarTestYRetorneNotFound() {
		Mockito.when(testServicioMock.actualizarTest(null)).thenReturn(null);

		ResponseEntity<TestModel> httpStatus = testController.actualizarTest(null);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());
	}

	@Test
	public void eliminarTestOk() {
		TestModel contentOk = new TestModel();
		contentOk.setId((long) 1);

		doNothing().when(testServicioMock).eliminarTest((long) 1);

		ResponseEntity<Void> httpStatus = testController.eliminarPorId((long) 1);

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
	}

	@Test
	public void eliminarTestNotContent() {
		doThrow(NullPointerException.class).when(testServicioMock).eliminarTest(null);

		ResponseEntity<Void> httpStatus = testController.eliminarPorId(null);

		assertEquals(HttpStatus.NO_CONTENT, httpStatus.getStatusCode());
	}
}
