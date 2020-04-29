package com.hsbg.test;

public class ForeignClass {

	private String id;
	private String name;
	private String place;
	
	public ForeignClass() {
		super();
	}
	
	public ForeignClass(String id, String name, String place) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
}
