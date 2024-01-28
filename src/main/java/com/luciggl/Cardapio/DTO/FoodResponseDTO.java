package com.luciggl.Cardapio.DTO;

import com.luciggl.Cardapio.entities.Food;

public record FoodResponseDTO(Long id, String title, Integer price, String image) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getPrice(), food.getImage());
    }
}
