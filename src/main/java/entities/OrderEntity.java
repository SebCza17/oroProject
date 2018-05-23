package entities;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "public", catalog = "postgres")
public class OrderEntity {
    private int id;
    private Integer status;
    private Integer kind;
    private Date startDatetime;
    private Date endDatetime;

    private DescriptionEntity descriptionEntity;
    private List<DishEntity> dishEntities;
    private List<DrinkEntity> drinkEntities;


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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "kind")
    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "start_datetime")
    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    @Basic
    @Column(name = "end_datetime")
    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    @OneToOne
    @JoinColumn(name = "id_description")
    public DescriptionEntity getDescriptionEntity() { return descriptionEntity; }

    public void setDescriptionEntity(DescriptionEntity descriptionEntity) { this.descriptionEntity = descriptionEntity; }

    @ManyToMany
    public List<DishEntity> getDishEntities() { return dishEntities; }

    public void setDishEntities(List<DishEntity> dishEntities) { this.dishEntities = dishEntities; }

    @ManyToMany
    public List<DrinkEntity> getDrinkEntities() { return drinkEntities; }

    public void setDrinkEntities(List<DrinkEntity> drinkEntities) { this.drinkEntities = drinkEntities; }

}
