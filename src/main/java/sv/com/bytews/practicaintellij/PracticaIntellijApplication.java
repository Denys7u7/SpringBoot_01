package sv.com.bytews.practicaintellij;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sv.com.bytews.practicaintellij.repository.PersonaRepository;

@SpringBootApplication
public class PracticaIntellijApplication {

    public static void main(String[] args) {

        SpringApplication.run(PracticaIntellijApplication.class, args);

    }

}
