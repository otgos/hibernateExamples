package embeddable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_student02")
public class Student02 {

	@Id
	private int id;
	@Column(name= "student_name", nullable = false, unique = false)
	private String name;
	private int grade;
	@Embedded
	private Address address;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student02 [id=" + id + ", name=" + name + ", grade=" + grade + ", address=" + address + "]";
	}
	
	
	
	
}
	

