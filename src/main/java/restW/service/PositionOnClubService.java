package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.PositionOnClub;
import restW.repository.PositionOnClubRepository;

import java.util.List;
@Slf4j
@Service
public class PositionOnClubService {

    @Autowired
    private PositionOnClubRepository positionOnClubRepository;

    public PositionOnClub getById(Integer id) {
        //log.info("In PositionOnClubService getById{}", id);
        return positionOnClubRepository.findOne(id);
    }

    public void save(PositionOnClub positionOnClub) {
        //log.info("In PositionOnClubService save {}", positionOnClub);
        positionOnClubRepository.save(positionOnClub);
    }

    public void delete(Integer id) {
        //log.info("In PositionOnClubService delete {}", id);
        positionOnClubRepository.delete(id);
    }

    public List<PositionOnClub> getAll() {
        //log.info("In PositionOnClubService getAll");
        return positionOnClubRepository.findAll();
    }

}
