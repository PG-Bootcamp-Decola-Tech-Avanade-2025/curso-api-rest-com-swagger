package pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.decola_tech_avanade_2025.cursos.api_rest_com_swagger.model.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
