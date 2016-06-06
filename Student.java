package com.restsecurity.programtic.example.model;


public class Student {
 String firstName, lastName;
 String school;
 int id;
 int standard;
 private SecurityMessage securityMessage;
  
 
public SecurityMessage getSecurityMessage() {
	return securityMessage;
}
public void setSecurityMessage(SecurityMessage securityMessage) {
	this.securityMessage = securityMessage;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getStandard() {
	return standard;
}
public void setStandard(int standard) {
	this.standard = standard;
}
 
}
