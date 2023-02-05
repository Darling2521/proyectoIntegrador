package security.api_authz.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import security.api_authz.entity.Role;




public interface RoleRepository extends CrudRepository <Role, Long> {

    List<Role> findAll();
    
}
