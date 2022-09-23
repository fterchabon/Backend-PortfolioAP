package com.bvs.portfolioap.Interface;

import com.bvs.portfolioap.Entity.Persona;
import java.util.List;

public interface IPersonaService {

    //Traer una lista de persona
    public List<Persona> getPersona();

    //Guardar objeto de tipo persona
    public void savePersona(Persona persona);

    //Eliminar un objeto tipo persona por Id
    public void deletePersona(Long id);

    //Buscar un objeto tipo persona por Id
    public Persona findPersona(Long id);

}
