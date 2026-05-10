# CLI Agenda

Aplicación Java de consola orientada a la gestión de una agenda. El proyecto está organizado por dominios (`task`, `note`, `event`) y preparado para trabajar con una base de datos MySQL mediante JDBC.

## Tecnologías utilizadas

- Java 21
- Maven
- MySQL 8
- JDBC (`mysql-connector-j`)
- JUnit 5
- Docker y Docker Compose

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- JDK 21
- Maven 3.9 o superior
- Docker Desktop o Docker Engine con Docker Compose
- Git

### Base de datos y configuración actual

El proyecto incluye un `docker-compose.yml` con un servicio MySQL accesible en `localhost:3307`.

Configuración actual del contenedor:

- Base de datos: `agenda_db`
- Puerto expuesto: `3307`
- Usuario definido en Docker: `agenda_user`
- Contraseña definida en Docker: `1234`
- Usuario root: `root`
- Contraseña root: `root`

Configuración actual del código en `ConnectionManager`:

- URL: `jdbc:mysql://localhost:3307/agenda_db`
- Usuario: `root`
- Contraseña: `root`

Esto significa que, en el estado actual del proyecto, la conexión Java está preparada para usar el usuario `root`. Si se cambia esta configuración en código, el `README` debería actualizarse también.

### Variables de entorno

Actualmente no hay variables de entorno implementadas para la conexión a base de datos. Las credenciales están definidas directamente en:

- [src/main/java/com/agenda/infrastructure/sql/ConnectionManager.java](/J:/Bootcamp/Proyectos/TascaS3.04/src/main/java/com/agenda/infrastructure/sql/ConnectionManager.java)

Como mejora recomendada, conviene externalizar:

- `DB_URL`
- `DB_USER`
- `DB_PASSWORD`

## Instalación y ejecución

## 1. Clonar el repositorio

```bash
git clone https://github.com/erictc95/TascaS3.04.git
cd TascaS3.04
```

## 2. Levantar la base de datos en desarrollo

```bash
docker compose up -d
```

Esto iniciará:

- `agenda-mysql`
- `agenda-java`

## 3. Compilar el proyecto

```bash
mvn clean compile
```

## 4. Ejecutar pruebas

```bash
mvn test
```

Nota: por ahora apenas hay estructura de tests en `src/test/java`, así que esta parte está preparada pero todavía no tiene cobertura funcional relevante.

## 5. Ejecutar en modo desarrollo

### Probar la conexión con MySQL

Después de levantar MySQL y compilar el proyecto, la forma más directa de probar la conexión en el estado actual del repositorio es ejecutar desde el IDE la clase:

- [src/main/java/com/agenda/application/TestConnection.java](/J:/Bootcamp/Proyectos/TascaS3.04/src/main/java/com/agenda/application/TestConnection.java)

Actualmente no hay un perfil Maven específico ni un plugin de ejecución configurado para lanzar esa clase directamente con un comando corto.

### Ejecutar el punto de entrada principal

La clase principal del proyecto es:

- [src/main/java/com/agenda/application/AgendaApp.java](/J:/Bootcamp/Proyectos/TascaS3.04/src/main/java/com/agenda/application/AgendaApp.java)

Actualmente su método `main` está vacío, por lo que todavía no existe un flujo funcional de aplicación CLI completo.

## 6. Ejecución en producción

Por el estado actual del repositorio, no hay un empaquetado de producción ni una imagen de aplicación lista para despliegue. Si se necesita una ejecución tipo producción, el flujo base sería:

```bash
mvn clean package
```

Y después ejecutar el `.jar` generado en `target/`, una vez definido correctamente el punto de entrada y completada la lógica de aplicación.

## Estructura del proyecto

```text
src/
  main/
    java/com/agenda/
      application/
      common/
      event/
      infrastructure/
      note/
      task/
  test/
    java/com/agenda/
sql/
  init.sql
```

Descripción de los principales paquetes:

- `com.agenda.application`: punto de entrada de la aplicación y utilidades de arranque.
- `com.agenda.common`: paquetes compartidos para excepciones, persistencia y utilidades comunes.
- `com.agenda.event`: estructura del dominio de eventos (`cli`, `dto`, `model`, `repository`, `service`).
- `com.agenda.note`: estructura del dominio de notas (`cli`, `dto`, `model`, `repository`, `service`).
- `com.agenda.task`: estructura del dominio de tareas (`cli`, `dto`, `model`, `repository`, `service`).
- `com.agenda.infrastructure.sql`: acceso a infraestructura SQL y gestión de conexión con MySQL.
- `sql/init.sql`: script SQL reservado para inicialización de base de datos. En este momento está vacío.
- `target/`: salida de compilación generada por Maven.

## Estado actual del proyecto

En el repositorio existe la base estructural del proyecto, pero todavía hay partes en fase inicial:

- La clase principal `AgendaApp` no contiene lógica.
- El script `sql/init.sql` está vacío.
- No hay configuración por variables de entorno.
- La estructura de paquetes está creada, pero la implementación funcional aún es parcial.

## Autores o colaboradores

Según el historial Git visible en el repositorio, aparecen estas autorías:

- Eric (`erictc95`)
- David Toledo (`DvToledo199`)
- Joel Quintana (`Quint3in`)