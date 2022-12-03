package com.example.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reto.models.AppoinmentsModel;

@Repository
public interface AppoinmentsRepository extends JpaRepository<AppoinmentsModel, Long> {

}
