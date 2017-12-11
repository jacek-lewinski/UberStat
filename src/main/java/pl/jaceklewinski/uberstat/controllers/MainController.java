package pl.jaceklewinski.uberstat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jaceklewinski.uberstat.models.forms.TripForm;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tripForm", new TripForm());

        return "index";
    }

    @PostMapping("/")
    public String indexPost(@ModelAttribute("tripForm") TripForm tripForm) {
        System.out.println(tripForm.getPrice());

        return "index";
    }
}
