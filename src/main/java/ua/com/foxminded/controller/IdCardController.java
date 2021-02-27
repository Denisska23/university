package ua.com.foxminded.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.IdCard;
import ua.com.foxminded.service.IdCardService;

import javax.validation.Valid;

@Controller
@RequestMapping("/id_cards")
@RequiredArgsConstructor
public class IdCardController {

    private final IdCardService idCardService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("idCards", idCardService.getAll());
        return "idCard/getAll";
    }

    @GetMapping("/new")
    public String newIdCardForm(@ModelAttribute("idCard") IdCard idCard) {
        return "idCard/new";
    }

    @PostMapping
    public String createIdCard(@ModelAttribute("idCard") @Valid IdCard idCard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "idCard/new";
        }
        idCardService.add(idCard);
        return "redirect:/id_cards";
    }

    @GetMapping("/{id}/edit")
    public String editIdCardForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("idCard", idCardService.getById(id));
        return "idCard/edit";
    }

    @PostMapping("/{id}")
    public String updateIdCard(@ModelAttribute("idCard") @Valid IdCard idCard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "idCard/new";
        }
        idCardService.update(idCard);
        return "redirect:/id_cards";
    }

    @PostMapping("/{id}/delete")
    public String deleteIdCard(@ModelAttribute("idCard") IdCard idCard) {
        idCardService.remove(idCard);
        return "redirect:/id_cards";
    }
}
