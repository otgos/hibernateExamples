package idGenerationStrategy;

import fetchTypes.Book08;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student09 extends BaseEntity {

	//@Id
	//@GeneratedValue //AUTO
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //database is responsible to auto generate the primary key
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)//we first ask database for the next set of the sequence then we insert row with return sequence id
	//@GeneratedValue(strategy = GenerationType.TABLE) //creates table and saves the id last number
//	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "sequence", sequenceName = "student_seq", initialValue = 1000, allocationSize = 10)
//	private int id;

	//8-4-4-4-12 characters and 128 bits value for the data
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(name="UUID", strategy = "uuid2")
//	private String id;
	@Column(name= "student_name", nullable = false, unique = false)
	private String name;
	private int grade;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Student09{" +
				"id=" + getId() +
				", name='" + name + '\'' +
				", grade=" + grade +
				'}';
	}
}
