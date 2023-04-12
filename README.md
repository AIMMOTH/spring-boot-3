# Simple Spring Boot 3

Running Spring Boot 3 with the following features:

- Properties (YAML)
- Value, read a value from properties and use it
- Application
- Config, enabling WebSocket with an echoing handler
- Open API including schema
- Controllers implementing generated Open API interfaces
- Autowired services
- Static HTML including JavaScript
- Simple HTML form and JavaScript action listeners
- JavaScript from Baeldung's blog implementing simple WebRTC/WebSocket client
- JUnit 5
- Mockito
- Lombok
- Auth0 4.4 JWT Access Token authorization (/api/v1/private)
- CORS
- CSP

## Instructions

### Auth0

At Auth0:

1. Create an account (EU preferable) and a new tenant
2. Create an API using RSA246 (this will all clients connect to, including backend)
3. Create an Application connected with the API
4. Keep track of domain (tenant.eu.auth0.com), audience (API name), client id

### Start

You need to install Maven and Docker Desktop first.

1. Start Docker Desktop
2. Start Docker images > docker-compose up
3. Build with > mvn package
4. Run with > mvn spring-boot:start
5. Stop with > mvn spring-boot:stop

Carl Emmoth 2023
