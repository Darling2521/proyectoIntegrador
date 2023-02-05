package security.api_authz.conf;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JWTUtil {
    
     
    public static final String TOKEN_HEADER="Authorization";
    public static final String TOKEN_PREFIX="Bearer ";
    private static final String SECRET="$2a$12$r8pfiCwWEGH0lavcBqcmJOYqEm.VoaUqq6VtuzKFEgaVTRFNVo1ea";
    private static final long EXPIRATION=72000000;
    private static final String ROLE_CLAIMS="rol";


	public static String generateToken(String username, String role) {
		Map<String,Object> map=new HashMap<>();
        map.put(ROLE_CLAIMS,role);
		return Jwts.builder()
			.signWith(SignatureAlgorithm.HS512,SECRET)
			.setClaims(map)
			.setSubject(username)
			.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION*1000))
			.compact();
	}

	public static String getUsername(String token) throws SignatureException{
        return getTokenBody(token).getSubject();
    }
    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }

	private static Claims getTokenBody(String token) throws SignatureException{

        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
