package com.ms.app.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ms.app.domain.Student;

public class SaveTest {

	public static void main(String[] args) throws Exception {
		System.out.println("main Method Started");
		Configuration cfgs = null;
		SessionFactory sf = null;
		Session ses = null;
		Student st = null;
		org.hibernate.Transaction tx = null;
		int idVal = 0;
		boolean flag = false;
		// BootStrap HB frameWork
		cfgs = new Configuration().configure("com/ms/app/cfgs/hibernate.cfgs.xml");

		// Create SessionFactory Object
		sf = cfgs.buildSessionFactory();

		// Create Session Object
		ses = sf.openSession();

		// Create Domain Class Object and prepare It
		st = new Student();
		//st.setSid(10);
		st.setName("Namdev");
		st.setCourse("SOAP");
		st.setAddress("AUR");
		try {
			tx = ses.beginTransaction();
			idVal = (Integer) ses.save(st);
			tx.commit();
			System.out.println("Student record are Saved");
			System.out.println("Id val" + idVal);
			System.out.println(Student.class);
			System.out.println(st.getSid()+" "+st.getName()+" "+st.getCourse()+" "+st.getAddress());

		} catch (HibernateException he) {
			tx.rollback();
			System.out.println("Object are Not Saved");
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ses.close();
			sf.close();
		}

	}

}
