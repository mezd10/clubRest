package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.Period;
import restW.service.PeriodService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/period/")
public class PeriodRest {

    @Autowired
    private PeriodService periodService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Period> getPeriod(@PathVariable("id") Integer periodId) {
        if (periodId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Period period = this.periodService.getById(periodId);

        if (period == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(period, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Period> savePeriod(@RequestBody @Valid Period period) {
        HttpHeaders headers = new HttpHeaders();

        if (period == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.periodService.save(period);
        return new ResponseEntity<>(period, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Period> updatePeriod(@RequestBody @Valid Period period, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (period == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.periodService.save(period);

        return new ResponseEntity<>(period, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Period> deletePeriod(@PathVariable("id") Integer id) {
        Period period = this.periodService.getById(id);

        if (period == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.periodService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Period>> getAllPeriod() {
        List<Period> periods = this.periodService.getAll();

        if (periods.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(periods, HttpStatus.OK);
    }

}
