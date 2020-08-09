package com.webatoz.backend.database.webatoz.restaurant.menu;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "menuId", callSuper = false)
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer menuId;
    String name;
    Integer price;
    Integer restaurantId;

    public Menu(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
