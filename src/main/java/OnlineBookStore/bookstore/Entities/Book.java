package OnlineBookStore.bookstore.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;

    @Column(nullable = false)
    String title;

    @Column
    String description;
    @Column
    String isbn;
    @Column
    String author;

    @Column(updatable = false)
    LocalDateTime createdAt = LocalDateTime.now();

    LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToMany(mappedBy = "books")
    List<Category> categories;
}
