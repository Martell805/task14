package pakeyg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pakeyg.entity.User;
import pakeyg.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UserController {
    private final UserService userService;

    @PostMapping("registration")
    public ResponseEntity<Void> registration(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.ok().build();
    }
}
