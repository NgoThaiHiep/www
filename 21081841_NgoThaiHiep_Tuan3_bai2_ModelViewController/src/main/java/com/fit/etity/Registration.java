package com.fit.etity;

public class Registration {
	private String fName;
	private String lName;
	private String Email;
	private String password;
	private String birthDay;
	private String Gender;
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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Registration(String fName, String lName, String email, String password, String birthDay, String gender) {
		super();
		this.fName = fName;
		this.lName = lName;
		Email = email;
		this.password = password;
		this.birthDay = birthDay;
		Gender = gender;
	}
	public Registration() {
		super();
	}
	
}
