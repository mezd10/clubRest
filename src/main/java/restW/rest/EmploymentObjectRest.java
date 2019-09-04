package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.EmploymentObject;
import restW.service.EmploymentObjectService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/employmentObject/")
public class EmploymentObjectRest {
    @Autowired
    private EmploymentObjectService employmentObjectService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmploymentObject> getEmployeeObject(@PathVariable("id") Integer employeeId) {
        if (employeeId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EmploymentObject employee = this.employmentObjectService.getById(employeeId);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmploymentObject> saveEm(@RequestBody @Valid EmploymentObject employee) {
        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employmentObjectService.save(employee);
        return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmploymentObject> updateE(@RequestBody @Valid EmploymentObject employee, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.employmentObjectService.save(employee);

        return new ResponseEntity<>(employee, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EmploymentObject> deleteE(@PathVariable("id") Integer id) {
        EmploymentObject employee = this.employmentObjectService.getById(id);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.employmentObjectService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<EmploymentObject>> getAllE() {
        List<EmploymentObject> employees = this.employmentObjectService.getAll();

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
