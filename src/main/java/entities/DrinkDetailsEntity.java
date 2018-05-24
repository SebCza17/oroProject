package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drink_details", schema = "public", catalog = "postgres")
public class DrinkDetailsEntity {
    private int id;
    private Double sizes;
    private Boolean availability;
    private Double price;
    private Double tax;

    private DrinkEntity drinkEntity;

    public DrinkDetailsEntity() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Basic
    @Column(name = "sizes")
    public Double getSizes() { return sizes; }

    public void setSizes(Double sizes) { this.sizes = sizes; }

    @Basic
    @Column(name = "availability")
    public Boolean getAvailability() { return availability; }

    public void setAvailability(Boolean availability) { this.availability = availability; }

    @Basic
    @Column(name = "price")
    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "tax")
    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @ManyToOne()
    @JoinColumn(name = "id_drink")
    public DrinkEntity getDrinkEntity() { return drinkEntity; }

    public void setDrinkEntity(DrinkEntity drinkEntity) { this.drinkEntity = drinkEntity; }

}
