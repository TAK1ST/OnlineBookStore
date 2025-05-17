package OnlineBookStore.bookstore.controller;

import OnlineBookStore.bookstore.dto.request.ApiResponse;
import OnlineBookStore.bookstore.dto.request.UserCreationRequest;
import OnlineBookStore.bookstore.dto.request.UserUpdateRequest;
import OnlineBookStore.bookstore.dto.response.UserResponse;
import OnlineBookStore.bookstore.entity.User;
import OnlineBookStore.bookstore.service.UserService;
import jakarta.validation.Valid;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identity/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request)
    {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.createUser(request));
        return response;
    }

    @GetMapping
    List <User> getAllUser()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUserById(@PathVariable String userId)
    {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    UserResponse  updateUserById(@PathVariable String userId, @RequestBody UserUpdateRequest request)
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
