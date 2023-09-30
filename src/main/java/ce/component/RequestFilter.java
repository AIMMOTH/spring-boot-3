package ce.component;

import ce.model.HttpRequestFields;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
@Log
public class RequestFilter implements Filter {

    @Value("${ce.security.cors}")
    private String cors;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            log.info("HttpServletResponse.");
            var httpResponse = (HttpServletResponse) response;
            httpResponse.addHeader("Access-Control-Allow-Origin", "*");
            httpResponse.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type, Origin, Authorization");
        }
        if (request instanceof HttpServletRequest) {
            var httpRequest = (HttpServletRequest) request;
            log.info("Fields:" + new HttpRequestFields(httpRequest));

            var referer = httpRequest.getHeader("referer");
            var origin = httpRequest.getHeader("origin");
            var host = httpRequest.getHeader("host");

            log.info("referer:" + referer + ", origin:" + origin + ", host:" + host);

            if (checkHeader(referer) || checkHeader(origin) || checkHeader(host)) {
                chain.doFilter(request, response);
            } else {
                log.info("No soup for YOU:" + referer);
            }
        } else {
            log.info("Other type:" + request.getClass());
        }
    }

    private boolean checkHeader(String value) {
        return value != null && cors.contains(value);
    }
}
