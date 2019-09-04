package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.ObjectR;

public interface ObjectRepository extends JpaRepository<ObjectR, Integer> {
}
