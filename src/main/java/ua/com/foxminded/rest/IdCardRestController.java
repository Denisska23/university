package ua.com.foxminded.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.IdCard;
import ua.com.foxminded.service.IdCardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/id_cards")
@RequiredArgsConstructor
public class IdCardRestController {

    private final IdCardService idCardService;

    @PostMapping
    public ResponseEntity<IdCard> saveIdCard(@RequestBody @Valid IdCard idCard) {
        if (idCard == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        IdCard savedIdCard = idCardService.add(idCard);
        return new ResponseEntity<>(savedIdCard, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<IdCard>> getAllIdCards() {
        List<IdCard> idCards = idCardService.getAll();
        if (idCards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idCards, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<IdCard> getIdCard(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        IdCard idCard = idCardService.getById(id);

        if (idCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idCard, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<IdCard> updateIdCard(@RequestBody @Valid IdCard idCard) {
        IdCard updatedIdCard = idCardService.update(idCard);

        if (updatedIdCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(updatedIdCard, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<IdCard> deleteIdCard(@RequestBody IdCard idCard) {
        idCardService.remove(idCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
