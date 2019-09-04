package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.ObjectR;
import restW.repository.ObjectRepository;

import java.util.List;
@Slf4j
@Service
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    public ObjectR getById(Integer id) {
        //log.info("In ObjectService getById{}", id);
        return objectRepository.findOne(id);
    }

    public void save(ObjectR object) {
        //log.info("In ObjectService save {}", object);
        objectRepository.save(object);
    }

    public void delete(Integer id) {
        //log.info("In ObjectService delete {}", id);
        objectRepository.delete(id);
    }

    public List<ObjectR> getAll() {
        //log.info("In ObjectService getAll");
        return objectRepository.findAll();
    }

}
