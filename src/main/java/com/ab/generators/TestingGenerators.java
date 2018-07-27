package com.ab.generators;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ab.utilities.HibernateUtil;

public class TestingGenerators {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Session session = null;
		Transaction tx = null;
		
		Bike bike1 = new Bike("FZ16", 153);
		Bike bike2 = new Bike("Avengers",220);
		Bike bike3 = new Bike("CBR",250);
		
		Car car = new Car("Nissan GT", 9000);
		Car car1 = new Car("Ford Mustang",3800);
		Car car2 = new Car("Porche 911",10800);
		Car car3 = new Car("Jaguar F-TYPE",9000);
		Car car4 = new Car("Chevrolet Camaro", 5000);
		
		Bicycle bicycle1 = new Bicycle("Atlas",12);
		Bicycle bicycle2 = new Bicycle("Atlas sport",15);
		Bicycle bicycle3 = new Bicycle("Atlas GearBike",20);
		
		Scooter scooter1 = new Scooter("Scooter",149);
		Scooter scooter2 = new Scooter("Maestro",150);
		Scooter scooter3 = new Scooter("pep+",110);
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/*session.save(bike1);
			session.save(bike2);
			session.save(bike3);*/
			
			/*session.save(car);
			session.save(car1);
			session.save(car2);
			session.save(car3);
			session.save(car4);*/
			
			/*session.save(bicycle1);
			session.save(bicycle2);
			session.save(bicycle3);*/
			
			session.save(scooter1);
			session.save(scooter2);
			session.save(scooter3);
			
			HibernateUtil.flushNcommit(session, tx);
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}//main
}//TestingGenerators
