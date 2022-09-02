package fetchTypes;

import biDirectionalOneToMany.Book06;
import biDirectionalOneToMany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 student1=new Student08();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);

        Student08 student2=new Student08();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(11);

        Student08 student3=new Student08();
        student3.setId(1003);
        student3.setName("Tony Stark");
        student3.setGrade(11);

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setBookName("John's Art book");
        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setBookName("John's Math book");
        Book08 book3 = new Book08();
        book3.setId(103);
        book3.setBookName("Jame's Java book");

        student1.getBook().add(book1);
        student1.getBook().add(book2);
        student2.getBook().add(book3);

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);


        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();



        session.save(student1);
        session.save(student2);
        session.save(student3);
//

        //
        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
