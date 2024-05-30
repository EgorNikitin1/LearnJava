package ru.muctr;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "guitar_info")
public class GuitarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "n_frets")
    private Integer n_frets;

    @Column(name = "scale")
    private Double scale;

    @OneToOne(mappedBy = "guitarInfo")
    private Guitar guitar;

}
