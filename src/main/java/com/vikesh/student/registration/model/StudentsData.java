package com.vikesh.student.registration.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students_data")
public class StudentsData {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "BIGINT(20)")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dob")
	private Date dob;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "qualification", columnDefinition = "BIGINT(20)")
	private String qualification;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobile_no")
	private String mobile_no;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileno() {
		return mobile_no;
	}

	public void setMobileno(String mobileno) {
		this.mobile_no = mobileno;
	}

	
}
