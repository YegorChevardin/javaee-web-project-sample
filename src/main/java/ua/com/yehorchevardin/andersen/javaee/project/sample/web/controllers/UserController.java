package ua.com.yehorchevardin.andersen.javaee.project.sample.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final CreateReadUpdateDeleteService<User> createReadUpdateDeleteService;

  @GetMapping
  public String showAllUsers(Model model) {
    List<User> users = createReadUpdateDeleteService.readAll();
    model.addAttribute("users", users);
    return "users";
  }

  @GetMapping("/{id}")
  public String showUserById(@PathVariable(name = "id") Long id, Model model) {
    User user = createReadUpdateDeleteService.readById(id);
    model.addAttribute("user", user);
    return "user";
  }

  @PostMapping("/{id}/delete")
  public String deleteUserById(@PathVariable(name = "id") Long id) {
    createReadUpdateDeleteService.deleteById(id);
    return "redirect:/users";
  }

  @GetMapping("/{id}/update")
  public String showUpdatePage(@PathVariable(name = "id") Long id, Model model) {
    model.addAttribute("user", createReadUpdateDeleteService.readById(id));
    return "updateUser";
  }

  @PostMapping("/update")
  public String updateUserById(@ModelAttribute(name = "user") User user) {
    createReadUpdateDeleteService.update(user);
    return "redirect:/users/" + user.getId();
  }

  @GetMapping("/create")
  public String showCreatePage(Model model) {
    model.addAttribute("user", new User());
    return "createUser";
  }

  @PostMapping("/create")
  public String createUser(@ModelAttribute(name = "user") User user) {
    createReadUpdateDeleteService.create(user);
    return "redirect:/users";
  }
}
