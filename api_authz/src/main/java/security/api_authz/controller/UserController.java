package security.api_authz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import security.api_authz.conf.JWTUtil;
import security.api_authz.entity.Authority;
import security.api_authz.entity.User;
import security.api_authz.service.AuthorityService;
import security.api_authz.service.UserService;

@Tag(name = "Controlador User (Usuarios)", description = "Tabla users")
@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;

    @Operation(summary = "Obtiene un usuario por su id, Requiere User_Read")    
    @PreAuthorize("hasAuthority('User_Read')")
    @GetMapping("/{id}/")
    public User findById(@PathVariable long id){
        return userService.findById(id);
    }

    @Operation(summary = "Obtiene un listado de usuario, Requiere User_Read")    
    @PreAuthorize("hasAuthority('User_Read')")
    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }

    @Operation(summary = "Guarda un usuario (body), Requiere User_Write")
    @PreAuthorize("hasAuthority('User_Write')")
    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @Operation(summary = "Actualización de todos los valores de un usuario (body) a través de su ID, Requiere User_Write")
    @PreAuthorize("hasAuthority('User_Write')")
    @PutMapping("/{id}/")
    public User update(@RequestBody User user){
        return userService.save(user);
    }

    @Operation(summary = "Borra un usuario a través de su ID, Requiere User_Delete")
    @PreAuthorize("hasAuthority('User_Delete')")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }


    @Operation(summary = "Entrega un Ok en caso de que el usuario extraido del token tiene acceso al Endpoint solicitado (Header), en caso contrario se entrega un 403")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
        description = "OK",
        content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "403",
        description = "FORBIDDEN",
        content = @Content)
    })    
    @GetMapping("/hasAuthority/")
    public ResponseEntity<String> hasAuthority(@RequestHeader("Authorization") String authHeader, @RequestHeader("Endpoint") String endpointHeader){

        if(authHeader==null||!authHeader.startsWith("Bearer")){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        String token = authHeader.replace("Bearer ", "");
        String username = JWTUtil.getUsername(token);

        if (username==null || endpointHeader == null )
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        List<Authority> authorities = authorityService.findByUsername(username);

        for (Authority auth: authorities){
            if (endpointHeader.equals(auth.getEndpoint())){
                return ResponseEntity.ok("ok");
            }
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No access");
    }
}

