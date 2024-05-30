package ru.muctr.Task10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.muctr.Task10.models.Guitar;
import ru.muctr.Task10.repositories.InMemoryGuitarRepository;

@Service
public class GuitarService {

    InMemoryGuitarRepository guitarRepository;

    @Autowired
    public GuitarService(InMemoryGuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    public Guitar findGuitarById(int id) {
        return guitarRepository.getGuitarById(id).get();
    }

    public void createGuitar(Guitar guitar) {
        guitarRepository.addGuitar(guitar);
    }

    public void deleteGuitarById(int id) {
        guitarRepository.deleteGuitarById(id);
    }

    public void updatePriceById(int id, int price) {
        guitarRepository.updateGuitarPriceById(id, price);
    }

}
