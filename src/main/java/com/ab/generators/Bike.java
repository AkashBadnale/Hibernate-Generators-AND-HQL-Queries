package com.ab.generators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int engineCapacity;

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bike(String name , int engineCapacity) {
	  this.name =	name;
	  this.engineCapacity = engineCapacity;
	}
	
	public Bike(int id, String name, int engineCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.engineCapacity = engineCapacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", engineCapacity=" + engineCapacity + "]";
	}

}// Bike
