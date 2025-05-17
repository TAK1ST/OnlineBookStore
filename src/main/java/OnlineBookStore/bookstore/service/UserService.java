package OnlineBookStore.bookstore.service;

import OnlineBookStore.bookstore.dto.request.UserCreationRequest;
import OnlineBookStore.bookstore.dto.request.UserUpdateRequest;
import OnlineBookStore.bookstore.dto.response.UserResponse;
import OnlineBookStore.bookstore.entity.User;
import OnlineBookStore.bookstore.exception.CustomException;
import OnlineBookStore.bookstore.exception.ErrorCode;
import OnlineBookStore.bookstore.mapper.IUserMapper;
import OnlineBookStore.bookstore.repository.IUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor                                        //set constructor if declare var is final
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {
    IUserRepository userRepository;
    IUserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new CustomException(ErrorCode.USER_EXISTED);
        if (userRepository.existsByEmail(request.getEmail()))
            throw new CustomException(ErrorCode.EMAIL_EXISTED);

        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public UserResponse updateUserById(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepository.save(user));
    }
    public UserResponse getUserById(String userId) {
        return userMapper.toUserResponse(userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
}
