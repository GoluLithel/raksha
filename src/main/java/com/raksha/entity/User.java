package com.raksha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 20)
	private String fname;
	
	@Column(length = 20)
	private String mname;
	
	@Column(length = 20)
	private String lname;
	
	@Column(unique=true) 
	private String gmail;
	
	@Column(name="mobile_no", unique=true)
	private String mobileNo;
	
	@Column(name="photo_id_type")
	private String photoIdType;
	
	@Column(name="photo_id")
	private String photoId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhotoIdType() {
		return photoIdType;
	}

	public void setPhotoIdType(String photoIdType) {
		this.photoIdType = photoIdType;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	
}
