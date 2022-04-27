package sv.com.bytews.practicaintellij.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sv.com.bytews.practicaintellij.data.bo.Persona;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>, JpaSpecificationExecutor<Persona> {

    @Query("from Persona p where p.nombre = :nombre")
    List<Persona> findPersonaByNombre(@Param("nombre") String nombre);

    List<Persona> findByNombreAndApellido(String nombre, String apellido);


}
