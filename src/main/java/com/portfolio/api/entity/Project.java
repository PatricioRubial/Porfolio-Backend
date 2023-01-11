package com.portfolio.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String name;

    @NotNull
    @NotBlank(message = "Description may not be blank")
    private String description;

    private String photo;

    protected Project() {

    }

    public Project(String name, String description, String photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }
}
