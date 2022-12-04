package com.example.reto.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.reto.models.TestModel;
import com.example.reto.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	TestService testService;

	@GetMapping()
	public ResponseEntity<ArrayList<TestModel>> obtenerTest() {
		ArrayList<TestModel> obtener = this.testService.obtenerTest();

		if (obtener.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(obtener);
		}
	}

	@PostMapping()
	public ResponseEntity<TestModel> guardarTest(@RequestBody TestModel test) {

		try {
			TestModel guardar = this.testService.guardarTest(test);
			return ResponseEntity.status(HttpStatus.CREATED).body(guardar);
		} catch (Exception Error) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<TestModel>> obtenerTestPorId(@PathVariable("id") Long id) {
		Optional<TestModel> obtenerConId = this.testService.obtenerPorId(id);

		if (obtenerConId.isPresent()) {
			return ResponseEntity.ok(obtenerConId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping()
	public ResponseEntity<TestModel> actualizarTest(@RequestBody TestModel test) {
		TestModel obtenerId = this.testService.actualizarTest(test);

		if (obtenerId != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(obtenerId);
		} else {

			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Long id) {
		try {
			testService.eliminarTest(id);
			return ResponseEntity.ok().build();
		} catch (Exception Error) {
			return ResponseEntity.noContent().build();
		}

	}

}
