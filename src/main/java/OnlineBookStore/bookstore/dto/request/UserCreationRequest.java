package OnlineBookStore.bookstore.dto.request;

import OnlineBookStore.bookstore.constant.UserRoleEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreationRequest {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private UserRoleEnum role = UserRoleEnum.USER;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
