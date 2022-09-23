
package com.bvs.portfolioap.Repository;

import com.bvs.portfolioap.Entity.RedSocial;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRedSocial extends JpaRepository<RedSocial, Integer> {
    
    public Optional<RedSocial> findByNombreR(String nombreR);
    
    public boolean existsByNombreR(String nombreR);
}
