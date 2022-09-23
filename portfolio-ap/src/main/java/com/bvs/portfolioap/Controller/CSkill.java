
package com.bvs.portfolioap.Controller;

import com.bvs.portfolioap.Dto.dtoSkill;
import com.bvs.portfolioap.Entity.Skill;
import com.bvs.portfolioap.Security.Controller.Mensaje;
import com.bvs.portfolioap.Service.SSkill;
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
@RequestMapping("/skill")
@CrossOrigin(origins ="http://localhost:4200")
public class CSkill {
    
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtosk) {
        if (StringUtils.isBlank(dtosk.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio!"), HttpStatus.BAD_REQUEST);
        }
        if (sSkill.existsByNombreS(dtosk.getNombreS())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe!"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(dtosk.getNombreS(), dtosk.getImgS(), dtosk.getPorcentajeS(), dtosk.getSoftS());
        sSkill.save(skill);

        return new ResponseEntity(new Mensaje("Skill nueva creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtosk) {
        //Validar si exitse el id
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sSkill.existsByNombreS(dtosk.getNombreS()) && sSkill.getByNombreS(dtosk.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe!"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtosk.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = sSkill.getOne(id).get();
        skill.setNombreS(dtosk.getNombreS());
        skill.setImgS(dtosk.getImgS());
        skill.setPorcentajeS(dtosk.getPorcentajeS());
        skill.setSoftS(dtosk.getSoftS());

        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar si exitse el id
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sSkill.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
}
