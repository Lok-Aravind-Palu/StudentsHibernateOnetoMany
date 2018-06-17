package com.apptrics.studentdetailswork.HibernateOnetoMany;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.apptrics.studentdetailswork.pojo.College;
import com.apptrics.studentdetailswork.pojo.Students;

public class HibernateConfigaration {

	public static SessionFactory sessionfactory;
	public static Session session;
	static Scanner s = new Scanner(System.in);
	static Students sd = new Students();
	static College c = new College();

	@SuppressWarnings("deprecation")
	public static void connectDB() {
		Configuration configure = new Configuration().configure("HibernateConfigaration.cfg.xml");
		sessionfactory = configure.buildSessionFactory();
		System.out.println("Connected to the DataBase");
	}

	public static void insertValues() {
		Students s1= new Students();
		s1.setName("Yash");
		s1.setDept("EC");
		
		Students s2= new Students();
		s2.setName("Aravind");
		s2.setDept("EC");
		
		Set<Students> set = new HashSet<Students>();
		set.add(s1);
		set.add(s2);
		
		College co = new College();
		co.setId(1);
		co.setCollegeName("AES");
		co.setStudent(set);

		try {
			session = sessionfactory.openSession();
			

			Transaction transaction = session.getTransaction();
			
			transaction.begin();
			co.getStudent().forEach(student->{
				session.save(student);
			});
			session.save(co);
			session.save(sd);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	
}
