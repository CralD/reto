package com.example.reto.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppoinmentsDTO {
	private Long id;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime hour;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	private Long idTest;
	private Long idAffiliate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public Long getIdAffiliate() {
		return idAffiliate;
	}

	public void setIdAffiliate(Long idAffiliate) {
		this.idAffiliate = idAffiliate;
	}

}
