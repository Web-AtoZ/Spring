package com.webatoz.backend.database.webatoz.restaurant.menu;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    Integer menuId;
    String name;
    Integer price;
    Integer restaurantId;

    public Menu(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
