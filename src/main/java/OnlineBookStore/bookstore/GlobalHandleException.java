package OnlineBookStore.bookstore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

public class GlobalHandleException {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity(new HashMap<String, Object>() {{
            put("message", e.getMessage());
        }}, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
