package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        Student07 student1 = session.get(Student07.class, 1001);

        System.out.println(student1);
        for(Book07 book: student1.getBooks()){
            System.out.println(book);
            for(Student07 std : book.getStudents()){
                System.out.println(std);
            }
        }

        //fetch Student names

        String hqlQuery = "SELECT s.name FROM Student07 s";
        List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();
        System.out.println(resultList);

        String hqlQuery1 = "SELECT s.name, b.bookName FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=1001";
        List <Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
        for(Object[] obj : resultList1){
            System.out.println(Arrays.toString(obj));
        }

        //
        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }
}
