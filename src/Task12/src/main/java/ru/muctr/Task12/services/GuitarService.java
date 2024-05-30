package ru.muctr.Task12.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.muctr.Task12.models.Guitar;
import ru.muctr.Task12.repositories.GuitarsRepository;

import java.util.Optional;

@Service
public class GuitarService {

    GuitarsRepository guitarRepository;

    @Autowired
    public GuitarService(GuitarsRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    public Optional<Guitar> findGuitarById(int id) {
        return guitarRepository.findById(id);
    }

    public Guitar save(Guitar guitar) {
        return guitarRepository.save(guitar);
    }

    public void deleteGuitarById(int id) {
        guitarRepository.deleteById(id);
    }

    @Transactional
    public void updateGuitar(int id, int newPrice) {
        Guitar guitar = guitarRepository.findById(id).get();
        guitar.setPrice(newPrice);
    }

}
