package OnlineBookStore.bookstore.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
String                  firstName;
String                  lastName;

    @Size(min = 8, message = "Password must be at least 8 characters long")
String                  password;

LocalDate               dob;
}
