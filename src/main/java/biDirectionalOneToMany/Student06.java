package biDirectionalOneToMany;

import oneToMany.Book05;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

	@Id
	private int id;
	@Column(name= "student_name", nullable = false, unique = false)
	private String name;
	private int grade;
	@OneToMany(mappedBy = "student", orphanRemoval = true)//we added orphanRemoval attribute to test deletion
	private List<Book06> book = new ArrayList<>();

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

	public List<Book06> getBook() {
		return book;
	}

	public void setBook(List<Book06> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Student06{" +
				"id=" + id +
				", name='" + name + '\'' +
				", grade=" + grade +
				", book=" + book +
				'}';
	}
}
