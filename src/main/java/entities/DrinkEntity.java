package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "drink", schema = "public", catalog = "postgres")
public class DrinkEntity {
    private int id;
    private Boolean adults;
    private String name;
    private Integer kind;

    private DescriptionEntity descriptionEntity;
    private List<DrinkDetailsEntity> drinkDetailsEntity;
    private List<OrderEntity> orderEntities;

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
    @Column(name = "adults")
    public Boolean getAdults() {
        return adults;
    }

    public void setAdults(Boolean adults) {
        this.adults = adults;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "kind")
    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @OneToOne
    @JoinColumn(name = "id_description")
    public DescriptionEntity getDescriptionEntity() { return descriptionEntity; }

    public void setDescriptionEntity(DescriptionEntity descriptionEntity) { this.descriptionEntity = descriptionEntity; }

    @OneToMany(mappedBy = "drinkEntity")
    public List<DrinkDetailsEntity> getDrinkDetailsEntity() { return drinkDetailsEntity; }

    public void setDrinkDetailsEntity(List<DrinkDetailsEntity> drinkDetailsEntity) { this.drinkDetailsEntity = drinkDetailsEntity; }

    @ManyToMany(mappedBy = "drinkEntities")
    public List<OrderEntity> getOrderEntities() { return orderEntities; }

    public void setOrderEntities(List<OrderEntity> orderEntities) { this.orderEntities = orderEntities; }

}
