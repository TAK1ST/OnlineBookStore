package OnlineBookStore.bookstore.entity;

import OnlineBookStore.bookstore.constant.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    private LocalDate dob;

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
