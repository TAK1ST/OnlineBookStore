package OnlineBookStore.bookstore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class SumDto {
    Integer numA;
    Integer numB;

}
