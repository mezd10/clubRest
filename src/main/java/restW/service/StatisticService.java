package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Statistic;
import restW.repository.StatisticRepository;

import java.util.List;


@Slf4j
@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    public Statistic getById(Integer id) {
        //log.info("In StatisticService getById{}", id);
        return statisticRepository.findOne(id);
    }

    public void save(Statistic statistic) {
        //log.info("In StatisticService save {}", statistic);
        statisticRepository.save(statistic);
    }

    public void delete(Integer id) {
        //log.info("In StatisticService delete {}", id);
        statisticRepository.delete(id);
    }

    public List<Statistic> getAll() {
        //log.info("In ObjectService getAll");
        return statisticRepository.findAll();
    }

}
