package com.example.reto.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "test", schema = "reto")
public class TestModel {
	@Id
	@SequenceGenerator(schema = "reto", name = "reto_secuence", sequenceName = "reto_secuence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reto_secuence")
	private Long id;
	private String name;
	private String description;
	/*@OneToMany(cascade = CascadeType.ALL,mappedBy = "test")
    private List<AppoinmentsModel> appoinment;
    */
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public List<AppoinmentsModel> getAppoinment() {
		return appoinment;
	}

	public void setAppoinment(List<AppoinmentsModel> appoinment) {
		this.appoinment = appoinment;
	}*/

}
