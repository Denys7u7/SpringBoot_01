package sv.com.bytews.practicaintellij.repository;

import com.bytesw.boot.rql.data.jpa.repository.RqlJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sv.com.bytews.practicaintellij.data.bo.Persona;

public interface PersonaRepositoryByte extends RqlJpaRepository<Persona, Integer>, JpaSpecificationExecutor<Persona>, JpaRepository<Persona, Integer> {

}
