package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.RolePeriod;
import restW.service.RolePeriodService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/rolePeriod/")
public class RolePeriodRest {

    @Autowired
    private RolePeriodService rolePeriodService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RolePeriod> getRolePeriod(@PathVariable("id") Integer Id) {
        if (Id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        RolePeriod rolePeriod = this.rolePeriodService.getById(Id);

        if (rolePeriod == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rolePeriod, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RolePeriod> saveRolePeriod(@RequestBody @Valid RolePeriod rolePeriod) {
        HttpHeaders headers = new HttpHeaders();

        if (rolePeriod == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.rolePeriodService.save(rolePeriod);
        return new ResponseEntity<>(rolePeriod, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RolePeriod> updateRolePeriod(@RequestBody @Valid RolePeriod rolePeriod, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (rolePeriod == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.rolePeriodService.save(rolePeriod);

        return new ResponseEntity<>(rolePeriod, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RolePeriod> deleteRolePeriod(@PathVariable("id") Integer id) {
        RolePeriod rolePeriod = this.rolePeriodService.getById(id);

        if (rolePeriod == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.rolePeriodService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<RolePeriod>> getAllRolePeriod() {
        List<RolePeriod> rolePeriods = this.rolePeriodService.getAll();

        if (rolePeriods.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rolePeriods, HttpStatus.OK);
    }

}
