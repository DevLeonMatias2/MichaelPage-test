# Examen practico para Michael page

## Documentacion del Microservicio
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=alert_status)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=bugs)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=code_smells)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=ncloc)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=security_rating)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=sqale_index)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_ms-satisfaction&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=leon-cyber_ms-satisfaction)


Swagger :

Ver Dcoumentacion [Swagger](http://localhost:8081/michaelpage/swagger-ui.html)


#### Todo instalar con Docker
Se podria hacer con docker compose, para ejecutar todo junto (me quedó corto el tiempo para terminar con Docker compose)
### Backend

Crear el archivo .jar que usará docker.
Ejecutar comandos dentro de la ruta del proyecto
```sh
$ mvn clean package -Dmaven.test.skip=true
```

Crear la imagen de docker
```sh
$ docker build -t microservice-satisfaction:1.0-SNAPSHOT .
```

Listar las imagenes, para saber cual ejecutar
```sh
$ docker images
```

Ejecutar una imagen con el puerto interno 8080 y con el puerto externo 8081 ya que este usa en el proyecto angular de prueba
```sh
$ docker run -p 8081:8080  -d --name < NAME FOR IMAGE > < IMAGE ID >
```

Para ver las imagenes corriendo
```sh
$ docker ps
```
Body de el endpoint de creacion de nuevo registro
```sh
{
    "email": "leon@gmail.com",
    "name": "luis alberto",
    "createDate": "2020-07-01T14:59:15.870+00:00",
    "score": 0,
    "msj": "Esta es la encuesta"
}
```

Endpoints
```sh
[POST] http://localhost:8081/michaelpage/client/new
[GET] http://localhost:8081/michaelpage/client/report
```



==========================================================================================================
## Documentacion de la Web App

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_customer-app&metric=alert_status)](https://sonarcloud.io/dashboard?id=leon-cyber_customer-app)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_customer-app&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=leon-cyber_customer-app)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_customer-app&metric=ncloc)](https://sonarcloud.io/dashboard?id=leon-cyber_customer-app)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_customer-app&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=leon-cyber_customer-app)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_customer-app&metric=security_rating)](https://sonarcloud.io/dashboard?id=leon-cyber_customer-app)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=leon-cyber_customer-app&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=leon-cyber_customer-app)


despues de clonar, ir a la ruta del archivo y ejecutar para instalar las dependencias
```sh
$ npm install
```

Compilar el proyecto angular que vamos a dockerizar 
```sh
$ ng build --prod
```

Creamos la Imagen docker de la aplicacion que correra en un servidor NGINX
```sh
$ docker build -t customer-app .
```

Listar las imagenes, para saber cual ejecutar
```sh
$ docker images
```

Ejecutamos la imagen  
```sh
$ docker run -p 80:80 < IMAGE ID >
```
Web App estara en la url: http://localhost:80


Dockerfile 
```sh
FROM nginx:1.17.1-alpine
COPY /dist/customer-app /usr/share/nginx/html
```














