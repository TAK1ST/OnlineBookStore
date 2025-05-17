package OnlineBookStore.bookstore.entity;

import OnlineBookStore.bookstore.constant.UserRoleEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     String userId;

    @Column(nullable = false, unique = true)
     String email;

    @Column(nullable = false, unique = true)
     String username;

    @Column(nullable = false)
     String password;

    @Column(nullable = false, length = 100)
     String firstName;

    @Column(nullable = false, length = 100)
     String lastName;

     LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,columnDefinition = "ENUM('GUEST', 'USER', 'ADMIN') DEFAULT 'USER'")
    UserRoleEnum role = UserRoleEnum.USER;

    @Column(updatable = false)                  //help createdAt cannot update
    LocalDate createdAt;

    LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = createdAt;
        if (role == null) {
            role = UserRoleEnum.USER;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }
}
