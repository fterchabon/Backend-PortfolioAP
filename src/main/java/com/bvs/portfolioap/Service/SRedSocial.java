
package com.bvs.portfolioap.Service;

import com.bvs.portfolioap.Entity.RedSocial;
import com.bvs.portfolioap.Repository.RRedSocial;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRedSocial {
    
    @Autowired
    RRedSocial rRedSocial;
    
    public List<RedSocial> list() {
        return rRedSocial.findAll();
    }

    public Optional<RedSocial> getOne(int id) {
        return rRedSocial.findById(id);
    }

    public Optional<RedSocial> getByNombreR(String nombreR) {
        return rRedSocial.findByNombreR(nombreR);
    }

    public void save(RedSocial rs) {
        rRedSocial.save(rs);
    }

    public void delete(int id) {
        rRedSocial.deleteById(id);
    }

    public boolean existsById(int id) {
        return rRedSocial.existsById(id);
    }

    public boolean existsByNombreR(String nombreR) {
        return rRedSocial.existsByNombreR(nombreR);
    }
}
