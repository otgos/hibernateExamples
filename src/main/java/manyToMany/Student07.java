package manyToMany;

import biDirectionalOneToMany.Book06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

	@Id
	private int id;
	@Column(name= "student_name", nullable = false, unique = false)
	private String name;
	private int grade;
	@ManyToMany
	@JoinTable(name = "student07_book07",
			joinColumns = {@JoinColumn(name="std_id")},
			inverseJoinColumns = {@JoinColumn(name="book_id")})
	private List<Book07> books= new ArrayList<>();

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

	public List<Book07> getBooks() {
		return books;
	}

	public void setBooks(List<Book07> books) {
		this.books = books;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Student07{" +
				"id=" + id +
				", name='" + name + '\'' +
				", grade=" + grade +
				", books=" + books +
				'}';
	}
}
