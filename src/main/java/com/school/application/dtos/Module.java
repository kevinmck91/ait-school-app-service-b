package com.school.application.dtos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.school.application.enums.Departement;

@Entity
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long		id;
	private String 		moduleCode;
	private String 		name;
	@Enumerated(EnumType.STRING)
	private Departement	departement;
	private int			semester;
	private int			credits;
	private int			passMark;
	private boolean		passByCompensation;
	
	
	public Module() {
	}

	public Module(Long id, String moduleCode, String name, Departement departement, int semester, int credits, int passMark,	boolean passByCompensation) {
		this.id = id;
		this.moduleCode = moduleCode;
		this.name = name;
		this.departement = departement;
		this.semester = semester;
		this.credits = credits;
		this.passMark = passMark;
		this.passByCompensation = passByCompensation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getPassMark() {
		return passMark;
	}

	public void setPassMark(int passMark) {
		this.passMark = passMark;
	}

	public boolean isPassByCompensation() {
		return passByCompensation;
	}

	public void setPassByCompensation(boolean passByCompensation) {
		this.passByCompensation = passByCompensation;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", moduleCode=" + moduleCode + ", name=" + name + ", departement=" + departement
				+ ", semester=" + semester + ", credits=" + credits + ", passMark=" + passMark + ", passByCompensation="
				+ passByCompensation + "]";
	}
	
	
	
}
