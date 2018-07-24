package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class BasicSaveTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		int idVal=0;
		boolean flag=false;
		
		//Activate/BootStrap Hibernate Framework
		cfg=new Configuration();
		
		//Read Configuration file and Mapping File
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//Create SessionFactory Object
		factory=cfg.buildSessionFactory();
		
		//create HB session Object
		ses=factory.openSession();
		
		//Prepare Domain Class Object
		emp=new Employee();
		emp.setEid(101);
		emp.setFirstName("Nikhil");
		emp.setLastName("Bharne");
		emp.setEmail("nikhil@gmail.com");
		emp.setSalary(50000);
		
		/*emp.setEid(102);
		emp.setFirstName("Heena");
		emp.setLastName("Bharne");
		emp.setEmail("heena@gmail.com");
		emp.setSalary(20000);*/
		
		 try{
		        //Begin Tx
		         tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
		           //save object
		           idVal=(Integer)ses.save(emp);
		           System.out.println("Id value::"+idVal);
		           System.out.println("-------------------");
		         flag=true;
		        }
		        catch(HibernateException he){
		        	he.printStackTrace();
		        	flag=false;
		        }
		        catch(Exception e){
		        	e.printStackTrace();
		        	flag=false;
		        }
		        finally{
		        	if(flag==true){
		        		tx.commit(); //Internally calls con.commit()
		        		System.out.println("Object is saved");
		        	}
		        	else{
		        		//tx.rollback();  //Internally calls con.rollback()
		        		System.out.println("Object is not saved");
		        	}
		        	//close session
		        	ses.close();
		        	//close sessionfactory
		        	factory.close();
		        }///finally
			}//main
		}//class
