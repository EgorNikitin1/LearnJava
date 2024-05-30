package ru.muctr.Task12.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guitars")
public class Guitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 2, message = "Min length of brand = 2")
    @Column(name = "brand")
    private String brand;

    @Size(min = 2, message = "Min length of name = 2")
    @Column(name = "name")
    private String name;

    @Size(min = 2, message = "Min length of model = 2")
    @Column(name = "model")
    private String model;

    @Min(value = 18, message = "Min number of frets = 18")
    @Max(value = 30, message = "Max number of frets = 30")
    @Column(name = "n_frets")
    private int n_frets;

    @Min(value = 22, message = "Min scale = 22")
    @Max(value = 30, message = "Max scale = 30")
    @Column(name = "scale")
    private double scale;

    @Min(value = 0, message = "Min price = 0")
    @Column(name = "price")
    private int price;

    @Override
    public String toString() {
        return "Guitar{" + "id=" + id + ", name=" + name + ", price=" + price + "}";
    }

}
