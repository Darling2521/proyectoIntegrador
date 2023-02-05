package bienestar.bffweb.authz;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "bff.user", url = "http://localhost:8081/api/user")
public interface UserClient {

    @GetMapping("/{id}/")
    UserDTO findUserById(@RequestHeader("Authorization") String authHeader, @PathVariable("id") Long id);

    @GetMapping("/")
    List<UserDTO> findAll(@RequestHeader("Authorization") String authorizationHeader);

    @PostMapping("/") 
    UserDTO save(@RequestHeader("Authorization") String authorizationHeader, UserDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@RequestHeader("Authorization") String authorizationHeader,@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    UserDTO update(@RequestHeader("Authorization") String authorizationHeader, @PathVariable("id")  Long id, UserDTO entity);
    
    @GetMapping("/hasAuthority/")
    public ResponseEntity<String> hasAuthority(@RequestHeader("Authorization") String authorizationHeader,@RequestHeader("EndPoint") String endpoint);
    
}

