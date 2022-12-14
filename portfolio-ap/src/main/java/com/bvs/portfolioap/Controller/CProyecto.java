
package com.bvs.portfolioap.Controller;

import com.bvs.portfolioap.Dto.dtoProyecto;
import com.bvs.portfolioap.Entity.Proyecto;
import com.bvs.portfolioap.Security.Controller.Mensaje;
import com.bvs.portfolioap.Service.SProyecto;
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
@RequestMapping("/proto")
@CrossOrigin(origins = {"https://bvscheidt.dev", "http://localhost:4200"})
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro) {
        if (StringUtils.isBlank(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio!"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombreP(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe!"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtopro.getNombreP(), dtopro.getImgP(), dtopro.getDescripcionP());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto nuevo creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro) {
        //Validar si exitse el id
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de proyectos
        if (sProyecto.existsByNombreP(dtopro.getNombreP()) && sProyecto.getByNombreP(dtopro.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe!"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtopro.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtopro.getNombreP());
        proyecto.setImgP(dtopro.getImgP());
        proyecto.setDescripcionP(dtopro.getDescripcionP());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validar si exitse el id
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sProyecto.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
}
