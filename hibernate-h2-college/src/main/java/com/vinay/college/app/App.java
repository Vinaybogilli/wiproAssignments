package com.vinay.college.app;


import com.vinay.college.model.Student;
import com.vinay.college.model.Student.Gender;
import com.vinay.college.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Student s = new Student();
        s.setRollNo(101);
        s.setFirstName("Vinay");
        s.setLastName("Bogilli");
        s.setUsername("vinay_b");
        s.setGender(Gender.MALE);
        s.setAddress("Hyderabad");
        s.setRegisteredDate(new Date());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();
        session.close();

        System.out.println("Student saved successfully.");
    }
}

