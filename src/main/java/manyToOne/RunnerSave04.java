package manyToOne;

import annotations.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {
        Student04 student1=new Student04();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);

        Student04 student2=new Student04();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(11);

        Student04 student3=new Student04();
        student3.setId(1003);
        student3.setName("Tony Stark");
        student3.setGrade(11);

        University university=new University();
        university.setId(1);
        university.setName("TPE Tech");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);


        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(University.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(university);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        //
        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
