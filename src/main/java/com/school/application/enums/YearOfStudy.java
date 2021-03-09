package com.school.application.enums;

public enum YearOfStudy {

	YEAR_0(0), YEAR_1(1), YEAR_2(2), YEAR_3(3);
	private int year;

	private YearOfStudy(int year) {
	        this.year = year;
	    }

	public int getYear() {
		return year;
	}

}
