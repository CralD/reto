package com.example.reto.service;

import java.util.ArrayList;
import java.util.Optional;

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
    
    public Optional<Test> obtenerPorId(Long id){
        return testRepository.findById(id);
    }
    
    public Test  actualizarTest(Test test){
    	Optional<Test> testId = testRepository.findById(test.getId());
    	if(testId.isPresent()) {
    		Test testActualizado = testId.get();
    		testActualizado.setName(test.getName());
        	testActualizado.setDescription(test.getDescription());
        	
        	 return testRepository.save(test);}
    	
    	else {
    		return null;}
    }
    public void eliminarTest(Long id) {
    		testRepository.deleteById(id);
    	}
    }
    

