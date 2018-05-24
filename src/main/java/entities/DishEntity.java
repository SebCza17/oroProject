package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "dish", schema = "public", catalog = "postgres")
public class DishEntity {
    private int id;
    private String name;
    private Integer kind;

    private DescriptionEntity descriptionEntity;
    private List<DishDetailsEntity> dishDetailsEntities;
    private List<OrderEntity> orderEntities;

    public DishEntity() {
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

    @OneToMany(mappedBy = "dishEntity")
    public List<DishDetailsEntity> getDishDetailsEntities() { return dishDetailsEntities; }

    public void setDishDetailsEntities(List<DishDetailsEntity> dishDetailsEntities) { this.dishDetailsEntities = dishDetailsEntities; }

    @ManyToMany(mappedBy = "dishEntities")
    public List<OrderEntity> getOrderEntities() { return orderEntities; }

    public void setOrderEntities(List<OrderEntity> orderEntities) { this.orderEntities = orderEntities; }

}
