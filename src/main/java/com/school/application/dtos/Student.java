package com.school.application.dtos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Integer 	id;
	private String 		forename;
	private String 		surname;
	private Date 		dateOfBirth;
	private String		status;
	private int 		yearOfStudy;
	
	
	public Student() {
		super();
	}

	public Student(Integer id, String forename, String surname, Date dateOfBirth, String status, int yearOfStudy) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.status = status;
		this.dateOfBirth = dateOfBirth;
		this.yearOfStudy = yearOfStudy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", forename=" + forename + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", yearOfStudy=" + yearOfStudy + "]";
	}
	
}
