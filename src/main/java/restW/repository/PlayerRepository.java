package restW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restW.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
