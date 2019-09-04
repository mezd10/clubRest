package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.Role;
import restW.service.RoleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role/")
public class RoleRest {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") Integer Id) {
        if (Id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Role role = this.roleService.getById(Id);

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> saveRole(@RequestBody @Valid Role role) {
        HttpHeaders headers = new HttpHeaders();

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.roleService.save(role);
        return new ResponseEntity<>(role, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> updateRole(@RequestBody @Valid Role role, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.roleService.save(role);

        return new ResponseEntity<>(role, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Role> deleteRole(@PathVariable("id") Integer id) {
        Role role = this.roleService.getById(id);

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.roleService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Role>> getAllRole() {
        List<Role> roles = this.roleService.getAll();

        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
