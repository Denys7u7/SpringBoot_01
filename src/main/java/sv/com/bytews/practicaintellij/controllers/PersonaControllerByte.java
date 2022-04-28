package sv.com.bytews.practicaintellij.controllers;

import com.bytesw.boot.crud.controller.CRUDController;
import com.bytesw.boot.crud.controller.XDFListController;
import com.fasterxml.jackson.core.JsonProcessingException;
import jdk.jfr.ContentType;
import org.springframework.web.bind.annotation.*;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.service.PersonaServiceByte;

@RestController
@RequestMapping("/personaByte")
public class PersonaControllerByte implements CRUDController<Persona, Integer, PersonaServiceByte>,
        XDFListController<Persona, Integer, PersonaServiceByte> {

    private final PersonaServiceByte serviceByte;

    public PersonaControllerByte(PersonaServiceByte serviceByte) {
        this.serviceByte = serviceByte;
    }

    @Override
    public PersonaServiceByte getService() {
        return serviceByte;
    }

    @RequestMapping(
            value = "/find/{nombre}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String findInOtherController(@PathVariable("nombre") String nombre) throws JsonProcessingException {
        return serviceByte.pruebaRest(nombre);
    }

}
