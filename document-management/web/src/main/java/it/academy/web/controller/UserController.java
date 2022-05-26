package it.academy.web.controller;

import it.academy.dto.UserDto;
import it.academy.service.MapUsersService;
import it.academy.web.SecurityDocumentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger log =
            LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private MapUsersService mapUsersService;

    @Autowired
    private SecurityDocumentConfiguration configuration;

    @GetMapping("/users")
    public String addUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "add-user";
    }

    @PostMapping("/users")
    public String saveUser(
            @Valid @ModelAttribute("userDto") UserDto userDto,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldErrors().size());
//            bindingResult.getFieldErrors().forEach(System.out::println);
//            System.out.println(userDto.getEnabled());
            model.addAttribute("fieldError", true);
            return "add-user";
        }

        model.addAttribute("fieldError", false);
        model.addAttribute("name", userDto.getUserName());
        userDto.setPassword(configuration.passwordEncoder().encode(userDto.getPassword()));

//        System.out.println(userDto.getAuthority());
//        System.out.println(userDto.getUserName());
//        System.out.println(userDto.getEnabled());

        mapUsersService.saveUser(userDto);
        return "saved-user";
    }

}
