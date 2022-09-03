package criteriaAPI;

import idGenerationStrategy.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch10 {
    public static void main(String[] args) {
        //CRUD
        //C- create -insert -->save
        //R- select - get method and select HQL and SQL queries
        //U- we will see
        //D- we use delete method and DELETE sql/hql queries



        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        String hqlQuery = "from Student10 where mathGrade>50";
        List<Student10> resultList = session.createQuery(hqlQuery).list();
        //resultList.forEach(System.out::println);


        //How to use parameter in HQL
//        Long studentId =10L;
//        Query query = session.createQuery("FROM Student10 s where s.id=: id");
//        query.setParameter("id", studentId);
//        List<Student10> resultList2 = query.getResultList();
//        resultList2.forEach(System.out::println);
//
//        String hqlQuery2 = "Select sum(mathGrade) from Student10 where mathGrade>90";
//        Long sumMathGrade  = (Long) session.createQuery(hqlQuery2).uniqueResult();
//
//        System.out.println("Total math Grade: "+sumMathGrade );
//
//        int mathGrade  = 90;
//        String hqlQuery3 = "Select avg(mathGrade) from Student10 where mathGrade>:mathGrade";
//        Query query2 = session.createQuery(hqlQuery3);
//        query2.setParameter("mathGrade", mathGrade);
//        Double avgMathGrade  = (Double) query2.uniqueResult();
//
//        System.out.println("AVG math Grade: "+avgMathGrade );
//
//        Student10 student = session.get(Student10.class, 1L);
//        student.setName("Updated "+student.getName());
//        session.update(student);
//
//        String hqlQuery4="UPDATE Student10 s SET s.name ='Updated with HQL' where id =11";
//        int  numOfRecords = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Number of effected row count: "+numOfRecords);
//
//        String hqlQuery5 = "FROM Student10 s WHERE s.mathGrade <50";
//        List<Student10> resultList3 =  session.createQuery(hqlQuery5).getResultList();
//        for (Student10 s:resultList3){
//            s.setMathGrade(50);
//            session.update(s);
//        }
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Student10> criteriaQuery =  cb.createQuery(Student10.class);
//        Root<Student10>   root = criteriaQuery.from(Student10.class);
//
//        //criteriaQuery.select(root);
//        //criteriaQuery.select(root).where(cb.equal(root.get("name"), "Name 16"));
//
//        Predicate predicateForName = cb.equal((root.get("name")), "Name 10");
//        Predicate predicateForMathGradeGt80 =cb.greaterThan(root.get("mathGrade"), 80);
//        Predicate predicateStd = cb.or(predicateForName, predicateForMathGradeGt80);
//        criteriaQuery.where(predicateStd);
//
//        Query<Student10> query1 = session.createQuery(criteriaQuery);
//        List<Student10> resultList7 = query1.getResultList();
//        resultList7.forEach(System.out::println);

        CriteriaBuilder cb2 = session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery2 = cb2.createQuery(Integer.class);
        Root<Student10> root2 = criteriaQuery2.from(Student10.class);
        criteriaQuery2.select(cb2.sum(root2.get("mathGrade")));
        TypedQuery<Integer> typedQuery = session.createQuery(criteriaQuery2);

        Integer totalMathGrade = typedQuery.getSingleResult();
        System.out.println("Total MathGrade : " +totalMathGrade);



        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
