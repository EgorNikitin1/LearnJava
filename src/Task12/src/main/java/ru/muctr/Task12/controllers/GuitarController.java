package ru.muctr.Task12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.muctr.Task12.errorHandling.InvalidDataException;
import ru.muctr.Task12.models.Guitar;
import ru.muctr.Task12.services.GuitarService;
import ru.muctr.Task12.errorHandling.ResourceNotFoundException;

import java.util.stream.Collectors;

@RestController
public class GuitarController {

    private final GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping("/guitar/{id}")
    public Guitar getGuitar(@PathVariable(name = "id") Integer id) {
        return guitarService.findGuitarById(id).orElseThrow(() -> new ResourceNotFoundException("Гитара с id " + id + "не существует"));
    }

    @PostMapping("/guitar")
    @ResponseStatus(HttpStatus.CREATED)
    public Guitar createNewGuitar(@RequestBody @Validated Guitar guitar, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        return guitarService.save(guitar);
    }

    @DeleteMapping("/guitar/{id}")
    public void deleteGuitar(@PathVariable Integer id) {
        guitarService.deleteGuitarById(id);
    }

    @PutMapping("/{id}") // localhost:8189/app/guitar_update_price?id=1&price=10000
    public String updateGuitar(@PathVariable Integer id, @RequestParam int price) {
        guitarService.updateGuitar(id, price);
        return "Обновлено успешно";
    }

    @PutMapping("/guitar")
    public Guitar updateGuitar2(@RequestBody Guitar guitar) {
        return guitarService.save(guitar);
    }
}
