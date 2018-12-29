package com.ms.app.test;

import javax.transaction.Transaction;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ms.app.domain.Student;

public class LoadTest2 {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session ses = null;
		Transaction tx = null;
		Student st = null;
		// Create Configuration Object
		cfg = new Configuration().configure("/com/ms/app/config/hibernate.cfgs.xml");

		// Create SessionFactory Object
		sf = cfg.buildSessionFactory();

		// Create Session Object
		ses = sf.openSession();

		// Create Domain Class Object
		st = new Student();

		try {
			//tx = (Transaction) ses.beginTransaction();
			st = (Student) ses.load(Student.class, 11);
			
			System.out.println(st.getSid()+" "+st.getName()+" "+st.getCourse()+" "+st.getAddress());
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ses.close();
			sf.close();
		}

	}

}
