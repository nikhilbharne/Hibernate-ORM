package com.ms.app.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ms.app.domain.Student;

public class UpdateTest {
	public static void main(String[] args) throws Exception {
		System.out.println("Hibernate Main Method");
		Configuration cfg = null;
		Session ses = null;
		SessionFactory sf = null;
		Student st = null;
		org.hibernate.Transaction tx = null;
		int idVal = 0;

		// BootStrap HB frmaeworks
		cfg = new Configuration();

		// Read hinernate configuration Fie Into pckg
		cfg.configure("com/ms/app/config/hibernate.cfgs.xml");

		// Create SessionFactory Object
		sf = cfg.buildSessionFactory();

		// get current session
		ses = sf.openSession();

		// Create Domain class Object
		st = new Student();
		st.setSid(5);
		st.setName("Rohu");
		st.setCourse("C++");
		st.setAddress("Gondia");

		// Create Transaction object
		try {
			tx =ses.beginTransaction();
			ses.update(st);
			tx.commit();
			System.out.println("Student Object are Updated");
			System.out.println(st.getSid());
			System.out.println(st.getName());
			System.out.println(st.getCourse());
			System.out.println(st.getAddress());
			

		} catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
			System.out.println("Object are Not Updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Object are Not updated");
		} finally {
			ses.close();
			sf.close();
			System.out.println("Session Are Closed");

		}

	}

}
