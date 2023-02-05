package security.api_authz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import security.api_authz.entity.Authority;
import security.api_authz.entity.Role;
import security.api_authz.repository.RoleRepository;


@Service
public class RoleService {
    
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AuthorityService authorityService;

    //Create and Update
    public Role save(Role role){
        return roleRepository.save(role);
    }
    //Read
    public Role findById(long id){
        return roleRepository.findById(id).orElseThrow();
    }
    //Delete
    public void deleteById(long id){
        roleRepository.deleteById(id);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public List<String> getAuthoritiesByRolid(long rolId)
    {
        List<String> authorityNames = new ArrayList<>();
        Role role = roleRepository.findById(rolId).orElse(new Role());
        List<Authority> autorities = role.getAuthorities();
        for (Authority authority : autorities)
        {
            authorityNames.add(authority.getName());
        }
        return authorityNames;
    }

}
