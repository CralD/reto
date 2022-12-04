package com.example.reto.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.reto.dto.AppoinmentsDTO;
import com.example.reto.models.AppoinmentsModel;
import com.example.reto.service.AppoinmentsService;

@ExtendWith(MockitoExtension.class)
class AppoinmentsControllerTest {

	@Mock
	private AppoinmentsService appoinmentsService;

	@InjectMocks
	private AppoinmentsController appoinmentsController;

	@Test
	public void obtenerAppoimentsyRetorneNoContent() {
		ArrayList<AppoinmentsModel> noContent = new ArrayList<AppoinmentsModel>();

		Mockito.when(appoinmentsService.obtenerAppoinment()).thenReturn(noContent);

		ResponseEntity<ArrayList<AppoinmentsModel>> httpstatus = appoinmentsController.obtenerAppoinment();

		assertEquals(HttpStatus.NO_CONTENT, httpstatus.getStatusCode());

	}

	@Test
	public void obtenerAppoimentsyRetorneOk() {
		ArrayList<AppoinmentsModel> contentOk = new ArrayList<AppoinmentsModel>();
		contentOk.add(new AppoinmentsModel());

		Mockito.when(appoinmentsService.obtenerAppoinment()).thenReturn(contentOk);

		ResponseEntity<ArrayList<AppoinmentsModel>> httpstatus = appoinmentsController.obtenerAppoinment();

		assertEquals(HttpStatus.OK, httpstatus.getStatusCode());

	}

	@Test
	public void guardarAppoimentyRetorneOk() {
		AppoinmentsDTO contentOk = new AppoinmentsDTO();

		AppoinmentsModel contentOk1 = new AppoinmentsModel();

		contentOk1.setId((long) 1);
		contentOk1.setDate(null);
		contentOk1.setHour(null);
		contentOk.setIdTest((long) 1);
		contentOk.setIdAffiliate((long) 1);

		Mockito.when(appoinmentsService.guardarAppoinment(contentOk)).thenReturn(contentOk1);

		ResponseEntity<AppoinmentsModel> httpStatus = appoinmentsController.guardarAppoinment(contentOk);

		assertEquals(HttpStatus.CREATED, httpStatus.getStatusCode());

	}

	@Test
	public void guardarAppoimentyRetorneNotFound() {
		AppoinmentsDTO contentOk = new AppoinmentsDTO();

		AppoinmentsModel contentOk1 = new AppoinmentsModel();

		contentOk1.setId((long) 1);
		contentOk1.setDate(null);
		contentOk1.setHour(null);
		contentOk.setIdTest((long) 1);
		contentOk.setIdAffiliate((long) 1);

		Mockito.when(appoinmentsService.guardarAppoinment(contentOk)).thenThrow(NullPointerException.class);

		ResponseEntity<AppoinmentsModel> httpStatus = appoinmentsController.guardarAppoinment(contentOk);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());

	}

	@Test
	public void obtenerAppoimentPorIdyRetorneOk() {
		Optional<AppoinmentsModel> contentOK = Optional.of(new AppoinmentsModel());

		Mockito.when(appoinmentsService.obtenerAppoinmentPorID((long) 1)).thenReturn(contentOK);

		ResponseEntity<Optional<AppoinmentsModel>> httpStatus = appoinmentsController.obtenerAppoinmentPorId((long) 1);

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());

	}

	@Test
	public void obtenerAppoimentPorIdyRetorneNotFound() {
		Mockito.when(appoinmentsService.obtenerAppoinmentPorID((long) 1)).thenReturn(Optional.empty());

		ResponseEntity<Optional<AppoinmentsModel>> httpStatus = appoinmentsController.obtenerAppoinmentPorId((long) 1);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());

	}

	@Test
	public void actualizarAppoinmentyRetorneOk() {
		AppoinmentsModel contentOK = new AppoinmentsModel();
		AppoinmentsDTO contentOk1 = new AppoinmentsDTO();

		Mockito.when(appoinmentsService.actualizarAppoinment(contentOk1)).thenReturn(contentOK);

		ResponseEntity<AppoinmentsModel> httpStatus = appoinmentsController.actualizarAppoinment(contentOk1);

		assertEquals(HttpStatus.CREATED, httpStatus.getStatusCode());
	}

	@Test
	public void actualizarAppoinmentyRetorneNotFound() {
		Mockito.when(appoinmentsService.actualizarAppoinment(null)).thenReturn(null);

		ResponseEntity<AppoinmentsModel> httpStatus = appoinmentsController.actualizarAppoinment(null);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());
	}

	@Test
	public void eliminarAppoinmentPorIdYretorneOk() {
		AppoinmentsModel contentOk = new AppoinmentsModel();
		contentOk.setId((long) 1);

		doNothing().when(appoinmentsService).eliminarAppoinment((long) 1);

		ResponseEntity<Void> httpStatus = appoinmentsController.eliminarAppoinmentPorId((long) 1);

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
	}

	@Test
	public void eliminarAppoinmentPorIdYretorneNoContent() {

		doThrow(NullPointerException.class).when(appoinmentsService).eliminarAppoinment(null);

		ResponseEntity<Void> httpStatus = appoinmentsController.eliminarAppoinmentPorId((long) 1);

		assertEquals(HttpStatus.NO_CONTENT, httpStatus.getStatusCode());
	}

	@Test
	public void obtenerAppoimentPorAfiliadoyRetorneOk() {
		List<AppoinmentsModel> contentOK = new ArrayList<>();
		contentOK.add(new AppoinmentsModel());

		Mockito.when(appoinmentsService.obtenerPorAfiliado((long) 1)).thenReturn(contentOK);

		ResponseEntity<List<AppoinmentsModel>> httpStatus = appoinmentsController.obtenerAppoinmentPorAfiliado((long) 1);

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());

	}

	@Test
	public void obtenerAppoimentPorAfiliadoyRetorneNotFound() {
		ResponseEntity<List<AppoinmentsModel>> httpStatus = appoinmentsController.obtenerAppoinmentPorAfiliado(null);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());

	}

	@Test
	public void obtenerAppoimentPorDateyRetorneOk() {
		List<AppoinmentsModel> contentOK = new ArrayList<>();

		contentOK.add(new AppoinmentsModel());

		Mockito.when(appoinmentsService.obtenerPorDate(LocalDate.of(2022, 12, 21))).thenReturn(contentOK);

		ResponseEntity<List<AppoinmentsModel>> httpStatus = appoinmentsController.obtenerAppoinmentPorDate(LocalDate.of(2022, 12, 21));

		assertEquals(HttpStatus.OK, httpStatus.getStatusCode());

	}

	@Test
	public void obtenerAppoimentPorDateyRetorneNotFound() {
		ResponseEntity<List<AppoinmentsModel>> httpStatus = appoinmentsController.obtenerAppoinmentPorDate(null);

		assertEquals(HttpStatus.NOT_FOUND, httpStatus.getStatusCode());

	}

}
