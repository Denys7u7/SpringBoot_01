package sv.com.bytews.practicaintellij.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.repository.PersonaRepository;
import sv.com.bytews.practicaintellij.service.PersonaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService service;
    private final PersonaRepository repository;

    @Autowired
    public PersonaController(PersonaService service, PersonaRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("")
    private ResponseEntity<Persona> savePerson(@RequestBody Persona persona){
        return service.savePerson(persona);
        //return repository.save(persona);
    }

    @GetMapping("/{id}")
    private Optional<Persona> getById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @PostMapping("/find")
    private ResponseEntity<List<Persona>> findByName(@RequestBody String field) throws Exception{
        return service.findByName(field);
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