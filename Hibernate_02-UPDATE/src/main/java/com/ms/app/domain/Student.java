package com.ms.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "STUDENT_NEW")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	public Student() {
		System.out.println("0-param Constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SID")
	private int sid;
	
	@Column(name = "NAME", length = 10)
	@Type(type = "string")
	private String name;
	
	@Column(name = "COURSE", length = 10)
	@Type(type="string")
	private String course;
	
	@Column(name="Address",length=10)
	@Type(type="string")
	private String address;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
