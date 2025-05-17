package OnlineBookStore.bookstore.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String firstName;
    private String lastName;
    private String password;    
    private LocalDate dob;
}
