package test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.model.dto.response.UserResponseDto;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @ResponseBody
    @GetMapping("/userDto")
    public UserResponseDto getUser() {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setLogin("ALICE");
        userResponseDto.setPassword("fasdfasf");
        return userResponseDto;
    }
}
