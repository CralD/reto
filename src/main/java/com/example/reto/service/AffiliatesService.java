package com.example.reto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.models.AffiliatesModel;
import com.example.reto.repository.AffiliatesRepository;

@Service
public class AffiliatesService {
	@Autowired
	AffiliatesRepository affiliatesRepository;
	
	public ArrayList<AffiliatesModel> obtenerAfiliados(){
		return (ArrayList<AffiliatesModel>) affiliatesRepository.findAll();
	}
	public AffiliatesModel guardarAfiliados(AffiliatesModel affiliates) {
		return affiliatesRepository.save(affiliates);
	}
	public Optional<AffiliatesModel> obtenerAfiliadosPorId(Long id){
		return affiliatesRepository.findById(id);
	}
	public AffiliatesModel actualizarAfiliados(AffiliatesModel affiliates) {
		Optional<AffiliatesModel> affiliateId = affiliatesRepository.findById(affiliates.getId());
		if(affiliateId.isPresent()) {
			AffiliatesModel affiliateUpdated = affiliateId.get();
			affiliateUpdated.setName(affiliates.getName());
			affiliateUpdated.setAge(affiliates.getAge());
			affiliateUpdated.setMail(affiliates.getMail());
			return affiliatesRepository.save(affiliates);
		}else {
			return null;
		}
	}
	public void deleteAffiliates(Long id) {
		affiliatesRepository.deleteById(id);
	}
}
