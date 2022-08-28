package biDirectionalOneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book06 {
    @Id
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn
    private Student06 student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public Student06 getStudent() {
        return student;
    }

    public void setStudent(Student06 student) {
        this.student = student;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", bookName='" + bookName +
                '}';
    }
}
