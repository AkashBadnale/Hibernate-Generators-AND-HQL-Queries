package com.ab.generators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Bicycle {

	@Id
	//@SequenceGenerator(name="mySqGen", sequenceName="mySq", initialValue=5, allocationSize=300 )
	//@GeneratedValue (generator="mySqGen")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private int engineCapacity;
	public Bicycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bicycle(String name , int engineCapacity) {
		  this.name =	name;
		  this.engineCapacity = engineCapacity;
		}
	
	public Bicycle(int id, String name, int engineCapacity) {
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
		return "Bicycle [id=" + id + ", name=" + name + ", engineCapacity=" + engineCapacity + "]";
	}
}//Bicycle
