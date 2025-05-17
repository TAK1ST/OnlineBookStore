package OnlineBookStore.bookstore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized error"),
    KEY_INVALID(1000, "Invalid message key"),
    USER_EXISTED(1001, "User already exists"),
    EMAIL_EXISTED(1002, "Email already exists"),
    USERNAME_INVALID(1003, "username must be at least 2 characters"),
    PASSWORD_INVALID(1004,"Password must be at least 8 characters long")
    ;

    private final int code;
    private final String message;
}
