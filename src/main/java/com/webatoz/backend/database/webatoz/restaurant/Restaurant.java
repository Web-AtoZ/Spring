package com.webatoz.backend.database.webatoz.restaurant;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    private Integer restaurantId;
    private String name;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private LocalDate deletedDate;
    private String address;
    private Double lng;
    private Double lat;
    private Integer optionId;
    private String roadAddress;
    private String optionName;
    private String phone;
    private String placeId;

    public Restaurant(String name, String optionName) {
        this.name = name;
        this.optionName = optionName;
    }
}
