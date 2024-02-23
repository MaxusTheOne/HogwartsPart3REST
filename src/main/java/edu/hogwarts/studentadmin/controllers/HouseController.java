package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/houses")
@RestController
public class HouseController {

    private final HouseRepository houseRepository;

    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @GetMapping("")
    public List<House> getHouseByName(@RequestParam(required = false) String name) {

        if (name == null) {
            return houseRepository.findAll();
        }else {
            return houseRepository.findByName(name);
        }
    }

    @GetMapping("/{id}")
    public House getHouse(@PathVariable int id) {
        return houseRepository.findById(String.valueOf(id)).orElse(null);
    }



}
