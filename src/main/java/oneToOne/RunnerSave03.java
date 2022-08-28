package oneToOne;

import embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        Diary diary3 = new Diary();
        Student03 student1 = new Student03();
        student1.setId(1001);
        student1.setName("Tom Hanks");
        student1.setGrade(11);

        Student03 student2 = new Student03();
        student2.setId(1002);
        student2.setName("Mel Gibson");
        student2.setGrade(10);

        Student03 student3 = new Student03();
        student3.setId(1003);
        student3.setName("John Trovalto");
        student3.setGrade(9);


        diary1.setId(101);
        diary1.setName("Toms Diary");
        diary1.setStudent(student1);

        diary2.setId(102);
        diary2.setName("no body's diary");

        diary3.setName("John's diary");
        diary3.setId(103);
        diary3.setStudent(student3);



        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(diary3);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        tx.commit();
        //we have to call session close
        session.close();
        sf.close();
    }
}
