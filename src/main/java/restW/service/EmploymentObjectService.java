package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.EmployementPeople;
import restW.model.EmploymentObject;
import restW.repository.EmploymentObjectRepository;

import java.util.List;
@Slf4j
@Service
public class EmploymentObjectService {

    @Autowired
    private EmploymentObjectRepository employmentObjectRepository;

    public EmploymentObject getById(Integer id) {
        //log.info("In EmployementObjectService getById{}", id);
        return employmentObjectRepository.findOne(id);
    }

    public void save(EmploymentObject employmentObject) {
        //log.info("In EmployementObjectService save {}", employmentObject);
        employmentObjectRepository.save(employmentObject);
    }

    public void delete(Integer id) {
        //log.info("In EmployementObjectService delete {}", id);
        employmentObjectRepository.delete(id);
    }

    public List<EmploymentObject> getAll() {
        //log.info("In EmployementObjectService getAll");
        return employmentObjectRepository.findAll();
    }

}
