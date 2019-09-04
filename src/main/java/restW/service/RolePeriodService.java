package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Employee;
import restW.model.RolePeriod;
import restW.repository.RolePeriodRepository;

import java.util.List;

@Slf4j
@Service
public class RolePeriodService {

    @Autowired
    private RolePeriodRepository rolePeriodRepository;

    public RolePeriod getById(Integer id) {
        //log.info("In RolePeriodService getById{}", id);
        return rolePeriodRepository.findOne(id);
    }

    public void save(RolePeriod rolePeriod) {
        //log.info("In RolePeriodService save {}", rolePeriod);
        rolePeriodRepository.save(rolePeriod);
    }

    public void delete(Integer id) {
        //log.info("In RolePeriodService delete {}", id);
        rolePeriodRepository.delete(id);
    }

    public List<RolePeriod> getAll() {
        //log.info("In RolePeriodService getAll");
        return rolePeriodRepository.findAll();
    }

}
