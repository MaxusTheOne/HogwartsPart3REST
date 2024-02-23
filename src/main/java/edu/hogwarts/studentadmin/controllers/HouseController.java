package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/houses")
@RestController
public class HouseController {

    private final HouseRepository houseRepository;

    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @GetMapping("/{id}")
    public House getHouse(@PathVariable String id) {
        return houseRepository.findById(id).orElse(null);
    }

    @GetMapping("/{name}")
    public House getHouseByName(@PathVariable String name) {
        return houseRepository.findByName(name);
    }


}
