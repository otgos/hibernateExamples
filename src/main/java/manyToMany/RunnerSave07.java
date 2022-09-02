package manyToMany;

import biDirectionalOneToMany.Book06;
import biDirectionalOneToMany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave07 {
    public static void main(String[] args) {

        Book07 book1 = new Book07();
        Book07 book2 = new Book07();

        book1.setId(101);
        book1.setBookName("Art Book");
        book1.setBookType(BookType.ART);

        book2.setId(102);
        book2.setBookName("CALCULUS01");
        book2.setBookType(BookType.MATH);

        Student07 student1 = new Student07();
        Student07 student2 = new Student07();
        Student07 student3 = new Student07();

        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);


        List<Book07> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);
        student1.setBooks(bookList1);

        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(9);


        List<Book07> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        student2.setBooks(bookList2 );

        student3.setId(1003);
        student3.setName("Tony Blaire");
        student3.setGrade(11);


        List<Book07> bookList3 = new ArrayList<>();
        bookList3.add(book1);
        bookList3.add(book2);
        student3.setBooks(bookList3);

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);


        //
        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }
}
