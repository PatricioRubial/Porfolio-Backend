/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.api.repository;

import com.portfolio.api.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author patri
 */
public interface ProjectRepository  extends JpaRepository<Project, Long> {
    
}