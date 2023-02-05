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
import security.api_authz.entity.Role;
import security.api_authz.service.RoleService;

@Tag(name = "Controlador Role (Roles)", description = "Tabla roles")
@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Operation(summary = "Obtiene un rol por su id, Requiere Role_Read")
    @PreAuthorize("hasAuthority('Role_Read')")
    @GetMapping("/{id}/")
    public Role findById(@PathVariable long id){
        return roleService.findById(id);
    }

    @Operation(summary = "Obtiene un listado de todos los roles, Requiere Role_Read")
    @PreAuthorize("hasAuthority('Role_Read')")
    @GetMapping("/")
    public List<Role> findAll(){
        return roleService.findAll();
    }

    @Operation(summary = "Guarda un nuevo rol (enviado en el body), Requiere Role_Write")    
    @PreAuthorize("hasAuthority('Role_Write')")
    @PostMapping("/")
    public Role save(@RequestBody Role role){
        return roleService.save(role);
    }

    @Operation(summary = "Actualiza un rol por su id, Requiere Role_Write")
    @PreAuthorize("hasAuthority('Role_Write')")
    @PutMapping("/{id}/")
    public Role update(@RequestBody Role role){
        return roleService.save(role);
    }

    @Operation(summary = "Borra un rol por su id, Requiere Role_Delete")
    @PreAuthorize("hasAuthority('Role_Delete')")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        roleService.deleteById(id);
    }
}
