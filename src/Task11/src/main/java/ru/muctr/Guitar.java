package ru.muctr;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "guitars")
public class Guitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Transient
    private String rang;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "id_info")
    private GuitarInfo guitarInfo;

    @ManyToMany
    @JoinTable(
            name = "groups_guitars",
            joinColumns = @JoinColumn(name = "guitar_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;

    @Override
    public String toString() {
        return "Guitar{" + "id=" + id + ", name=" + name + ", price=" + price + "}";
    }

    public Guitar(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
