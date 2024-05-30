package ru.muctr;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "guitar_brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @OneToMany(mappedBy = "brand")
    private List<Guitar> guitars;

}
