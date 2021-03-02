package ua.com.foxminded.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.IdCard;
import ua.com.foxminded.service.IdCardService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/id_cards")
@RequiredArgsConstructor
public class IdCardRestController {

    private final IdCardService idCardService;

    @PostMapping
    public ResponseEntity<IdCard> saveIdCard(@RequestBody @Valid @NotNull IdCard idCard) {
        IdCard savedIdCard = idCardService.add(idCard);
        return new ResponseEntity<>(savedIdCard, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<IdCard>> getAllIdCards() {
        List<IdCard> idCards = idCardService.getAll();
        return new ResponseEntity<>(idCards, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<IdCard> getIdCard(@PathVariable @NotNull Integer id) {
        IdCard idCard = idCardService.getById(id);
        return new ResponseEntity<>(idCard, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<IdCard> updateIdCard(@RequestBody @Valid @NotNull IdCard idCard) {
        IdCard updatedIdCard = idCardService.update(idCard);
        return new ResponseEntity<>(updatedIdCard, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<IdCard> deleteIdCard(@RequestBody @NotNull IdCard idCard) {
        idCardService.remove(idCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
