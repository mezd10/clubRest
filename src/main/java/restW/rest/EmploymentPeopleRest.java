package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.EmployementPeople;
import restW.service.EmployementPeopleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employmentPeople/")
public class EmploymentPeopleRest {

    @Autowired
    private EmployementPeopleService employementPeopleService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmployementPeople> getEmploymentPeople(@PathVariable("id") Integer employeeId) {
        if (employeeId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmployementPeople employee = this.employementPeopleService.getById(employeeId);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmployementPeople> saveEmploymentPeople(@RequestBody @Valid EmployementPeople employee) {
        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employementPeopleService.save(employee);
        return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmployementPeople> updateEmployment(@RequestBody @Valid EmployementPeople employee, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employementPeopleService.save(employee);

        return new ResponseEntity<>(employee, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmployementPeople> deleteE(@PathVariable("id") Integer id) {
        EmployementPeople employee = this.employementPeopleService.getById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employementPeopleService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<EmployementPeople>> getAllE() {
        List<EmployementPeople> employees = this.employementPeopleService.getAll();

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
