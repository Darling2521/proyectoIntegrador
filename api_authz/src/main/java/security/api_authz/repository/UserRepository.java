package security.api_authz.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import security.api_authz.entity.User;


public interface UserRepository extends CrudRepository <User, Long>{
    
    List<User> findAll();

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
    
    @Query(value =
        "select exists(select true as exists  "+
        "from users u "+
        "join users_roles ur on (u.id = ur.user_id) "+
        "join roles r on (ur.role_id = r.id) "+
        "join roles_authorities ra on (r.id = ra.role_id) "+
        "join authorities a on (ra.authority_id = a.id) "+
        "where u.username = ?1 and a.endpoint= ?2)",
         nativeQuery = true)
    boolean hasAuthority(String username, String authority);

}