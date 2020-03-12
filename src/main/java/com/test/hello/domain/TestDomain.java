package com.test.hello.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDomain {

    @NotBlank(message = "name must not be blank.")
    private String name;

    private List<Integer> numList;

    public void setName(String name) {
        this.name = name.trim();
    }
}
