package com.example.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reto.models.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long>{

}
