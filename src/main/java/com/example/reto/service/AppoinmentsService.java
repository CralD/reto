package com.example.reto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.dto.AppoinmentsDTO;
import com.example.reto.models.AffiliatesModel;
import com.example.reto.models.AppoinmentsModel;
import com.example.reto.models.TestModel;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.repository.AppoinmentsRepository;
import com.example.reto.repository.TestRepository;

@Service
public class AppoinmentsService {
	@Autowired
	AppoinmentsRepository appoinmentsRepository;
	@Autowired
	TestRepository testRepository;
	@Autowired
	AffiliatesRepository affiliatesRepository;

	public ArrayList<AppoinmentsModel> obtenerAppoinment() {
		return (ArrayList<AppoinmentsModel>) appoinmentsRepository.findAll();
	}

	public AppoinmentsModel guardarAppoinment(AppoinmentsDTO appoinmentDto) {
		Optional<AffiliatesModel> affiliate = affiliatesRepository.findById(appoinmentDto.getIdAffiliate());
		if (affiliate.isEmpty()) {
			return null;
		}

		Optional<TestModel> test = testRepository.findById(appoinmentDto.getIdTest());
		if (test.isEmpty()) {
			return null;
		}
		AppoinmentsModel appoinment = new AppoinmentsModel();
		appoinment.setDate(appoinmentDto.getDate());
		appoinment.setHour(appoinmentDto.getHour());
		appoinment.setTest(test.get());
		appoinment.setAffiliate(affiliate.get());
		return appoinmentsRepository.save(appoinment);

	}

	public Optional<AppoinmentsModel> obtenerAppoinmentPorID(Long id) {
		return appoinmentsRepository.findById(id);
	}

	public AppoinmentsModel actualizarAppoinment(AppoinmentsDTO appoinmentDto) {
	
		
		Optional<AppoinmentsModel> appoinment = appoinmentsRepository.findById(appoinmentDto.getId());
		
		if (appoinment.isPresent()) {
			
			Optional<AffiliatesModel> affiliate = affiliatesRepository.findById(appoinmentDto.getIdAffiliate());
			if (affiliate.isEmpty()) {
				return null;
			}

			Optional<TestModel> test = testRepository.findById(appoinmentDto.getIdTest());
			if (test.isEmpty()) {
				return null;
			}
			
			AppoinmentsModel appoinmentActualizado = appoinment.get();
			appoinmentActualizado.setDate(appoinmentDto.getDate());
			appoinmentActualizado.setHour(appoinmentDto.getHour());
			appoinmentActualizado.setTest(test.get());
			appoinmentActualizado.setAffiliate(affiliate.get());
			return appoinmentsRepository.save(appoinmentActualizado);
			
		} else {
			
			return null;
		}
	}

	public void eliminarAppoinment(Long id) {
		appoinmentsRepository.deleteById(id);
	}

}
