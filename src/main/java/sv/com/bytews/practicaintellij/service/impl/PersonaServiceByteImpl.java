package sv.com.bytews.practicaintellij.service.impl;

import com.bytesw.boot.crud.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sv.com.bytews.practicaintellij.data.bo.Persona;
import sv.com.bytews.practicaintellij.repository.PersonaRepositoryByte;
import sv.com.bytews.practicaintellij.service.PersonaServiceByte;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    @Override
    public String pruebaRest(String nombre) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/persona/find/" + nombre;
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        return root.toString();
    }
}
