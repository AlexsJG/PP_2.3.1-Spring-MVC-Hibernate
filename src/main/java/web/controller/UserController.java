package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }


    @PatchMapping("/updateUser")
    public String userUpdate(@RequestParam(required = false) int id, Model model) {
        model.addAttribute("user", userService.updateUser(id));
        return "addAndUpdateUser";
    }


    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addAndUpdateUser";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addAndUpdateUser";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
    }

    @DeleteMapping("/deleteUser")
    public String userDelete(@RequestParam(required = false) int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}