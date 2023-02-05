package security.api_authz.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import security.api_authz.entity.Authority;
import security.api_authz.repository.AuthorityRepository;


@Service
public class AuthorityService {
    
    @Autowired
    AuthorityRepository authorityRepository;
    //Create and Update
    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }
    //Read
    public Authority findById(long id){
        return authorityRepository.findById(id).orElseThrow();
    }
    //Delete
    public void deleteById(long id){
        authorityRepository.deleteById(id);
    }

    public List<Authority> findAll(){
        return authorityRepository.findAll();
    }

    public List<Authority> findByUsername(String username){
        return authorityRepository.findByUsername(username);
    }

    public List<Authority> findByName(String term){
        return authorityRepository.findByNameIgnoreCaseLike(term+"%");
    }
}
