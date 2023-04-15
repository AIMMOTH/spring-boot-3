package ce.model;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class HttpRequestFields {

    private final String method;
    private final String pathInfo;
    private final String requestUri;
    private final String authType;
    private final String contextPath;
    private final String pathTranslated;
    private final String queryString;
    private final String remoteUser;
    private final String requestedSessionId;
    private final String servletPath;
    private final String scheme;
    private final String characterEncoding;
    private final String contentType;
    private final String localAddr;
    private final String localName;
    private final String protocol;
    private final String remoteAddr;
    private final String requestId;
    private final String remoteHost;
    private final String serverName;
    private final Map<String, String> headers;
    private final Map<String, Object> attributes;
    private final int contentLength;
    private final boolean isSecure;
    private final Map<String, String[]> parameters;
    private final Locale locale;
    private final ArrayList<Locale> locales;
    private final int localPort;
    private final int remotePort;
    private final int serverPort;

    public HttpRequestFields(HttpServletRequest httpRequest) {
        this.method = httpRequest.getMethod();
        this.pathInfo = httpRequest.getPathInfo();
        this.requestUri = httpRequest.getRequestURI();
        this.authType = httpRequest.getAuthType();
        this.contextPath = httpRequest.getContextPath();
        this.pathTranslated = httpRequest.getPathTranslated();
        this.queryString = httpRequest.getQueryString();
        this.remoteUser = httpRequest.getRemoteUser();
        this.requestedSessionId= httpRequest.getRequestedSessionId();
        this.servletPath = httpRequest.getServletPath();
        this.scheme = httpRequest.getScheme();
        this.characterEncoding = httpRequest.getCharacterEncoding();
        this.contentType = httpRequest.getContentType();
        this.localAddr = httpRequest.getLocalAddr();
        this.localName = httpRequest.getLocalName();
        this.localPort = httpRequest.getLocalPort();
        this.protocol = httpRequest.getProtocol();
        this.remoteAddr = httpRequest.getRemoteAddr();
        this.requestId = httpRequest.getRequestId();
        this.remoteHost = httpRequest.getRemoteHost();
        this.serverName = httpRequest.getServerName();
        this.contentLength = httpRequest.getContentLength();
        this.isSecure = httpRequest.isSecure();
        this.headers = Collections.list(httpRequest.getHeaderNames()).stream()
                .collect(Collectors.toMap(headerName -> headerName, headerName -> httpRequest.getHeader(headerName)))
        ;
        this.parameters = httpRequest.getParameterMap();
        this.locale = httpRequest.getLocale();
        this.locales = Collections.list(httpRequest.getLocales());
        this.remotePort = httpRequest.getRemotePort();
        this.serverPort = httpRequest.getServerPort();
        this.attributes = Collections.list(httpRequest.getAttributeNames()).stream()
                .collect(Collectors.toMap(attribute -> attribute, attribute -> httpRequest.getAttribute(attribute)))
        ;
    }
}
