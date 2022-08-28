package manyToOne;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_student")
public class Student04 {

	@Id
	private int id;
	@Column(name= "student_name", nullable = false, unique = false)
	private String name;

	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;

	private int grade;
	@Column(name="created_on")
	private LocalDateTime createOn;
	private LocalDateTime updateOn;
	@PrePersist
	public void prePersist(){
		createOn=LocalDateTime.now();
	}
	@PreUpdate
	public void preUpdate(){
		updateOn=LocalDateTime.now();
	}

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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Student04{" +
				"id=" + id +
				", name='" + name + '\'' +
				", university=" + university +
				", grade=" + grade +
				", createOn=" + createOn +
				", updateOn=" + updateOn +
				'}';
	}
}
