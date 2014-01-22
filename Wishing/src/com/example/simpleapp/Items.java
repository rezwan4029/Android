package com.example.simpleapp;

import java.util.Date;

public class Items {
	private String ItemName ;
	private Date dt ;
	public Items(String itemName, Date dt) {
		super();
		ItemName = itemName;
		this.dt = dt;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	
}
