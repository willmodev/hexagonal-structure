/**
 * Este paquete contiene los adaptadores de persistencia que implementan los puertos de salida.
 * 
 * Los adaptadores de persistencia:
 * - Implementan las interfaces de repositorio definidas en los puertos de salida
 * - Manejan la persistencia real de datos (JPA, MongoDB, etc.)
 * - Convierten entre entidades de dominio y entidades de persistencia
 * - Encapsulan los detalles específicos de la base de datos
 * - Manejan transacciones y conexiones
 */
package com.hexagonal.store.infrastructure.output.persistence;
