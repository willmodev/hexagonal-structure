# Store API - Arquitectura Hexagonal

## Descripción

Este proyecto implementa una API REST para una tienda online utilizando arquitectura hexagonal (también conocida como arquitectura de puertos y adaptadores) y siguiendo los principios de Domain-Driven Design (DDD).

La arquitectura hexagonal permite separar claramente las preocupaciones de la aplicación, haciendo que el código sea más mantenible, testeable y adaptable a cambios.

## Estructura del Proyecto

El proyecto sigue una estructura de paquetes que refleja la arquitectura hexagonal:

```
com.hexagonal.store
├── application         # Capa de aplicación
│   ├── port           # Puertos (interfaces)
│   │   ├── input      # Puertos de entrada (casos de uso)
│   │   └── output     # Puertos de salida (repositorios)
│   └── service        # Implementaciones de casos de uso
├── domain              # Capa de dominio
│   ├── exception      # Excepciones de dominio
│   ├── model          # Entidades y objetos de valor
│   └── service        # Servicios de dominio
├── infrastructure      # Capa de infraestructura
│   ├── config         # Configuraciones
│   ├── input          # Adaptadores de entrada
│   │   └── rest       # Controladores REST
│   │       ├── dto     # DTOs para la API
│   │       └── mapper  # Mappers para DTOs
│   └── output         # Adaptadores de salida
│       └── persistence # Persistencia
│           ├── adapter  # Adaptadores de repositorio
│           ├── entity   # Entidades JPA
│           ├── mapper   # Mappers para entidades JPA
│           └── repository # Repositorios JPA
└── shared              # Componentes compartidos
    ├── exception      # Excepciones comunes
    └── util           # Clases de utilidad
```

## Capas de la Arquitectura Hexagonal

### 1. Capa de Dominio

El núcleo de la aplicación que contiene la lógica de negocio. Esta capa es independiente de cualquier framework o tecnología externa.

- **Modelos de Dominio**: Entidades y objetos de valor que representan conceptos del negocio.
- **Servicios de Dominio**: Lógica de negocio compleja que opera sobre múltiples entidades.
- **Excepciones de Dominio**: Excepciones específicas del dominio.

### 2. Capa de Aplicación

Orquesta el flujo de datos entre el exterior y el dominio, aplicando la lógica de casos de uso.

- **Puertos de Entrada**: Interfaces que definen las operaciones que la aplicación expone al exterior (casos de uso).
- **Puertos de Salida**: Interfaces que definen las operaciones que la aplicación necesita del exterior (repositorios).
- **Servicios de Aplicación**: Implementan los casos de uso utilizando entidades de dominio y puertos de salida.

### 3. Capa de Infraestructura

Contiene adaptadores que conectan la aplicación con sistemas externos como bases de datos, APIs, etc.

- **Adaptadores de Entrada**: Implementan los puertos de entrada (controladores REST, consumidores de mensajes).
- **Adaptadores de Salida**: Implementan los puertos de salida (repositorios JPA, clientes HTTP).
- **Configuración**: Configuración de frameworks y bibliotecas.

## Tecnologías Utilizadas

- **Spring Boot**: Framework para crear aplicaciones Java
- **Spring Data JPA**: Para la persistencia de datos
- **Spring Security**: Para la seguridad de la API
- **Lombok**: Para reducir código boilerplate
- **MapStruct**: Para mapeo entre objetos
- **H2/MySQL**: Base de datos
- **Swagger/OpenAPI**: Documentación de la API

## Características Principales

- **Productos**: Gestión de productos con categorías
- **Descuentos**: Sistema de reglas de descuento configurable
- **Seguridad**: Autenticación y autorización
- **Documentación API**: Interfaz Swagger para explorar y probar endpoints

## Cómo Ejecutar

1. Clonar el repositorio
2. Configurar la base de datos en `application.properties`
3. Ejecutar con Maven: `mvn spring-boot:run`
4. Acceder a la API en `http://localhost:8080`
5. Explorar la documentación en `http://localhost:8080/swagger-ui.html`

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

## Principios de Diseño

- **SOLID**: Principios de diseño orientado a objetos
- **Clean Code**: Código limpio y legible
- **DRY**: No repetir código
- **Inmutabilidad**: Uso de objetos inmutables cuando sea posible
- **Fail-Fast**: Validación temprana de errores

## Licencia

MIT
