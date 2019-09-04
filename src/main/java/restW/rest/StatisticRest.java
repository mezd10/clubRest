package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.Statistic;
import restW.service.StatisticService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/statistic/")

public class StatisticRest {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Statistic> getStatistic(@PathVariable("id") Integer statisticId) {
        if (statisticId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Statistic statistic = this.statisticService.getById(statisticId);

        if (statistic == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Statistic> saveStatistic(@RequestBody @Valid Statistic statistic) {
        HttpHeaders headers = new HttpHeaders();

        if (statistic == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.statisticService.save(statistic);
        return new ResponseEntity<>(statistic, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Statistic> updateStatistic(@RequestBody @Valid Statistic statistic, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (statistic == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.statisticService.save(statistic);

        return new ResponseEntity<>(statistic, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Statistic> deleteStatistic(@PathVariable("id") Integer id) {
        Statistic statistic = this.statisticService.getById(id);

        if (statistic == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.statisticService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Statistic>> getAllS() {
        List<Statistic> statistics = this.statisticService.getAll();

        if (statistics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}
