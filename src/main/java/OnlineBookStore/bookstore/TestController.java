package OnlineBookStore.bookstore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/hello")
public class TestController {
    @GetMapping("/")
    protected ResponseEntity getHello() throws Exception {
        return new ResponseEntity(new HashMap<String, Object>() {{
            put("message", "Hello World!");
        }}, HttpStatus.OK);
    }
}