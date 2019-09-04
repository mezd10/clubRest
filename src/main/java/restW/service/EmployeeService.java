package restW.service;

import lombok.extern.slf4j.Slf4j;
import restW.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.repository.EmployeeRepository;

import java.util.List;


@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getById(Integer id) {

        //log.info("In EmployeeService getById{}", id);
        return employeeRepository.findOne(id);
    }

    public void save(Employee employee) {
        //log.info("In EmployeeService save {}", employee);
        employeeRepository.save(employee);
    }

    public void delete(Integer id) {
        //log.info("In EmployeeService delete {}", id);
        employeeRepository.delete(id);
    }

    public List<Employee> getAll() {
        //log.info("In EmployeeService getAll");
        return employeeRepository.findAll();
    }
}
