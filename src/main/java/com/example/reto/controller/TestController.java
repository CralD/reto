package com.example.reto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reto.models.Test;
import com.example.reto.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	TestService testService;
	
	@GetMapping()
	public ArrayList<Test> obtenerTest(){
		return testService.obtenerTest();
	}
	@PostMapping()
	public Test guardarTest() {
		Test hola = new Test();
		hola.setName("adan");
		hola.setDescription("hello");
		return this.testService.guardarTest(hola);
	}

}
