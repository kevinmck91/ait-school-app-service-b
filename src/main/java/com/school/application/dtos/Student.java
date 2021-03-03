package com.school.application.dtos;

public class Student {

	private Integer 	id;
	private String 		forename;
	private String 		surname;
	private String 		dateOfBirth;
	private int 		yearOfStudy;
	
	
	public Student() {
		super();
	}

	public Student(Integer id, String forename, String surname, String dateOfBirth, int yearOfStudy) {
		super();
		this.id = id;
		this.forename = forename;
		this.surname = surname;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", forename=" + forename + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", yearOfStudy=" + yearOfStudy + "]";
	}
	
}
