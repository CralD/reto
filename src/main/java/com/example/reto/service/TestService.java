package com.example.reto.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.models.Test;
import com.example.reto.repository.TestRepository;

@Service
public class TestService {
    @Autowired
	TestRepository testRepository;
    public ArrayList<Test> obtenerTest(){
    	return (ArrayList<Test>) testRepository.findAll();
    }
    
    public Test guardarTest(Test test) {
    	return testRepository.save(test);
    }
     
}
