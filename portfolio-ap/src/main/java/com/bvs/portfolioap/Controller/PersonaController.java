package com.bvs.portfolioap.Controller;

import com.bvs.portfolioap.Dto.dtoPersona;
import com.bvs.portfolioap.Entity.Persona;
import com.bvs.portfolioap.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://bvscheidt.dev")
/* @CrossOrigin(origins = "http://localhost:4200") */
public class PersonaController {
    
    @Autowired
    IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestBody dtoPersona dtoPer) {
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setImg(dtoPer.getImg());
        persona.setAcercaDe(dtoPer.getAcercaDe());
        persona.setEmail(dtoPer.getEmail());
        persona.setTitulo(dtoPer.getTitulo());
        
        ipersonaService.savePersona(persona);
        return persona;
        
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 1);
        
    }
}
