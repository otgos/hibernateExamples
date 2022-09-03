package idGenerationStrategy;

import javax.persistence.Entity;

@Entity
public class Book09 extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
