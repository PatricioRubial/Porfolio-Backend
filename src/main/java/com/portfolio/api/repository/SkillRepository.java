
package com.portfolio.api.repository;

import com.portfolio.api.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository<Skill, Long> {
    
}
