package security.api_authz.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import security.api_authz.entity.Authority;
import security.api_authz.service.AuthorityService;


@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/authority")
@Tag(name = "Controlador Authority (Permisos)", description = "Tabla authorities")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @Operation(summary = "Obtiene un permiso por su id, Requiere Authority_Read")
    @PreAuthorize("hasAuthority('Authority_Read')")
    @GetMapping("/{id}/")
    public Authority findById(@PathVariable long id){
        return authorityService.findById(id);
    }

    @Operation(summary = "Obtiene un listado de todos los permisos, Requiere Authority_Read")
    @PreAuthorize("hasAuthority('Authority_Read')")
    @GetMapping("/")
    public List<Authority> findAll(){
        return authorityService.findAll();
    }

    @Operation(summary = "Guarda un permiso (enviado por el body), Requiere Authority_Write")
    @PreAuthorize("hasAuthority('Authority_Write')")
    @PostMapping("/")
    public Authority save(@RequestBody Authority authority){
        return authorityService.save(authority);
    }

    @Operation(summary = "Actualiza un permiso (enviado por el body), Requiere Authority_Write")
    @PreAuthorize("hasAuthority('Authority_Write')")
    @PutMapping("/{id}/")
    public Authority update(@RequestBody Authority authority){
        return authorityService.save(authority);
    }

    @Operation(summary = "Borra un permiso (enviado por el body), Requiere Authority_Delete")
    @PreAuthorize("hasAuthority('Authority_Delete')")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        authorityService.deleteById(id);
    }

    @Operation(summary = "Obtiene una lista de permisos de un usuario, Requiere AuthorityByUser_Read")
    @PreAuthorize("hasAuthority('AuthorityByUser_Read')")
    @GetMapping("/byuser/{username}/")
    public List<Authority> findByUsename(@PathVariable String username){
        return authorityService.findByUsername(username);
    }
}
