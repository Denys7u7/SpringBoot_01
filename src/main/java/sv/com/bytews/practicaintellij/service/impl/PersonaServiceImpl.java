package sv.com.bytews.practicaintellij.service.impl;

import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.repository.PersonaRepository;
import sv.com.bytews.practicaintellij.service.PersonaService;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Persona> savePerson(Persona persona) {
        if (persona.getApellido().equals("Cruz")){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            try {
                Persona personaResponse = repository.save(persona);
                return new ResponseEntity<>(personaResponse, HttpStatus.CREATED);
            } catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @Override
    public ResponseEntity<List<Persona>> findByName(String fields) throws Exception {
        JSONObject request = new JSONObject(fields);

        if (request.isNull("apellido")){
            List<Persona> personaList = repository.findPersonaByNombre(request.getString("nombre"));
            if (personaList == null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(personaList, HttpStatus.OK);
        } else{
            List<Persona> personaList = repository.findByNombreAndApellido(request.getString("nombre"), request.getString("apellido"));
            if (personaList == null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(personaList, HttpStatus.OK);
        }
    }
}
