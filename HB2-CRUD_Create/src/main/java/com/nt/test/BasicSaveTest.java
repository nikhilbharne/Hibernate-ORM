package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class BasicSaveTest {

	public static void main(String[] args) {
		//BootStrap HB FrameWork
		Configuration cfg=new Configuration();
		//Read Mapping Resource
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		
		//create sesionFactory Object
		SessionFactory sf=cfg.buildSessionFactory();
		
		//create Seesion Object
		Session s=sf.openSession();
		
		//Create Domain class Object
		Employee emp=new Employee();
		//emp.setEid(101);
		emp.setFirstName("Heena");
		emp.setLastName("Bharne");
		emp.setSalary(10000);
		/*
		emp.setFirstName("Nikhil");
		emp.setLastName("Bharne");
		emp.setSalary(20000);*/
		
		//create Transaction Object and Begin
		Transaction tx=s.beginTransaction();
		s.save(emp);
		tx.commit();
		
		System.out.println("Object is Save To Database");
		
		s.close();
		
		sf.close();
		

	}

}
