package entityLifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//        Student13 student11 = new Student13();
//        student11.setMathGrade(80);
//        student11.setName("John Coffee");
//
//        Student13 student12 = new Student13();
//        student12.setMathGrade(80);
//        student12.setName("James Bond");
//
//        Student13 student13 = new Student13();
//        student12.setMathGrade(80);
//        student12.setName("Tony Stark");

        Student13 student4 = session.get(Student13.class, 1);
//        student4.setName("Blla blaaBlaa");
        session.evict(student4);
        session.update(student4);
        student4.setName("After Evict");

        session.delete(student4);

//        session.save(student11);
//        session.save(student12);
//        session.persist(student13);
        //student12.setName("James Bond is in Persisted state");

        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();

//        student13.setName("Tom hanks");

        sf.close();

    }
}
