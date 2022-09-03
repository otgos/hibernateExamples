package idGenerationStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence", sequenceName = "general_seq", initialValue = 1000, allocationSize = 5)
    private Long id;

    private LocalDateTime createddOn = LocalDateTime.now();

    public LocalDateTime getCreateddOn() {
        return createddOn;
    }

    public void setCreateddOn(LocalDateTime createddOn) {
        this.createddOn = createddOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
