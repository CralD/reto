package com.example.reto.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reto.models.AffiliatesModel;
import com.example.reto.service.AffiliatesService;

@RestController
@RequestMapping("/affiliates")
public class AffiliatesController {
     @Autowired
     AffiliatesService affiliatesService;
     
     @GetMapping()
     public ResponseEntity<ArrayList<AffiliatesModel>> getAffiliates(){
    	 ArrayList<AffiliatesModel> obtener = this.affiliatesService.obtenerAfiliados();
    	 if(obtener.isEmpty()) {
    		 return ResponseEntity.noContent().build();
    	 }else {
    		 return ResponseEntity.ok(obtener);
    	 }
     }
     @PostMapping()
     public ResponseEntity<AffiliatesModel> guardarAfiliados(@RequestBody AffiliatesModel affiliates){
    	 
    	 try {
    		 AffiliatesModel guardar = this.affiliatesService.guardarAfiliados(affiliates);
    		 return ResponseEntity.status(HttpStatus.CREATED).body(guardar);
    	 }catch(Exception Error) {
    		 return ResponseEntity.notFound().build();
    	 }
     }
     @GetMapping(path ="/{id}")
     public ResponseEntity<Optional<AffiliatesModel>> obtenerAfiliadosPorId(@PathVariable("id")Long id){
    	 Optional<AffiliatesModel> obtenerConId = this.affiliatesService.obtenerAfiliadosPorId(id);
    	 if(obtenerConId.isPresent()) {
    		 return ResponseEntity.ok(obtenerConId);
    	 }else {
    		 return ResponseEntity.notFound().build();
    	 }
     }
     @PutMapping()
     public ResponseEntity<AffiliatesModel> update(@RequestBody AffiliatesModel affiliates){
    	 AffiliatesModel obtenerId = this.affiliatesService.actualizarAfiliados(affiliates);
    	 if(obtenerId != null) {
    		 return ResponseEntity.status(HttpStatus.CREATED).body(obtenerId);
    	 }else {
    		 return ResponseEntity.notFound().build();
    	 }
     }
     @DeleteMapping(path ="/{id}")
     public ResponseEntity<Void> eliminarAfiliadoPorId(@PathVariable("id") Long id){
    	 try {
    		 affiliatesService.deleteAffiliates(id);
    		 return ResponseEntity.ok().build();
    	 }catch (Exception Error) {
    		 return ResponseEntity.noContent().build();
    	 }
     }
}
