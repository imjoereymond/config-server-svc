# Config Server

This repository contains a Spring Cloud Config Server that provides centralized configuration management for your microservices architecture. The server fetches configurations from a Git repository, specifically from the `development` branch, and serves them to registered clients.

## Features

- Centralized configuration management for microservices.
- Fetches configuration properties from a remote Git repository.
- Automatically serves configurations based on the environment and application name.
- Supports versioned configuration using branches (in this case, the `development` branch).

## Configuration Source

The Config Server fetches configuration details from a Git repository. It is configured to always retrieve configurations from the `development` branch of the remote repository.

### Git Repository

The configurations are fetched from the following Git repository:

- **Repository URL**: `https://github.com/imjoereymond/config-server-repo`
- **Branch**: `development`

### Example Structure in Git Repository

```
config-repo/
    ├── application.yml
    ├── microservice1-dev.yml
    └── microservice2-dev.yml
```

In this structure:

- `application.yml`: Common configuration for all services.
- `microservice1-dev.yml`: Configuration for `microservice1` in the `development` environment.
- `microservice2-dev.yml`: Configuration for `microservice2` in the `development` environment.

## How to Run the Config Server

1. Clone this repository:

   ```bash
   git clone https://github.com/imjoereymond/config-server-svc.git
   cd config-server-svc
   ```

2. Build and run the Config Server:

   ```bash
   ./mvnw spring-boot:run
   ```

   The server will start on `http://localhost:8888`.

## Configuration

You can modify the `application.yml` file located in `src/main/resources/` to customize the Git repository URL or other Config Server settings.

### Example `application.yml`

```yaml
server:
  port: 8888

spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/imjoereymond/config-server-repo
          clone-on-start: true
          default-label: development
```

## Accessing Configuration

Clients can access their configurations by making HTTP requests to the Config Server. For example:

```
http://localhost:8888/{application}/{profile}/{label}
```

- `application`: The name of the application (e.g., `microservice1`).
- `profile`: The environment profile (e.g., `dev`).
- `label`: The Git branch (e.g., `development`).

### Example Request

To get the configuration for `microservice1` in the `development` environment:

```
http://localhost:8888/microservice1/dev
```

## Security

To secure your Config Server, consider implementing security mechanisms like:

- Basic Authentication
- OAuth2 or other token-based authentication

Refer to the Spring documentation for more details on securing your Config Server.

## Troubleshooting

- Ensure that the Git URL and branch specified in the `application.yml` file are correct.
- Make sure the Config Server has access to the Git repository.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
