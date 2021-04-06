package com.school.application.dtos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.school.application.enums.YearOfStudy;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  	// Required as the PK needs to be increased each time
    private Integer 	id;
    private String 		studentNumber;
    private String 		forename;
    private String 		surname;
    private Date 		dateOfBirth;
    @Enumerated(EnumType.ORDINAL)
    private YearOfStudy 		yearOfStudy;			// https://www.baeldung.com/jpa-persisting-enums-in-jpa


    public Student() {
        super();
    }


    public Student(Integer id, String studentNumber, String forename, String surname, Date dateOfBirth,	YearOfStudy yearOfStudy) {
        super();
        this.id = id;
        this.studentNumber = studentNumber;
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


    public String getStudentNumber() {
        return studentNumber;
    }


    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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


    public YearOfStudy getYearOfStudy() {
        return yearOfStudy;
    }


    public void setYearOfStudy(YearOfStudy yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", forename=" + forename + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
                + ", yearOfStudy=" + yearOfStudy + "]";
    }

}
