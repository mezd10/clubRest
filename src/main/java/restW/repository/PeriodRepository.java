package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Period;

public interface PeriodRepository extends JpaRepository<Period, Integer> {
}
