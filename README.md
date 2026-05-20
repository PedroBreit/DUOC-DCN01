# Sistema de Inscripciones - Cloud Native
 
## Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Oracle Cloud Autonomous Database
- Docker
- Docker Hub
- AWS EC2
- GitHub Actions
- Postman

## Arquitectura
GitHub → GitHub Actions → Docker Hub → AWS EC2 → Oracle Cloud DB

## Funcionalidades
- CRUD Cursos
- Registro de Inscripciones
- API REST
- Persistencia Oracle

## Endpoints
GET /api/cursos
POST /api/cursos
POST /api/inscripciones

## CI/CD
Cada push a main:
1. Compila proyecto
2. Genera imagen Docker
3. Publica en Docker Hub
4. Despliega automáticamente en EC2
