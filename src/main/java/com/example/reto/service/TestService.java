package com.example.reto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.models.TestModel;
import com.example.reto.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepository;

	public ArrayList<TestModel> obtenerTest() {

		return (ArrayList<TestModel>) testRepository.findAll();
	}

	public TestModel guardarTest(TestModel test) {

		return testRepository.save(test);
	}

	public Optional<TestModel> obtenerPorId(Long id) {
		return testRepository.findById(id);
	}

	public TestModel actualizarTest(TestModel test) {

		Optional<TestModel> testId = testRepository.findById(test.getId());

		if (testId.isPresent()) {
			TestModel testActualizado = testId.get();
			testActualizado.setName(test.getName());
			testActualizado.setDescription(test.getDescription());

			return testRepository.save(test);
		}

		else {

			return null;
		}
	}

	public void eliminarTest(Long id) {

		testRepository.deleteById(id);
	}
}
