package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
