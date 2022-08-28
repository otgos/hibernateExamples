package embeddable;

import oneToOne.Diary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave02 {

	public static void main(String[] args) {
		
		Student02 student1 = new Student02();
		student1.setId(1001);
		student1.setName("Marcus Aurelius");
		student1.setGrade(11);
		
		Address address = new Address();
		address.setStreet("Apple Street");
		address.setState("Banana State");
		address.setCountry("Orange country");
		address.setZipCode("Blackberry zipcode");
		
		student1.setAddress(address);
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student02.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(student1);
//		
		tx.commit();
		//we have to call session close
		session.close();
		sf.close();
		
	}

}
