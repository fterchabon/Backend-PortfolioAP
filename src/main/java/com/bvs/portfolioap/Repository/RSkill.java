
package com.bvs.portfolioap.Repository;

import com.bvs.portfolioap.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkill extends JpaRepository<Skill, Integer>{
    
    public Optional<Skill> findByNombreS(String nombreS);
    
    public boolean existsByNombreS(String nombreS);
    
}
