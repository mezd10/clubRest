package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.EmployementPeople;
import restW.repository.EmployementPeopleRepository;

import java.util.List;

@Slf4j
@Service
public class EmployementPeopleService {

    @Autowired
    private EmployementPeopleRepository employementPeopleRepository;

    public EmployementPeople getById(Integer id) {
        //log.info("In EmployementPeopleService getById{}", id);
        return employementPeopleRepository.findOne(id);
    }

    public void save(EmployementPeople employementPeople) {
        //log.info("In EmployementPeopleService save {}", employementPeople);
        employementPeopleRepository.save(employementPeople);
    }

    public void delete(Integer id) {
        //log.info("In EmployementPeopleService delete {}", id);
        employementPeopleRepository.delete(id);
    }

    public List<EmployementPeople> getAll() {
        //log.info("In EmployementPeopleService getAll");
        return employementPeopleRepository.findAll();
    }

}
