package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "description", schema = "public", catalog = "postgres")
public class DescriptionEntity {
    private int id;
    private String description;

    public DescriptionEntity() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DescriptionEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
