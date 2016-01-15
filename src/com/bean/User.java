
package com.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Repository;







/**
 *
 * @author niraj.kumar
 */

public class User {


private int	custId ;

@NotEmpty(message = "Please enter Customer Code")
@Size(max = 10, message = "Your Customer Code must between 1 and 10 characters")
private String custCode ;

@NotEmpty(message = "Please enter Customer Name.")
@Size(max = 30, message = "Your Customer Name must between 1 and 30 characters")
private String custName;


@NotEmpty(message = "Please enter Customer Address.")
@Size(max = 100, message = "Your Customer Address must between 1 and 100 characters")
private String custAddr1;

@Size(max = 100, message = "Your Customer Address must between 1 and 100 characters")
private String	custAddr2;


@NotEmpty(message="Please enter Pin Number.")
@Size(min=6, max=6,  message = "Pin Number should be of 6 numbers")
@Pattern(regexp = "^[0-9]*$" , message="Enter numbers only")
private String	custPin;

@NotEmpty(message = "Please enter Email.")
@Size(max = 100, message = "Your Email must between 1 and 100 characters")
@Email(message = "Please Enter correct Email")
private String	email;
/*
@Size(max=10,  message = "Contact Number should be of 10 numbers")
@Pattern(regexp = "^[0-9]*$" , message="Enter numbers only")*/
private int	contact;


@NotEmpty(message = "Please enter Contact Person Details.")
@Size(max=100, message = "Your Contact Person Details must between 1 and 100 characters")
private String	primaryContactPerson;


private String	recordStatus;


@NotEmpty(message = "Please enter Flag either I or A.")
@Size(max=1, message = "Your Flag must be either I or A.")
private String	flag;
//@NotNull
private String createDate;
//@NotNull
private String createdBy;
private String modifiedDate;
private String modifiedBy;
private String authorizedDate;
private String authorizedBy;
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustCode() {
	return custCode;
}
public void setCustCode(String custCode) {
	this.custCode = custCode;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getCustAddr1() {
	return custAddr1;
}
public void setCustAddr1(String custAddr1) {
	this.custAddr1 = custAddr1;
}
public String getCustAddr2() {
	return custAddr2;
}
public void setCustAddr2(String custAddr2) {
	this.custAddr2 = custAddr2;
}
public String getCustPin() {
	return custPin;
}
public void setCustPin(String custPin) {
	this.custPin = custPin;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getContact() {
	return contact;
}
public void setContact(int contact) {
	this.contact = contact;
}
public String getPrimaryContactPerson() {
	return primaryContactPerson;
}
public void setPrimaryContactPerson(String primaryContactPerson) {
	this.primaryContactPerson = primaryContactPerson;
}
public String getRecordStatus() {
	return recordStatus;
}
public void setRecordStatus(String recordStatus) {
	this.recordStatus = recordStatus;
}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}
public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(String modifiedDate) {
	this.modifiedDate = modifiedDate;
}
public String getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public String getAuthorizedDate() {
	return authorizedDate;
}
public void setAuthorizedDate(String authorizedDate) {
	this.authorizedDate = authorizedDate;
}
public String getAuthorizedBy() {
	return authorizedBy;
}
public void setAuthorizedBy(String authorizedBy) {
	this.authorizedBy = authorizedBy;
}
}