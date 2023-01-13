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
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String password;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String email;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String name;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String tittle;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String photo;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String description;
    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String gitHub;

    private String linkedIn;

    protected Profile() {
    }

    public Profile( String password, String email, String name,
            String tittle, String photo, String description, String gitHub, String linkedIn) {
        
        this.email=email;
        this.password=password;
        this.name=name;
        this.tittle=tittle;
        this.description=description;
        this.photo=photo;
        this.gitHub=gitHub;
        this.linkedIn=linkedIn;
 
    }
}
