package com.example.reto.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "affiliates", schema = "reto")
public class AffiliatesModel {
	@Id
	@SequenceGenerator(schema = "reto", name = "reto_affiliates_secuence", sequenceName = "reto_affiliates_secuence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reto_affiliates_secuence")
	private Long id;
	private String name;
	private Integer age;
	private String mail;
	//@OneToMany(cascade = CascadeType.ALL,mappedBy = "affiliate",fetch = FetchType.LAZY)
	//private List<AppoinmentsModel> appoinment;

	  
	//public List<AppoinmentsModel> getAppoinment() {
	//	return appoinment;
	//}

	//public void setAppoinment(List<AppoinmentsModel> appoinment) {
//	this.appoinment = appoinment;
	//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
