package bienestar.bffweb.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import bienestar.bffweb.authz.UserClient;
import feign.FeignException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AuthFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired UserClient userClient;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ResponseEntity<String> httpResponse;
        String authHeader = httpRequest.getHeader("Authorization");
        String endpoint = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        if (endpoint.contains("/swagger-ui")|| endpoint.contains("/v3/api-docs")) {
            chain.doFilter(request, response);
        }
        if (authHeader==null){
            ((HttpServletResponse) response).setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
        
        if (endpoint.equals("/login/")){
            try {
                chain.doFilter(request, response);
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage());
                ((HttpServletResponse) response).setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        } else {
            try {
                String[] parts = endpoint.split("/");
                if (esVariable(parts[parts.length - 1])) {
                    parts[parts.length - 1] = "{id}";
                }
                endpoint = String.join("/", parts) + "/";
                httpResponse = userClient.hasAuthority(authHeader, method + ":" + endpoint);
                if (httpResponse.getStatusCode() == HttpStatus.OK) {
                    chain.doFilter(request, response);
                }
            } catch (FeignException exception) {
                logger.error(exception.getLocalizedMessage());
                ((HttpServletResponse) response).setStatus(HttpStatus.FORBIDDEN.value());
            }
        }
    }

    private boolean esVariable(String term) {
        try {
            Integer.parseInt(term);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
