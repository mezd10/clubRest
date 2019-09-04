package restW.rest;

import restW.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee/")

public class EmployeeRest {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer employeeId) {
        if (employeeId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Employee employee = this.employeeService.getById(employeeId);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> save(@RequestBody @Valid Employee employee) {
        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employeeService.save(employee);
        return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> update(@RequestBody @Valid Employee employee, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employeeService.save(employee);

        return new ResponseEntity<>(employee, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Employee> deleteE(@PathVariable("id") Integer id) {
        Employee employee = this.employeeService.getById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employeeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Employee>> getAllE() {
        List<Employee> employees = this.employeeService.getAll();

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
