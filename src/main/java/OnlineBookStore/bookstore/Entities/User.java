package OnlineBookStore.bookstore.Entities;

import OnlineBookStore.bookstore.Constant.UserRoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, length = 100)
    String fname;

    @Column(nullable = false, length = 100)
    String lname;

    LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('GUEST', 'USER', 'ADMIN') DEFAULT 'USER'")
    UserRoleEnum role = UserRoleEnum.USER;

    @Column(updatable = false)                  //help createdAt cannot update
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
