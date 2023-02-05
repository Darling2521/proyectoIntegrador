package security.api_authz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import security.api_authz.entity.Authority;
import security.api_authz.entity.Role;
import security.api_authz.entity.User;
import security.api_authz.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //Create and update
    public User save(User entity){
        
        entity.setPassword(encoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }
    //Read
    public User findById(long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User findByUsernameAndPassword(String name, String password){
        return userRepository.findByUsernameAndPassword(name, password);
    }

    public User findByUsername(String name){
        return userRepository.findByUsername(name);
    }

    //Delete 
    public void deleteById(long id){
        userRepository.deleteById(id);
    }
    
    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User getUserWithRolesByUsername(String username)
    {
        
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : user.getRoles())
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        user.setAuthorities(grantedAuthorities);
        return user;
    }

    @Transactional
    public User getUserWithAuthoritiesByUsername(String username)
    {
        
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : user.getRoles())
        {
            for (Authority auth : role.getAuthorities()){
                grantedAuthorities.add(new SimpleGrantedAuthority(auth.getName()));
            }
        }
        user.setAuthorities(grantedAuthorities);
        return user;
    }

    public boolean hasAuthority(String username, String authority){
        return userRepository.hasAuthority(username, authority);
    }
    
    public boolean matchPassword(String passwordIn, String userPassword){
        return encoder.matches(passwordIn, userPassword);
    }
}
