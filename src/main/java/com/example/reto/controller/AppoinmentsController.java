package com.example.reto.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reto.dto.AppoinmentsDTO;
import com.example.reto.models.AppoinmentsModel;
import com.example.reto.service.AppoinmentsService;

@RestController
@RequestMapping("/appoinments")
public class AppoinmentsController {
	@Autowired
	AppoinmentsService appoinmentsService;

	@GetMapping()
	public ResponseEntity<ArrayList<AppoinmentsModel>> obtenerAppoinment() {
		ArrayList<AppoinmentsModel> obtener = this.appoinmentsService.obtenerAppoinment();
		if (obtener.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obtener);
		}
	}

	@PostMapping()
	public ResponseEntity<AppoinmentsModel> guardarAppoinment(@RequestBody AppoinmentsDTO appoinment) {

		try {
			AppoinmentsModel guardar = this.appoinmentsService.guardarAppoinment(appoinment);
			return ResponseEntity.status(HttpStatus.CREATED).body(guardar);
		} catch (Exception Error) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<AppoinmentsModel>> obtenerAppoinmentPorId(@PathVariable("id") Long id) {
		Optional<AppoinmentsModel> obtenerConId = this.appoinmentsService.obtenerAppoinmentPorID(id);
		if (obtenerConId.isPresent()) {
			return ResponseEntity.ok(obtenerConId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<AppoinmentsModel> actualizarAppoinment(@RequestBody AppoinmentsDTO appoinment) {
		AppoinmentsModel obtenerId = this.appoinmentsService.actualizarAppoinment(appoinment);
		if (obtenerId != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(obtenerId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> eliminarAppoinmentPorId(@PathVariable("id") Long id) {
		try {
			appoinmentsService.eliminarAppoinment(id);
			return ResponseEntity.ok().build();
		} catch (Exception Error) {
			return ResponseEntity.noContent().build();
		}
	}
	@GetMapping(path ="/GetByAfilliate/{id}")
	public ResponseEntity<List<AppoinmentsModel>> obtenerAppoinmentPorAfiliado(@PathVariable("id") Long id){
		List<AppoinmentsModel> obtener = this.appoinmentsService.obtenerPorAfiliado(id);
		if (obtener.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obtener);
		}
	}
	@GetMapping(path ="/GetByDate/{date}")
	public ResponseEntity<List<AppoinmentsModel>> obtenerAppoinmentPorDate (@PathVariable("date")@DateTimeFormat(pattern="yyyy-MM-dd")LocalDate date){
		List<AppoinmentsModel> obtener = this.appoinmentsService.obtenerPorDate(date);
		if (obtener.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obtener);
		}
	}
}
