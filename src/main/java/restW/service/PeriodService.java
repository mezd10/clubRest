package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Period;
import restW.repository.PeriodRepository;

import java.util.List;
@Slf4j
@Service
public class PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    public Period getById(Integer id) {
        //log.info("In PeriodService getById{}", id);
        return periodRepository.findOne(id);
    }

    public void save(Period period) {
        //log.info("In PeriodService save {}", period);
        periodRepository.save(period);
    }

    public void delete(Integer id) {
        //log.info("In PeriodService delete {}", id);
        periodRepository.delete(id);
    }

    public List<Period> getAll() {
        //log.info("In PeriodService getAll");
        return periodRepository.findAll();
    }
}
