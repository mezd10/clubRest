package restW.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import restW.model.Player;
import restW.service.PlayerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/player/")

public class PlayerRest {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") Integer playerId) {
        if (playerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Player player = this.playerService.getById(playerId);

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player) {
        HttpHeaders headers = new HttpHeaders();

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.playerService.save(player);
        return new ResponseEntity<>(player, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Player> updatePlayer(@RequestBody @Valid Player player, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.playerService.save(player);

        return new ResponseEntity<>(player, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Player> deletePlayer(@PathVariable("id") Integer id) {
        Player player = this.playerService.getById(id);

        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.playerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Player>> getAllCustomers() {
        List<Player> players = this.playerService.getAll();

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

}
