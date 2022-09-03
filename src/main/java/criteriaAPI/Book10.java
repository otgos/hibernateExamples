package criteriaAPI;

import idGenerationStrategy.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Book10 extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
