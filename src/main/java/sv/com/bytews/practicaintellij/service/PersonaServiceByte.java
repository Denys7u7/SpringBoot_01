package sv.com.bytews.practicaintellij.service;

import com.bytesw.boot.crud.service.CRUDService;
import com.bytesw.boot.crud.service.XDFService;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.repository.PersonaRepositoryByte;

public interface PersonaServiceByte extends CRUDService<Persona, Integer, PersonaRepositoryByte>,
        XDFService<Persona, Integer, PersonaRepositoryByte> {
}