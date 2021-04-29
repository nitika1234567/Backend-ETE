package controller;

import exception.BadRequestException;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/log")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final UserController usersControllerFunctions = new UserController();

    private List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping ("/logbase")
    public List<Users> userDatabase() {
        return getAllUsers();
    }

    @PostMapping("/logdata")
    public Users saveUserData(@RequestBody Users user) {
        return userRepository.save(user);
    }


}
