package com.maheshkumarvaka.employeeapp.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private BigInteger phone;
	
	@OneToOne(targetEntity=Department.class)	
	private Department department;
	
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_on")
	private Date createdOn;

}
