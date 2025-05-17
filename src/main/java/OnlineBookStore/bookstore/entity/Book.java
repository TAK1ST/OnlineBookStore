package OnlineBookStore.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "books")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer bookId;

    @Column(nullable = false)
     String title;

    @Column
     String description;
    @Column
     String isbn;
    @Column
     String author;

   @Column(updatable = false)                  //createdate cannot update
     LocalDate createdAt;

     LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }
    @ManyToMany(mappedBy = "books")
     List<Category> categories;
}
