package sv.com.bytews.practicaintellij.service.impl;

import com.bytesw.boot.crud.service.AbstractService;
import org.springframework.stereotype.Service;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.repository.PersonaRepositoryByte;
import sv.com.bytews.practicaintellij.service.PersonaServiceByte;

@Service
public class PersonaServiceByteImpl extends AbstractService implements PersonaServiceByte {

    private final PersonaRepositoryByte repositoryByte;

    public PersonaServiceByteImpl(PersonaRepositoryByte repositoryByte) {
        this.repositoryByte = repositoryByte;
    }

    @Override
    public PersonaRepositoryByte getRepository() {
        return repositoryByte;
    }

    @Override
    public void preCreate(Persona entity) {
        entity.setEdad(99);
        PersonaServiceByte.super.preCreate(entity);
    }

    @Override
    public void postCreate(Persona entity) {
        System.err.println(entity.getId());
        PersonaServiceByte.super.postCreate(entity);
    }
}
