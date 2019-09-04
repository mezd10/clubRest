package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.PositionOnClub;
import restW.service.PositionOnClubService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/positionOnClub/")
public class PositionOnClubRest {

    @Autowired
    private PositionOnClubService positionOnClubService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PositionOnClub> getPositionOnClub(@PathVariable("id") Integer Id) {
        if (Id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PositionOnClub positionOnClub = this.positionOnClubService.getById(Id);

        if (positionOnClub == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(positionOnClub, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PositionOnClub> savePositionOnClub(@RequestBody @Valid PositionOnClub positionOnClub) {
        HttpHeaders headers = new HttpHeaders();

        if (positionOnClub == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.positionOnClubService.save(positionOnClub);
        return new ResponseEntity<>(positionOnClub, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PositionOnClub> updatePositionOnClub(@RequestBody @Valid PositionOnClub positionOnClub,
                                                               UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (positionOnClub == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.positionOnClubService.save(positionOnClub);

        return new ResponseEntity<>(positionOnClub, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PositionOnClub> deletePositionOnClub(@PathVariable("id") Integer id) {
        PositionOnClub positionOnClub = this.positionOnClubService.getById(id);

        if (positionOnClub == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.positionOnClubService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<PositionOnClub>> getAllPositionOnClub() {
        List<PositionOnClub> positionOnClubs = this.positionOnClubService.getAll();

        if (positionOnClubs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(positionOnClubs, HttpStatus.OK);
    }

}
