# ForoHub - Challenge Backend ONE Alura  

¡Bienvenido al proyecto **Challenge Backend ONE** de Alura!  

Este repositorio contiene mi solución al desafío, que consiste en desarrollar una **API REST** utilizando **Spring Boot 3**.  
El proyecto, llamado **ForoHub**, simula el funcionamiento de un foro.  

**EDIT** En este repositorio [Foro-API-Spring](https://github.com/Alonso-dev651/Foro-API-Spring) estoy realizando un version mejorada.

## Funcionalidades  
- **Iniciar sesión:** Al ingresar un email y contraseña válidos, se genera un token JWT que permite acceder a las demás funcionalidades de forma segura.  
- **Crear un tópico:** Los usuarios pueden generar nuevos temas de discusión en el foro.  
- **Listar tópicos:** Se muestra una lista con todos los tópicos creados.  
- **Editar tópicos:** Permite modificar un tópico específico.  
- **Eliminar tópicos:** Posibilita la eliminación de un tópico del foro.

## Tecnologías utilizadas ☕🚀

- [Java 21](https://www.oracle.com/pe/java/technologies/downloads/) ☕
- [IntelliJ IDEA Community](https://www.jetbrains.com/es-es/idea/) 💡
- [Spring Boot 3](https://start.spring.io) 🍃
- [JWT auth0](https://github.com/auth0/java-jwt) 🔑
- [lombok](https://projectlombok.org) 🪶
- [springdoc](https://springdoc.org) 📄
- [flyway mysql](https://github.com/flyway/flyway) 🐦

## Ejecución y configuración 🚀

Para poner en marcha este proyecto, sigue estos sencillos pasos:

**1. Clonar el repositorio:**

```bash
git clone https://github.com/Alonso-dev651/ChallengeForoHubProyecto.git
cd ChallengeForoHubProyecto
```

**2. Configurar la base de datos:**
Edita el archivo application.properties con la información de tu base de datos:
```bash
spring.datasource.url=jdbc:mysql://localhost/forohub_api
spring.datasource.username=root
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.format-sql=true

api.security.secret=${JWT_TOKEN:123456}
```
Tip: Puedes configurar la variable de entorno JWT_TOKEN para mayor seguridad.

**3. Compilar y ejecutar el proyecto**
```bash
mvn clean install
mvn spring-boot:run
```

**4. Acceder a la API:**
Abre tu navegador y visita  http:localhost:8080 para comenzar a usar la API. 🎉

**Recomendaciones:**
* Asegúrate de tener instalado Maven y una base de datos MySQL.
* Revisa la documentación de la API en `http:localhost:8080/swagger-ui/index.html` para conocer los endpoints disponibles.

## Contacto 🤝

¡Me encantaría estar en contacto contigo! Puedes encontrarme en:

* **Discord:** alonsopb 🎧
* **LinkedIn:** [Alonso Dev](https://www.linkedin.com/in/alonso-dev/) 💼
* **Correo electrónico:** [alonsodev.ga@gmail.com](mailto:alonsodev.ga@gmail.com) ✉️

No dudes en contactarme si tienes alguna pregunta, sugerencia o simplemente quieres saludar. 👋








