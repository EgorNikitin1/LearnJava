package ru.muctr.Task12.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.muctr.Task12.models.Guitar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryGuitarRepository {

//    List<Guitar> guitarList;
//
//    public Optional<Guitar> getGuitarById(int id) {
//        for (Guitar guitar:guitarList) {
//            if (guitar.getId() == id) {
//                return Optional.of(guitar);
//            }
//        }
//        return Optional.empty();
//    }
//
//    public void addGuitar(Guitar guitar) {
//        guitarList.add(guitar);
//    }
//
//    public void deleteGuitarById(int id) {
//        guitarList.removeIf(guitar -> guitar.getId() == id);
//    }
//
//    public void updateGuitarPriceById(int id, int price) {
//        for (Guitar guitar:guitarList) {
//            if (guitar.getId() == id) {
//                guitar.setPrice(price);
//            }
//        }
//    }

//    @PostConstruct
//    public void init() {
//        guitarList = new ArrayList<>(Arrays.asList(
//                new Guitar(1, "Gibson", "Standard ’60s", "Les Paul", 22, 24.75, 2800),
//                new Guitar(2, "Fender", "American Original ’50s", "Stratocaster", 21, 25.5, 2100),
//                new Guitar(3, "Fender", "American Original ’50s", "Telecaster", 22, 25.5, 1500),
//                new Guitar(4, "Gibson", "Standard Reissue", "SG", 24, 24.75, 1700),
//                new Guitar(5, "PRS", "Custom 24", "PRS Custom", 24, 25.0, 3000),
//                new Guitar(6, "Ibanez", "JEM7VP", "Signature", 24, 25.5, 2500),
//                new Guitar(7, "Gretsch", "G5422TDC Electromatic", "C-profile", 22, 24.6, 1000),
//                new Guitar(8, "ESP", "E-II NT", "SuperStratocaster", 24, 25.5, 2200),
//                new Guitar(9, "Jackson", "USA Soloist SL1", "SuperStratocaster", 24, 25.5, 3900),
//                new Guitar(10,"Gibson", "ES-335", "C-profile", 24, 24.75, 2900)
//        ));
//    }

}
