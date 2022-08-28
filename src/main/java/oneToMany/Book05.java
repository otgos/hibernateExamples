package oneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book05 {
    @Id
    private int id;
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book05{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
