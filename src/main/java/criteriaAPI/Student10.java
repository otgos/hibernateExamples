package criteriaAPI;

import idGenerationStrategy.BaseEntity;

import javax.persistence.*;

@Entity
public class Student10 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//by default length is 255
	@Column(name= "student_name", length =100,nullable = false, unique = false)
	private String name;

	private int mathGrade;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMathGrade() {
		return mathGrade;
	}

	public void setMathGrade(int mathGrade) {
		this.mathGrade = mathGrade;
	}

	@Override
	public String toString() {
		return "Student10{" +
				"id=" + id +
				", name='" + name + '\'' +
				", mathGrade=" + mathGrade +
				'}';
	}
}
