package ce.component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order()
@Log
public class ResponseFilter implements Filter {

    @Value("${ce.security.cors}")
    private String cors;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            log.info("HttpServletResponse.");
            var httpResponse = (HttpServletResponse) response;

            var cspKey = "Content-Security-Policy";
            var domains = cors + " https://cdn.auth0.com https://aimmoth.eu.auth0.com";
            var scriptCsp = domains + " 'unsafe-inline' 'unsafe-eval'";
            var styleCsp = "'unsafe-inline';";

            var cspValue = String.format("default-src 'self' %s; script-src %s; style-src %s;", domains, scriptCsp, styleCsp);

            log.info("Setting " + cspKey + " to " + cspValue);
            httpResponse.addHeader(cspKey, cspValue);
        } else {
            log.info("Other type:" + response.getClass());
        }
        chain.doFilter(request, response);
    }
}
