package sv.com.bytews.practicaintellij.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.com.bytews.practicaintellij.data.bo.Telefono;
import sv.com.bytews.practicaintellij.repository.TelefonoRepository;

@RestController
@RequestMapping("/telefono")
public class TelefonoController {

    private final TelefonoRepository repository;


    public TelefonoController(TelefonoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    private Telefono savePhone(@RequestBody Telefono telefono){
        return repository.save(telefono);
    }
}
