package bienestar.bffweb.authz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/login")
@CrossOrigin({ "*" })
public class LoginController {

    @Autowired
    LoginClient loginClient;

    @PostMapping("/")
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authorizationHeader) {
        return loginClient.login(authorizationHeader);
    }
}
