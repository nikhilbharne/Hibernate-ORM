package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class BasicPersistTest {

	public static void main(String[] args) {
		System.out.println("main(-) method....");
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		// Activate HB framework/BootStraping hibernate
        cfg=new Configuration();
        System.out.println(cfg.getProperties());
        
        //Locate HB cfg ,mapping files..
        cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
        //cfg.configure();
        
        //create SessionFactory object
        factory=cfg.buildSessionFactory();
        
        
        //create HB Session object
        ses=factory.openSession();
        System.out.println("session obj class name::"+ses.getClass());
        
        //prepared Domain class object
        emp=new Employee();
        emp.setEid(1077); emp.setFirstName("Raja");
        emp.setLastName("rao"); emp.setEmail("rao@gmail.com");
        emp.setSalary(9000);
        System.out.println("----------------------");
        
        try{
        //Begin Tx
         tx=ses.beginTransaction();  //internally calls con.setAutoCommit(false)
           //save object
           ses.persist(emp);
           System.out.println("-------------------");
         flag=true;
        }
        catch(HibernateException he){
        	flag=false;
        }
        catch(Exception e){
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
