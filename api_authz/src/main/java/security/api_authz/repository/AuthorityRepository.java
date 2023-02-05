package security.api_authz.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import security.api_authz.entity.Authority;



public interface AuthorityRepository extends CrudRepository<Authority, Long> {
 
    List<Authority> findAll();

    @Query(
    value = 
    "select a.* " +
    "from authorities a "+
    "join roles_authorities ra on (a.id = ra.authority_id) "+
    "join users_roles ur on (ra.role_id = ur.role_id) "+
    "join users u on (ur.user_id = u.id) "+
    "where u.username = ?1",
    nativeQuery = true
    )
    List<Authority> findByUsername(String username);

    List<Authority> findByNameIgnoreCaseLike(String term);

}

