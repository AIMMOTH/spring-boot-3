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

Vocabulary:

- **Tenant**, regional data storage of service and profiles. Also colled **domain**
- **JWT** (Java Web Token). 3 parts divided by dots
- **Access token**, JWT to authenticate HTTP calls. Used with the Authorization bearer header.
- **Id token**, used to access basic profile information at Auth0
- **API**, machine-to-machine authentication service with signing algorithm. Identified with **API identifier** also called **audience**
- **Application**, client with a single application type and origin settings. Identified with **client id**
- **Database user**, email and password login. Can be used for an application 
- **Social Connection**, any social media or similar login. Can be used for an application

For instance, you create:

1. An Auth0 account at EU with a tenant name "aimmoth". Your tenant/domain will be aimmoth.eu.auth0.com 
2. An API with an API identifier and with RS256 signing algorithm. For instance "aimmoth-api-rs256" and it will be your audience
3. An application connected with the API. You set your domain settings here. This is your client and you get the client id
4. Then you can create a social media connection and activate it for your application/client

At Auth0:

1. Create an account (EU preferable) and a new tenant
2. Create an API using RSA246 (this will all clients connect to, including backend)
3. Create a Single Page Application client connected with the API
4. Add your localhost as allowed callback url, logout, web origins and CORS.
5. Keep track of domain (tenant.eu.auth0.com), audience (API identifier), client id (from Single Page Application client). Use these in application.yml and auth_config.json

### Start

You need to install Maven and Docker Desktop first.

1. Start Docker Desktop
2. Start Docker images > docker-compose up
3. Build with > mvn package
4. Run with > mvn spring-boot:start
5. Stop with > mvn spring-boot:stop

### Authorization

Depending on browser you need to log in each time you refresh. Firefox and Safari have stricter cookie settings.
You can always relax these settings.

The first login will redirect to Auth0 and the user need to consent.

Carl Emmoth 2023
