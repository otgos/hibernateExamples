package entityLifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {
    public static void main(String[] args) {


        //when to use load method: if we need data and
        // we do not need see the data, we can delete using the reference..
        // because we are sure that the data exists



        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//        System.out.println("Start to execute get method...");
//
//        Student12 student1 = session.get(Student12.class, 10);
//        System.out.println("Finish to execute get mehtod...");
//
//        if(student1!=null){
//            System.out.println("Student ID: " +student1.getId());
//            System.out.println("Student get name: "+student1.getName());
//        }
//
//        System.out.println("---------------------------------------------");
//
//        System.out.println("Start to execute load method....");
//        Student12 student2 =session.load(Student12.class, 20);
//        System.out.println("Finis to execute load method...");
//
//       if(student2!=null){
//           System.out.println("Student ID: " +student2.getId());
//           System.out.println("Student get name: "+student2.getName());
//       }

        //load method makes it faster, because it just brings the reference... we do not see the detail
        //we can create relation with other object with load method
        Student13 student3 = session.load(Student13.class, 1);
        session.delete(student3);

        tx.commit();

        //close session1
        session.close();

        sf.close();

    }
}
