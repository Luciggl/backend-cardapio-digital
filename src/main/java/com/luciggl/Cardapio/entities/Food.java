package com.luciggl.Cardapio.entities;

import com.luciggl.Cardapio.DTO.FoodRequestDTO;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "foods")
@Entity
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Integer price;
    private String image;

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.price = data.price();
        this.image = data.image();
    }

    public Food(){}

    public Food(String title, String image, Integer price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food food)) return false;
        return getId() == food.getId() && Objects.equals(getTitle(), food.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
}
