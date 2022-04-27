package sv.com.bytews.practicaintellij.controllers;

import com.bytesw.boot.crud.controller.CRUDController;
import com.bytesw.boot.crud.controller.XDFListController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
