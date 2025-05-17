package OnlineBookStore.bookstore.controller;

import OnlineBookStore.bookstore.dto.request.UserCreationRequest;
import OnlineBookStore.bookstore.dto.request.UserUpdateRequest;
import OnlineBookStore.bookstore.entity.User;
import OnlineBookStore.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identity/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request)
    {
        return userService.createUser(request);
    }

    @GetMapping
    List <User> getAllUser()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable String userId)
    {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUserById(@PathVariable String userId, @RequestBody UserUpdateRequest request)
    {
        return userService.updateUserById(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUserById(@PathVariable String userId)
    {
        userService.deleteUserById(userId);
        return "User deleted successfully";
    }
}
