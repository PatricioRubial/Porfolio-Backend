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
public class SkillProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int percentage;

    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String name;

    private String icon;

    private String color;

    protected SkillProfile() {

    }

    public SkillProfile(String name, int percentage, String icon, String color) {
        this.name = name;
        this.percentage = percentage;
        this.icon = icon;
        this.color = color;
    }
}
