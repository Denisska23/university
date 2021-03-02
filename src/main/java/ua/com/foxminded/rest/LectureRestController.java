package ua.com.foxminded.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Lecture;
import ua.com.foxminded.service.LectureService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureRestController {

    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<Lecture> saveLecture(@RequestBody @Valid @NotNull Lecture lecture) {
        Lecture savedLecture = lectureService.add(lecture);
        return new ResponseEntity<>(savedLecture, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Lecture>> getAllLectures() {
        List<Lecture> lectures = lectureService.getAll();
        if (lectures.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Lecture> getLecture(@PathVariable @NotNull Integer id) {
        Lecture lecture = lectureService.getById(id);
        if (lecture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Lecture> updateLecture(@RequestBody @Valid @NotNull Lecture lecture) {
        Lecture updatedLecture = lectureService.update(lecture);
        if (updatedLecture == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(updatedLecture, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Lecture> deleteLecture(@RequestBody @NotNull Lecture lecture) {
        lectureService.remove(lecture);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
