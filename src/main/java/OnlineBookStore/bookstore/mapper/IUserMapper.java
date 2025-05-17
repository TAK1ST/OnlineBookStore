package OnlineBookStore.bookstore.mapper;

import OnlineBookStore.bookstore.dto.request.UserCreationRequest;
import OnlineBookStore.bookstore.dto.request.UserUpdateRequest;
import OnlineBookStore.bookstore.dto.response.UserResponse;
import OnlineBookStore.bookstore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
