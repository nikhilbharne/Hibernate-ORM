package com.ms.app.test;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ms.app.domain.Student;

public class LoadTest {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session ses = null;
		Transaction tx = null;
		Student st = null;
		// int sid = 0;

		// Create configuration object
		cfg = new Configuration().configure("/com/ms/app/config/hibernate.cfgs.xml");

		// Create SessionFactory object
		sf = cfg.buildSessionFactory();

		// Create Open Session Object
		ses = sf.openSession();

		// Load Object
		st = (Student) ses.load(Student.class, 1);
		System.out.println(st.getSid() + " " + st.getName() + " " + st.getCourse() + " " + st.getAddress());
		st = (Student) ses.load(Student.class, 10);
		System.out.println(st.getSid() + " " + st.getName() + " " + st.getCourse() + " " + st.getAddress());
		st = (Student) ses.load(Student.class, 4);
		System.out.println(st.getSid() + " " + st.getName() + " " + st.getCourse() + " " + st.getAddress());
		// System.out.println(st.toString());

		// close session & sf object
		ses.close();
		sf.close();

	}

}
