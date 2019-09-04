package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Player;
import restW.repository.PlayerRepository;

import java.util.List;
@Slf4j
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player getById(Integer id) {
        //log.info("In PlayerService getById{}", id);
        return playerRepository.findOne(id);
    }

    public void save(Player player) {
        //log.info("In PlayerService save {}", player);
        playerRepository.save(player);
    }

    public void delete(Integer id) {
        //log.info("In PlayerService delete {}", id);
        playerRepository.delete(id);
    }

    public List<Player> getAll() {
        //log.info("In EmployeeService getAll");
        return playerRepository.findAll();
    }

}
