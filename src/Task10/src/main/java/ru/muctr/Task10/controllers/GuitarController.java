package ru.muctr.Task10.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.muctr.Task10.models.Guitar;
import ru.muctr.Task10.services.GuitarService;

@RestController
public class GuitarController {

    GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping("guitar/{id}")
    public Guitar findById(@PathVariable Integer id) {
        return guitarService.findGuitarById(id);
    }

    @PostMapping("/guitar") // localhost:8189/app/guitar?id=11&brand=Epiphone&name=Tribute&model=Les-Paul&n_frets=22&scale=24.75&price=1000
    public String createGuitar(
            @RequestParam Integer id,
            @RequestParam String brand,
            @RequestParam String name,
            @RequestParam String model,
            @RequestParam Integer n_frets,
            @RequestParam Double scale,
            @RequestParam Integer price
    ) {
        guitarService.createGuitar(new Guitar(id, brand, name, model, n_frets, scale, price));
        return "Гитара добавлена";
    }

    @DeleteMapping("guitar_delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        guitarService.deleteGuitarById(id);
        return "Гитара удалена";
    }

    @PutMapping("/guitar_update_price") // localhost:8189/app/guitar_update_price?id=1&price=10000
    public String updatePrice(
            @RequestParam Integer id,
            @RequestParam Integer price
    ) {
        guitarService.updatePriceById(id, price);
        return "Гитара обновлена";
    }

}
