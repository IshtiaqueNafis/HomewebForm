package com.example.demo.controller;

import com.example.demo.model.HomeWebForm;
import com.example.demo.utils.SelectOptions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String Form(Model model) {
        model.addAttribute("homeForm", new HomeWebForm());
        model.addAttribute("CBValues", SelectOptions.CBValues);
        model.addAttribute("timeZones", SelectOptions.zoneIds());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("homeForm") HomeWebForm homeForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("homeForm", new HomeWebForm());
            model.addAttribute("CBValues", SelectOptions.CBValues);
            model.addAttribute("timeZones", SelectOptions.zoneIds());

            return "form";
        }

        return "redirect:/";
    }
}
