package com.example.reto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.repository.AffiliatesRepository;

@Service
public class AffiliatesService {
@Autowired
AffiliatesRepository affiliatesRepository;
}
