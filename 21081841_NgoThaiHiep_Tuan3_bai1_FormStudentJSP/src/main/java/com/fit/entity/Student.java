package com.fit.entity;

import java.util.Arrays;

public class Student {
	private String fName;
	private String lName;
	private String birthDay;
	
	private String email;
	private String mobileNum;
	private String gender;
	private String address;
	private String city;
	private String pinCode;
	private String state;
	private String country;
	private String[] hobbies;
	private String course;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public Student(String fName, String lName, String birthDay, String email, String mobileNum, String gender,
			String address, String city, String pinCode, String state, String country, String[] hobbies,
			String course) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.birthDay = birthDay;
		this.email = email;
		this.mobileNum = mobileNum;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.hobbies = hobbies;
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", birthDay=" + birthDay + ", email=" + email
				+ ", mobileNum=" + mobileNum + ", gender=" + gender + ", address=" + address + ", city=" + city
				+ ", pinCode=" + pinCode + ", state=" + state + ", country=" + country + ", hobbies="
				+ Arrays.toString(hobbies) + ", course=" + course + "]";
	}
	public Student() {
		super();
	}
	
}
