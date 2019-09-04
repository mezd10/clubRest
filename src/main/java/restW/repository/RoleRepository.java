package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
