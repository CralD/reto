package com.example.reto.models;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "appoinments", schema = "reto")
public class AppoinmentsModel {

	@Id
	@SequenceGenerator(schema = "reto", name = "reto_appoinments_secuence", sequenceName = "reto_appoinments_secuence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reto_appoinments_secuence")
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date_a")
	private LocalDate date;

	@JsonFormat(pattern = "HH:mm")
	@Column(name = "hour_a")
	private LocalTime hour;

	@ManyToOne
	@JoinColumn(name = "id_test")
	private TestModel test;

	@ManyToOne
	@JoinColumn(name = "id_affiliate")
	private AffiliatesModel affiliate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public TestModel getTest() {
		return test;
	}

	public void setTest(TestModel test) {
		this.test = test;
	}

	public AffiliatesModel getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(AffiliatesModel affiliate) {
		this.affiliate = affiliate;
	}

}
