package fetchTypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book08 {
    @Id
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn
    private Student08 student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public Student08 getStudent() {
        return student;
    }

    public void setStudent(Student08 student) {
        this.student = student;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", bookName='" + bookName +
                '}';
    }
}
