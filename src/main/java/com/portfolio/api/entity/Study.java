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
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @NotBlank(message = "institution may not be blank")
    private String institution;
    
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String name;
    
    @NotNull
    @NotBlank(message = "description may not be blank")
    private String description;

    private String photo;

    private String link;
}
