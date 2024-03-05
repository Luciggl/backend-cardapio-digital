package com.luciggl.Cardapio.controller;

import com.luciggl.Cardapio.DTO.FoodRequestDTO;
import com.luciggl.Cardapio.DTO.FoodResponseDTO;
import com.luciggl.Cardapio.entities.Food;
import com.luciggl.Cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "*")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @GetMapping("/{id}")
    public Optional<Food> getByID(@PathVariable Long id) {
    Optional<Food> foodResponseDTO = repository.findById(id);
    return foodResponseDTO;
    }
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food food = new Food(data);
        repository.save(food);
        return;
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id){
        repository.deleteById(id);
    }
}
