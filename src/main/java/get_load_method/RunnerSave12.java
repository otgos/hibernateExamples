package caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        Student11 student11 = new Student11();
        student11.setMathGrade(80);
        student11.setName("John Coffee");

        Student11 student12 = new Student11();
        student12.setMathGrade(70);
        student12.setName("James Bond");

        Student11 student13 = new Student11();
        student13.setMathGrade(90);
        student13.setName("John Coffee");

        session.save(student11);
        session.save(student12);
        session.save(student13);

        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
