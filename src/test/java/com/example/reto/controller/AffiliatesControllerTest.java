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

import com.example.reto.models.AffiliatesModel;
import com.example.reto.service.AffiliatesService;

@ExtendWith(MockitoExtension.class)
class AffiliatesControllerTest {

	@Mock
	private AffiliatesService affiliatesServiceMock;

	@InjectMocks
	private AffiliatesController affiliatesController;

	@Test
	public void obtenerAfiliadosyRetorneNoContent() {
		ArrayList<AffiliatesModel> noContent = new ArrayList<AffiliatesModel>();
		Mockito.when(affiliatesServiceMock.obtenerAfiliados()).thenReturn(noContent);
		ResponseEntity<ArrayList<AffiliatesModel>> status = affiliatesController.obtenerAfiliados();
		assertEquals(HttpStatus.NO_CONTENT, status.getStatusCode());
	}

	@Test
	public void obtenerAfiliadosYRetoneOk() {
		ArrayList<AffiliatesModel> contentOk = new ArrayList<AffiliatesModel>();
		contentOk.add(new AffiliatesModel());
		Mockito.when(affiliatesServiceMock.obtenerAfiliados()).thenReturn(contentOk);
		ResponseEntity<ArrayList<AffiliatesModel>> status = affiliatesController.obtenerAfiliados();
		assertEquals(HttpStatus.OK, status.getStatusCode());
	}
	@Test
	public void guardarAfiliadosyRetorneOk() {
		AffiliatesModel contentOK = new AffiliatesModel();
		contentOK.setId((long)1);
		contentOK.setName("juan rodriguez");
		contentOK.setAge(34);
		contentOK.setMail("juanro@gamil.com");
		Mockito.when(affiliatesServiceMock.guardarAfiliados(contentOK))
		        .thenReturn(contentOK);
		ResponseEntity<AffiliatesModel> status = affiliatesController.guardarAfiliados(contentOK);
		assertEquals(HttpStatus.CREATED,status.getStatusCode());
	}
	@Test
	public void guardarAfiliadosyRetorneNotFound() {
		AffiliatesModel contentOK = new AffiliatesModel();
		contentOK.setId((long)1);
		contentOK.setName("juan rodriguez");
		contentOK.setAge(34);
		contentOK.setMail("juanro@gamil.com");
		
		Mockito.when(affiliatesServiceMock.guardarAfiliados(contentOK))
		        .thenThrow(NullPointerException.class);
		
		ResponseEntity<AffiliatesModel> status = affiliatesController.guardarAfiliados(contentOK);
		
		assertEquals(HttpStatus.NOT_FOUND,status.getStatusCode());
	}
	@Test
	public void obtenerAfiliadosPorIdyRetorneOk() {
		Optional<AffiliatesModel> contentOk =Optional.of(new AffiliatesModel());
		Mockito.when(affiliatesServiceMock.obtenerAfiliadosPorId((long)1))
				.thenReturn(contentOk);
		ResponseEntity<Optional<AffiliatesModel>> status = affiliatesController.obtenerAfiliadosPorId((long)1);
		assertEquals(HttpStatus.OK,status.getStatusCode());
	}
	@Test
	public void obtenerAfiliadosPorIdyRetorneNotFound() {
		Mockito.when(affiliatesServiceMock.obtenerAfiliadosPorId((long)1))
				.thenReturn(Optional.empty());
		ResponseEntity<Optional<AffiliatesModel>> status = affiliatesController.obtenerAfiliadosPorId((long)1);
		assertEquals(HttpStatus.NOT_FOUND,status.getStatusCode());
	}
	@Test
	public void actualizarAfiliadosyRetorneOk() {
		AffiliatesModel contentOK = new AffiliatesModel();
		Mockito.when(affiliatesServiceMock.actualizarAfiliados(contentOK))
		        .thenReturn(contentOK);
		ResponseEntity<AffiliatesModel> status = affiliatesController.update(contentOK);
		assertEquals(HttpStatus.CREATED,status.getStatusCode());
	}
	@Test
	public void actualizarAfiliadosyRetorneNotFound() {
		Mockito.when(affiliatesServiceMock.actualizarAfiliados(null))
		        .thenReturn(null);
		ResponseEntity<AffiliatesModel> status = affiliatesController.update(null);
		assertEquals(HttpStatus.NOT_FOUND,status.getStatusCode());
	}
	@Test
	public void eliminarAfiliadosPorIdyRetorneOK() {
		AffiliatesModel contentOk = new AffiliatesModel();
		contentOk.setId((long)1);
		doNothing().when(affiliatesServiceMock).deleteAffiliates((long)1);
		ResponseEntity<Void> status = affiliatesController.eliminarAfiliadoPorId((long)1);
		assertEquals(HttpStatus.OK,status.getStatusCode());
	}
	@Test
	public void eliminarAfiliadosPorIdyRetorneNoContent() {
		
	doThrow(NullPointerException.class).when(affiliatesServiceMock).deleteAffiliates(null);
		
		ResponseEntity<Void> status = affiliatesController.eliminarAfiliadoPorId((long)1);
		assertEquals(HttpStatus.NO_CONTENT,status.getStatusCode());
	}
	


}
