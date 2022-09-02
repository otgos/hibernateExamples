package manyToMany;

import biDirectionalOneToMany.Student06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book07 {
    @Id
    private int id;
    private String bookName;

    @Enumerated(EnumType.STRING)// you wiill get string version in database
    private BookType bookType;

    @ManyToMany(mappedBy = "books")
    private List<Student07> students = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }


    public BookType getBookType() {
        return bookType;
    }

    public List<Student07> getStudents() {
        return students;
    }

    public void setStudents(List<Student07> students) {
        this.students = students;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookType=" + bookType +
                '}';
    }
}
