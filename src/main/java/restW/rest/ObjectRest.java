package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.ObjectR;
import restW.service.ObjectService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/object/")
public class ObjectRest {

    @Autowired
    private ObjectService objectService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ObjectR> getObject(@PathVariable("id") Integer objectId) {
        if (objectId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ObjectR object = this.objectService.getById(objectId);

        if (object == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ObjectR> saveObject(@RequestBody @Valid ObjectR object) {
        HttpHeaders headers = new HttpHeaders();

        if (object == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.objectService.save(object);
        return new ResponseEntity<>(object, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ObjectR> updateObject(@RequestBody @Valid ObjectR object, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (object == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.objectService.save(object);

        return new ResponseEntity<>(object, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ObjectR> deleteObject(@PathVariable("id") Integer id) {
        ObjectR object = this.objectService.getById(id);

        if (object == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.objectService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ObjectR>> getAllObjects() {
        List<ObjectR> objects = this.objectService.getAll();

        if (objects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

}
