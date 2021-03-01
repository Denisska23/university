package ua.com.foxminded.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Lecture;
import ua.com.foxminded.service.LectureService;

import javax.validation.Valid;

@Controller
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping
    public String getAllLectures(Model model) {
        model.addAttribute("lectures", lectureService.getAll());
        return "lecture/getAll";
    }

    @GetMapping("/new")
    public String newLectureForm(@ModelAttribute("lecture") Lecture lecture) {
        return "lecture/new";
    }

    @PostMapping
    public String createLecture(@ModelAttribute("lecture") @Valid Lecture lecture, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lecture/new";
        }
        lectureService.add(lecture);
        return "redirect:/lectures";
    }

    @GetMapping("/{id}/edit")
    public String updateLectureForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("lecture", lectureService.getById(id));
        return "lecture/edit";
    }

    @PostMapping("/{id}")
    public String updateLecture(@ModelAttribute("lecture") @Valid Lecture lecture, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lecture/edit";
        }
        lectureService.update(lecture);
        return "redirect:/lectures";
    }

    @PostMapping("/{id}/delete")
    public String deleteLecture(@PathVariable("id") int id) {
        lectureService.remove(lectureService.getById(id));
        return "redirect:/lectures";
    }
}
