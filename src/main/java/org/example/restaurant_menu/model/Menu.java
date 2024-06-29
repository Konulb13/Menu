package org.example.restaurant_menu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private Long weight;
    private boolean discount;

//    public Menu() {
//    }
//
//    public Menu(Long id, String name, int price, int weight, boolean discount) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.weight = weight;
//        this.discount = discount;
//    }

}
