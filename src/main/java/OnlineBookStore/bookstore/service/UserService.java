package OnlineBookStore.bookstore.service;

import OnlineBookStore.bookstore.dto.request.UserCreationRequest;
import OnlineBookStore.bookstore.dto.request.UserUpdateRequest;
import OnlineBookStore.bookstore.entity.User;
import OnlineBookStore.bookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        user.setRole(request.getRole());
        user.setCreatedAt(request.getCreatedAt());
        user.setUpdatedAt(request.getUpdatedAt());
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User updateUserById(String userId, UserUpdateRequest request) {
        User user = getUserById(userId);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public User getUserById(String userId) {
        return userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
}
