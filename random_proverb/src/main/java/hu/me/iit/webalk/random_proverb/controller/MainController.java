package hu.me.iit.webalk.random_proverb.controller;

import hu.me.iit.webalk.random_proverb.service.RandomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    private final RandomService randomService;

    public MainController(RandomService randomService) {
        this.randomService = randomService;
    }

    @GetMapping(path = "")
    public String showStudentWithProverb(Model model){
        model.addAttribute("student", randomService.getRandomStudent());
        model.addAttribute("proverb", randomService.getRandomProverb());

        return "proverbs";
    }



}
