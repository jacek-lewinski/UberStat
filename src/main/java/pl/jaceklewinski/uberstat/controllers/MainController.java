package pl.jaceklewinski.uberstat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jaceklewinski.uberstat.models.forms.TripForm;
import pl.jaceklewinski.uberstat.services.CalculateTrip;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tripForm", new TripForm());

        return "index";
    }

    @PostMapping("/")
    public String indexPost(@ModelAttribute("tripForm") TripForm tripForm) {

        CalculateTrip calculateTrip = new CalculateTrip(tripForm);




        System.out.println(tripForm.toString());
        System.out.println(calculateTrip.calculateBruttoPrice());
        System.out.println(calculateTrip.convertTimeToMinutes());
        return "index";
    }
}
