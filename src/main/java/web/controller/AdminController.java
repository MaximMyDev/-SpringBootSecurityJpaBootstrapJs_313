package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.UserService;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ModelAndView allUsers(@AuthenticationPrincipal UserDetails authUser) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPageRest");

        List<User> users = userService.allUsers();
        List<Role> roleList = userService.allRoles();
        modelAndView.addObject("userList", users);
        modelAndView.addObject("roleList", roleList);

        Optional<User> userCurrent = userService.getUserByName(authUser.getUsername());
        modelAndView.addObject("userCurrent", userCurrent.get());

        return modelAndView;
    }

}
