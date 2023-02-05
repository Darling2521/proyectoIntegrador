package bienestar.bffweb.authz;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "login", url = "http://localhost:8081/login")
public interface LoginClient {

    @PostMapping()
    public ResponseEntity<String> login(@RequestHeader("Authorization") String authorizationHeader);

}
