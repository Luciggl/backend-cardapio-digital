package com.luciggl.Cardapio.repositories;

import com.luciggl.Cardapio.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
