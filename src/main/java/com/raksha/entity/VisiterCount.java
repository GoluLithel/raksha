package com.raksha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "visiter_count")
public class VisiterCount {
	
	@Id
	@Column
	private int id;
	@Column
	private int userVisitedCount;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserVisitedCount() {
		return userVisitedCount;
	}
	
	public void setUserVisitedCount(int userVisitedCount) {
		this.userVisitedCount = userVisitedCount;
	}

}
