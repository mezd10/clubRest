package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.EmploymentObject;

public interface EmploymentObjectRepository extends JpaRepository<EmploymentObject, Integer> {
}
