package criteriaAPI;

import idGenerationStrategy.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave10 {
    public static void main(String[] args) {

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        Random r = new Random();
        for (int i =1; i<=50; i++){
            Student10 student = new Student10();
            student.setName("Name "+i);
            student.setMathGrade((r.nextInt(100)));
            session.save(student);
        }

        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
