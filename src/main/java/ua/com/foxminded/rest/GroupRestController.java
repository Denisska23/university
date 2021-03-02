package ua.com.foxminded.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Group;
import ua.com.foxminded.service.GroupService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupRestController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> saveGroup(@RequestBody @Valid @NotNull Group group) {
        Group savedGroup = groupService.add(group);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Group> getGroup(@PathVariable @NotNull Integer id) {
        Group group = groupService.getById(id);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Group> updateGroup(@RequestBody @Valid @NotNull Group group) {
        Group updatedGroup = groupService.update(group);
        return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Group> deleteGroup(@RequestBody @NotNull Group group) {
        groupService.remove(group);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
