package annotations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class RunnerFetch01 {

	public static void main(String[] args) {
		Student01 student1 = new Student01();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		//1st way to get data from the database
//		//if there is no record, get method gives null
//		student1  = session.get(Student01.class, 1001);
//		System.out.println(student1);
		
		
		//while we are writing sql, we use table name
		String sqlQuery1 = "SELECT *FROM t_student";
//		NativeQuery nativeQuery = session.createSQLQuery(sqlQuery1);
//		nativeQuery.getResultList();
		//they are the same
		List <Object[]> resultList1= session.createSQLQuery(sqlQuery1).getResultList();
		
		for(Object[] r: resultList1) {
			System.out.println(Arrays.toString(r));
		}
		
		//we use HQL query to fetch data 
		//in HQL always we use ClassName
		
		String hqlQuery ="FROM Student01";
		List resultList2 = session.createQuery(hqlQuery).getResultList();
		
		for(Object obj: resultList2) {
			System.out.println(obj.toString());
		}
		
		//sql query for where 
		String sqlQuery2 = "SELECT * FROM t_student where student_name='Brad Pitt'";
		List<Object[]> resultList3 = session.createSQLQuery(sqlQuery2).getResultList();
		
		for(Object[] r: resultList3) {
			System.out.println(Arrays.toString(r));
		}
		//hql query for where 
		String hqlQuery1 ="FROM Student01 where name = 'Mister Bean'";
		List resultList4 = session.createQuery(hqlQuery1).getResultList();
		
		for(Object obj: resultList4) {
			System.out.println(obj.toString());
		}
		//sql query for unique result method
		String sqlQuery5 = "SELECT * FROM t_student where id='1001'";
		Object[] resultList6 = (Object[])session.createSQLQuery(sqlQuery5).uniqueResult();
		
		System.out.println(Arrays.toString(resultList6));
		
		String hqlQuery8 = "From Student01 s Where s.name='John Coffee'";
		Object result1 = session.createQuery(hqlQuery8).uniqueResult();
		System.out.println(result1);
		
		String hqlQuery9 = "SELECT s.name FROM Student01 s where s.grade=11";
		List<Object> resultList = session.createQuery(hqlQuery9).getResultList();
		for(Object obj : resultList) {
			System.out.println(obj);
		}
		tx.commit();
		//we have to call session close
		session.close();
		sf.close();
	}

}
