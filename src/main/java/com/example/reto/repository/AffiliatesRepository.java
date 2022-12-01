package com.example.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reto.models.AffiliatesModel;

@Repository
public interface AffiliatesRepository extends JpaRepository<AffiliatesModel, Long> {

}
