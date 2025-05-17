package OnlineBookStore.bookstore.dto.response;

import OnlineBookStore.bookstore.constant.UserRoleEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String userId;
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    UserRoleEnum role = UserRoleEnum.USER;
    LocalDate createdAt;
    LocalDate updatedAt;
}
