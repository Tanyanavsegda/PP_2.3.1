package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("user1", new User());
        System.out.println("get");
        return "users/index";
    }

    @GetMapping("/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersService.findOne(id));
        return "users/update";
    }

    @PostMapping()
    public String create(@ModelAttribute User user) {
        usersService.save(user);
        System.out.println("post");
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        usersService.delete(id);
        System.out.println("del");
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute User user) {
        usersService.update(id, user);
        return "redirect:/users";
    }
}
