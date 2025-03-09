# Store API - Arquitectura Hexagonal

## Descripciu00f3n

Este proyecto implementa una API REST para una tienda online utilizando arquitectura hexagonal (tambiu00e9n conocida como arquitectura de puertos y adaptadores) y siguiendo los principios de Domain-Driven Design (DDD).

La arquitectura hexagonal permite separar claramente las preocupaciones de la aplicaciu00f3n, haciendo que el cu00f3digo sea mu00e1s mantenible, testeable y adaptable a cambios.

## Estructura del Proyecto

El proyecto sigue una estructura de paquetes que refleja la arquitectura hexagonal:

```
com.hexagonal.store
u251cu2500u2500 application         # Capa de aplicaciu00f3n
u2502   u251cu2500u2500 port           # Puertos (interfaces)
u2502   u2502   u251cu2500u2500 input      # Puertos de entrada (casos de uso)
u2502   u2502   u2514u2500u2500 output     # Puertos de salida (repositorios)
u2502   u2514u2500u2500 service        # Implementaciones de casos de uso
u251cu2500u2500 domain              # Capa de dominio
u2502   u251cu2500u2500 exception      # Excepciones de dominio
u2502   u251cu2500u2500 model          # Entidades y objetos de valor
u2502   u2514u2500u2500 service        # Servicios de dominio
u251cu2500u2500 infrastructure      # Capa de infraestructura
u2502   u251cu2500u2500 config         # Configuraciones
u2502   u251cu2500u2500 input          # Adaptadores de entrada
u2502   u2502   u2514u2500u2500 rest       # Controladores REST
u2502   u2502       u251cu2500u2500 dto     # DTOs para la API
u2502   u2502       u2514u2500u2500 mapper  # Mappers para DTOs
u2502   u2514u2500u2500 output         # Adaptadores de salida
u2502       u2514u2500u2500 persistence # Persistencia
u2502           u251cu2500u2500 adapter  # Adaptadores de repositorio
u2502           u251cu2500u2500 entity   # Entidades JPA
u2502           u251cu2500u2500 mapper   # Mappers para entidades JPA
u2502           u2514u2500u2500 repository # Repositorios JPA
u2514u2500u2500 shared              # Componentes compartidos
    u251cu2500u2500 exception      # Excepciones comunes
    u2514u2500u2500 util           # Clases de utilidad
```

## Capas de la Arquitectura Hexagonal

### 1. Capa de Dominio

El nu00facleo de la aplicaciu00f3n que contiene la lu00f3gica de negocio. Esta capa es independiente de cualquier framework o tecnologu00eda externa.

- **Modelos de Dominio**: Entidades y objetos de valor que representan conceptos del negocio.
- **Servicios de Dominio**: Lu00f3gica de negocio compleja que opera sobre mu00faltiples entidades.
- **Excepciones de Dominio**: Excepciones especu00edficas del dominio.

### 2. Capa de Aplicaciu00f3n

Orquesta el flujo de datos entre el exterior y el dominio, aplicando la lu00f3gica de casos de uso.

- **Puertos de Entrada**: Interfaces que definen las operaciones que la aplicaciu00f3n expone al exterior (casos de uso).
- **Puertos de Salida**: Interfaces que definen las operaciones que la aplicaciu00f3n necesita del exterior (repositorios).
- **Servicios de Aplicaciu00f3n**: Implementan los casos de uso utilizando entidades de dominio y puertos de salida.

### 3. Capa de Infraestructura

Contiene adaptadores que conectan la aplicaciu00f3n con sistemas externos como bases de datos, APIs, etc.

- **Adaptadores de Entrada**: Implementan los puertos de entrada (controladores REST, consumidores de mensajes).
- **Adaptadores de Salida**: Implementan los puertos de salida (repositorios JPA, clientes HTTP).
- **Configuraciu00f3n**: Configuraciu00f3n de frameworks y bibliotecas.

## Tecnologu00edas Utilizadas

- **Spring Boot**: Framework para crear aplicaciones Java
- **Spring Data JPA**: Para la persistencia de datos
- **Spring Security**: Para la seguridad de la API
- **Lombok**: Para reducir cu00f3digo boilerplate
- **MapStruct**: Para mapeo entre objetos
- **H2/MySQL**: Base de datos
- **Swagger/OpenAPI**: Documentaciu00f3n de la API

## Caracteru00edsticas Principales

- **Productos**: Gestiu00f3n de productos con categoru00edas
- **Descuentos**: Sistema de reglas de descuento configurable
- **Seguridad**: Autenticaciu00f3n y autorizaciu00f3n
- **Documentaciu00f3n API**: Interfaz Swagger para explorar y probar endpoints

## Cu00f3mo Ejecutar

1. Clonar el repositorio
2. Configurar la base de datos en `application.properties`
3. Ejecutar con Maven: `mvn spring-boot:run`
4. Acceder a la API en `http://localhost:8080`
5. Explorar la documentaciu00f3n en `http://localhost:8080/swagger-ui.html`

## Endpoints Principales

### Productos

- `GET /products`: Listar todos los productos
- `GET /products/{id}`: Obtener un producto por ID
- `POST /products`: Crear un nuevo producto
- `PUT /products/{id}`: Actualizar un producto existente
- `DELETE /products/{id}`: Eliminar un producto

### Descuentos

- `GET /discounts/rules`: Listar todas las reglas de descuento activas
- `POST /discounts/rules`: Crear una nueva regla de descuento
- `GET /discounts/products/{productId}/price`: Calcular precio con descuento

## Principios de Diseu00f1o

- **SOLID**: Principios de diseu00f1o orientado a objetos
- **Clean Code**: Cu00f3digo limpio y legible
- **DRY**: No repetir cu00f3digo
- **Inmutabilidad**: Uso de objetos inmutables cuando sea posible
- **Fail-Fast**: Validaciu00f3n temprana de errores

## Licencia

MIT
