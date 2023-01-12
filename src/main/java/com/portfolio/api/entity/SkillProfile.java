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

    @NotNull
    @NotBlank(message = "Name may not be blank")
    
    private String skill;

    private String percentage;
    
    private String profile;

       protected SkillProfile() {

    }

    public SkillProfile(String skill, String percentage,String profile) {
        this.skill = skill;
        this.percentage = percentage;
        this.profile = profile;
        
        
    }
}
