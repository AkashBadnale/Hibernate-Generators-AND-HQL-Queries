package com.ab.hqlQueries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ab.utilities.HibernateUtil;

public class TestingHQLQueries {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		Transaction tx = null;
		List<EmployeeDetails> listOfEmployees1 = null;
		List<EmployeeDetails> listOfEmployees2 = null;
		EmployeeDetails employee = null;
		EmployeeDetails employee2 = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			/*    equivalent  to  ==    select *  from employee_details ;   */
			listOfEmployees1 = session.createQuery("from EmployeeDetails").list();
			for (EmployeeDetails emps : listOfEmployees1) {
				System.out.println(emps.getId()+"\t"+emps.getName()+"\t"+emps.getDepartment()+"\t"+emps.getEmail());
			}//forEach
		   
			/*  equivalent  to  ==  select name , department , email from employee_details ;  */
			Query query = session.createQuery("select emp.name , emp.department , emp.email from EmployeeDetails  emp");
			List<Object[]> rows = query.getResultList();
			for (Object[] objects : rows) {
				System.out.println(objects[0]+"\t"+objects[1]+"\t"+objects[2]);
			}
			//System.out.println(listOfEmployees2);
			//below code is not working
			/*for (EmployeeDetails emps :  listOfEmployees2) {
				System.out.println(emps.getName()+"\t"+emps.getDepartment()+"\t"+emps.getEmail());
			}//forEach*/			
			
			/*  equivalent to  ==  select * from employee_details where id=5;  */
			employee = (EmployeeDetails) session.createQuery("from EmployeeDetails e  where e.id=5 ").getSingleResult();
			System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getDepartment()+"\t"+employee.getEmail());
			
			/*  equivalent to  ==  select * from employee_details where name='G';  */
			employee2 = (EmployeeDetails) session.createQuery("from EmployeeDetails e  where e.name='G' ").getSingleResult();
			System.out.println(employee2.getId()+"\t"+employee2.getName()+"\t"+employee2.getDepartment()+"\t"+employee2.getEmail());
			
			/*  equivalent to ==  select * from employee_details where id > 10*/
			listOfEmployees2 = session.createQuery("FROM EmployeeDetails e WHERE e.id > 5").getResultList();
			for (EmployeeDetails emps : listOfEmployees2) {
				System.out.println(emps.getId()+"\t"+emps.getName()+"\t"+emps.getDepartment()+"\t"+emps.getEmail());
			}
			
			/*  equivalent to == update employee_details set password='j123.321j' where id=10; */
			Query query3 = session.createQuery("update EmployeeDetails  set password=:pwd where id=:id");
			query3.setParameter("pwd", "j123.321j");
			query3.setParameter("id", 10);
			int result = query3.executeUpdate();
			System.out.println(" Rows affected "+result);
			
			
			HibernateUtil.flushNcommit(session, tx);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}//main
}//TestingHQLQueries
