package ua.com.yehorchevardin.andersen.javaee.project.sample.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.services.CreateReadUpdateDeleteService;
import ua.com.yehorchevardin.andersen.javaee.project.sample.web.dto.User;

import java.util.List;

/**
 * Controller for performing action with users
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@Controller
@RequestMapping({"/users", "/users/"})
@RequiredArgsConstructor
public class UserController {
  private final CreateReadUpdateDeleteService<User> createReadUpdateDeleteService;

  @GetMapping
  public String showAllUsers(Model model) {
    List<User> users = createReadUpdateDeleteService.readAll();
    model.addAttribute("users", users);
    return "users";
  }
}
