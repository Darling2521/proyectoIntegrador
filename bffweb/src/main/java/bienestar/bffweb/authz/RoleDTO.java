package bienestar.bffweb.authz;

import java.util.List;
import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private boolean enabled;
    private List<AuthorityDTO> authorities;
}
