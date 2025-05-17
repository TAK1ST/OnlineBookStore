package OnlineBookStore.bookstore.dto.request;

import OnlineBookStore.bookstore.constant.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @NotBlank
    @NotEmpty
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email address")
    String                      email;

    @NotBlank
    @NotEmpty
    @Size(min = 2, message = "USERNAME_INVALID")
    String                      username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String                      password;

    String                      firstName;
    String                      lastName;
    LocalDate                   dob;
    UserRoleEnum                role = UserRoleEnum.USER;
    LocalDate                   createdAt;
    LocalDate                   updatedAt;
}
