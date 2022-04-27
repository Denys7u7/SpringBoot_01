package sv.com.bytews.practicaintellij.service;

import org.springframework.http.ResponseEntity;
import sv.com.bytews.practicaintellij.data.bo.Persona;

import java.util.List;

public interface PersonaService {

    ResponseEntity<Persona> savePerson(Persona persona);

    ResponseEntity<List<Persona>> findByName(String name) throws Exception;
}
