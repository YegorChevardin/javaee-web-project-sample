package ua.com.yehorchevardin.andersen.javaee.project.sample.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    @GetMapping
    public String showHomepage() {
        return "home";
    }
}
