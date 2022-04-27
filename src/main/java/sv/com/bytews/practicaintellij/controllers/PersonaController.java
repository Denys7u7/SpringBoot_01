package sv.com.bytews.practicaintellij.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.repository.PersonaRepository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaRepository repository;

    @Autowired
    public PersonaController(PersonaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("")
    private Persona savePerson(@RequestBody Persona persona){
        return repository.save(persona);
    }

    @GetMapping("/{id}")
    private Optional<Persona> getById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @GetMapping("")
    private List<Persona> getAll(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @PutMapping("")
    private Persona updatePerson(@RequestBody Persona persona){
        return repository.save(persona);
    }
}
