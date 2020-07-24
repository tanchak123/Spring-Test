package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.model.User;
import test.model.dto.request.UserRequestDto;
import test.model.dto.response.UserResponseDto;
import test.model.mapper.ModelMapper;
import test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper<User, UserRequestDto, UserResponseDto> modelMapper;

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String get(@PathVariable String name, @RequestParam("user_id") Long id) {
        return "user: " + id + " name " + name;
    }

    @GetMapping("/{userId}")
    UserResponseDto get(@PathVariable int userId) {
        User user = userService.listUsers().get(userId - 1);
        return modelMapper.toDto(user);
    }

    //    @GetMapping("/")
    //    List<UserResponseDto> getAll() {
    //        return userService.listUsers();
    //    }

    @GetMapping("/inject")
    public String injectUser() {
        userService.add(new User("Sanya", "Vasya"));
        userService.add(new User("SANEK", "Vasilliy"));
        userService.add(new User("KTO", "WTO"));
        return "Users was injecting";
    }

}
