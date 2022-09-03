package caching;

import criteriaAPI.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {


        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        //if you same identifier in the same session ,record will be get from the 1. level cache for the second fetch
        Student11 student1=session.get(Student11.class, 1);

        //clear the cache
        //session.clear();

        //Student11 student2=session.get(Student11.class, 1);

        //Student11 student2=session.get(Student11.class, 2);




        tx.commit();

        //close session1
        session.close();



        Session session2= sf.openSession();
        Transaction tx2= session2.beginTransaction();

        Student11 student3=session2.get(Student11.class, 1);


        tx2.commit();
        //closing session2
        session2.close();



        sf.close();

    }
}
