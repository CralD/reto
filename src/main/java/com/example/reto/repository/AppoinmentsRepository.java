package com.example.reto.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reto.models.AffiliatesModel;
import com.example.reto.models.AppoinmentsModel;

@Repository
public interface AppoinmentsRepository extends JpaRepository<AppoinmentsModel, Long> {
	List<AppoinmentsModel> findByAffiliate(AffiliatesModel affiliate);
    List<AppoinmentsModel> findByDateOrderByAffiliate(LocalDate date);
}
