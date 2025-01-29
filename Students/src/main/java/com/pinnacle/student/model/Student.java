package com.pinnacle.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String college;
	private String address;
	private String contactNo;
	private String parentContactNo;
	private String course;
	private Double fees;
	private Double paidFees;
	private Double balanceFees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getParentContactNo() {
		return parentContactNo;
	}

	public void setParentContactNo(String parentContactNo) {
		this.parentContactNo = parentContactNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(Double paidFees) {
		this.paidFees = paidFees;
	}

	public Double getBalanceFees() {
		return balanceFees;
	}

	public void setBalanceFees(Double balanceFees) {
		this.balanceFees = balanceFees;
	}

	/*
	 * public Invoice(Long id, String name, String location, Double amount) {
	 * super(); this.id = id; this.name = name; this.location = location;
	 * this.amount = amount; } public Invoice() { super();
	 * 
	 * }
	 */

}
