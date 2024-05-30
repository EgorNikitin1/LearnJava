package ru.muctr.Task10.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Guitar {

    private int id;
    private String brand;
    private String name;
    private String model;
    private int n_frets;
    private double scale;
    private int price;

}
