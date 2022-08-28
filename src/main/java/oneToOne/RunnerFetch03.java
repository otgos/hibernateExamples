package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Diary diary = session.get(Diary.class, 101);
        System.out.println(diary.getStudent());
        Student03 student = session.get(Student03.class, 1001);
        System.out.println(student.getDiary());


        String hqlQuery ="SELECT s.name,d.name FROM Student03 s INNER JOIN FETCH Diary d on s.id=d.student";

        List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();
        for(Object[] obj: resultList ){
            System.out.println(Arrays.toString(obj));
        }

        String hqlQuery2 = "From Student03 s INNER JOIN FETCH s.diary";
        List<Student03>  resultLust2 = session.createQuery(hqlQuery2).getResultList();
        for(Student03 std: resultLust2){
            System.out.println(std);
        }

        String hqlQuery3 = "From Diary d INNER JOIN FETCH d.student";
        List<Diary>  resultLust3 = session.createQuery(hqlQuery3).getResultList();
        for(Diary d: resultLust3){
            System.out.println(d);
        }

        String hqlQuery4 = "SELECT new oneToOne.CustomResult(s.name,d.name) FROM Student03 s inner join fetch Diary d on s.id=d.student";
        List <CustomResult> results = session.createQuery(hqlQuery4).list();
        for(CustomResult r:results){
            System.out.println(r);
        }


        tx.commit();
        //we have to call session close
        session.close();
        sf.close();
    }
}
