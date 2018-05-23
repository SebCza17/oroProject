package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dish_details", schema = "public", catalog = "postgres")
public class DishDetailsEntity {
    private int id;
    private Boolean availability;
    private Double price;
    private Double tax;
    private Double sizes;
    private DishEntity dishEntity;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "availability")
    public Boolean getAvailability() { return availability; }

    public void setAvailability(Boolean availability) { this.availability = availability; }

    @Column(name = "price")
    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    @Column(name = "tax")
    public Double getTax() { return tax; }

    public void setTax(Double tax) { this.tax = tax; }

    @Column(name = "sizes")
    public Double getSizes() { return sizes; }

    public void setSizes(Double sizes) { this.sizes = sizes; }

    @ManyToOne
    @JoinColumn(name = "id_dish")
    public DishEntity getDishEntity() { return dishEntity; }

    public void setDishEntity(DishEntity dishEntity) { this.dishEntity = dishEntity; }



}
