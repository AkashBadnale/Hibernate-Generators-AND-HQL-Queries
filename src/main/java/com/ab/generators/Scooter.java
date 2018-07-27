package com.ab.generators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Scooter {

	@Id
	/*  Dont know how to use these */
	/*@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
	@TableGenerator(name="id_generator", table="person", schema="test1")*/
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String name;
	private int engineCapacity;
	public Scooter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Scooter(String name , int engineCapacity) {
		  this.name =	name;
		  this.engineCapacity = engineCapacity;
		}
	
	public Scooter(int id, String name, int engineCapacity) {
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
		return "Scooter [id=" + id + ", name=" + name + ", engineCapacity=" + engineCapacity + "]";
	}
}//Scooter
