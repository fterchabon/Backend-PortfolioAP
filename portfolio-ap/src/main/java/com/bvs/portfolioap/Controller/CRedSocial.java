
package com.bvs.portfolioap.Controller;

import com.bvs.portfolioap.Dto.dtoRedSocial;
import com.bvs.portfolioap.Entity.RedSocial;
import com.bvs.portfolioap.Security.Controller.Mensaje;
import com.bvs.portfolioap.Service.SRedSocial;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reds")
@CrossOrigin(origins = {"https://bvscheidt.dev", "http://localhost:4200"})
public class CRedSocial {
    
    @Autowired
    SRedSocial sRedSocial;
    
    @GetMapping("/lista")
    public ResponseEntity<List<RedSocial>> list() {
        List<RedSocial> list = sRedSocial.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<RedSocial> getById(@PathVariable("id") int id) {
        if (!sRedSocial.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        RedSocial redsocial = sRedSocial.getOne(id).get();
        return new ResponseEntity(redsocial, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRedSocial dtord) {
        if (StringUtils.isBlank(dtord.getNombreR())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio!"), HttpStatus.BAD_REQUEST);
        }
        if (sRedSocial.existsByNombreR(dtord.getNombreR())) {
            return new ResponseEntity(new Mensaje("Esa red social ya existe!"), HttpStatus.BAD_REQUEST);
        }

        RedSocial redsocial = new RedSocial(dtord.getNombreR(), dtord.getLinkR());
        sRedSocial.save(redsocial);

        return new ResponseEntity(new Mensaje("Red social nueva creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoRedSocial dtord) {
        //Validar si exitse el id
        if (!sRedSocial.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de red social
        if (sRedSocial.existsByNombreR(dtord.getNombreR()) && sRedSocial.getByNombreR(dtord.getNombreR()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa red social ya existe!"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtord.getNombreR())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        RedSocial redsocial = sRedSocial.getOne(id).get();
        redsocial.setNombreR(dtord.getNombreR());
        redsocial.setLinkR(dtord.getLinkR());

        sRedSocial.save(redsocial);
        return new ResponseEntity(new Mensaje("Red social actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar si exitse el id
        if (!sRedSocial.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sRedSocial.delete(id);

        return new ResponseEntity(new Mensaje("Red social eliminada"), HttpStatus.OK);
    }
    
}
