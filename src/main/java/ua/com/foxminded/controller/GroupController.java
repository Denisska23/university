package ua.com.foxminded.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Group;
import ua.com.foxminded.service.GroupService;

@Controller
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("groups", groupService.getAll());
        return "group/getAll";
    }

    @GetMapping("/new")
    public String newGroupForm(@ModelAttribute("group") Group group) {
        return "group/new";
    }

    @PostMapping
    public String addGroupToDb(@ModelAttribute("group") Group group) {
        groupService.add(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/edit")
    public String editGroupForm(@PathVariable int id, Model model) {
        model.addAttribute("group", groupService.getById(id));
        return "group/edit";
    }

    @PatchMapping("/{id}")
    public String updateGroupInDb(@ModelAttribute("group") Group group) {
        groupService.update(group);
        return "redirect:/groups";
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable int id) {
        groupService.remove(groupService.getById(id));
        return "redirect:/groups";
    }
}
