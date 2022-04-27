package sv.com.bytews.practicaintellij.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sv.com.bytews.practicaintellij.data.bo.Telefono;

public interface TelefonoRepository extends JpaRepository<Telefono, Integer>, JpaSpecificationExecutor<Telefono> {
}
