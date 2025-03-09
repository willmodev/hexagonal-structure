/**
 * Este paquete contiene los puertos de salida (interfaces) que definen las operaciones requeridas de los adaptadores secundarios.
 * 
 * Los puertos de salida:
 * - Definen contratos para operaciones externas (persistencia, mensajería, etc.)
 * - Son interfaces que serán implementadas por los adaptadores
 * - Utilizan modelos de dominio como parámetros y retornos
 * - Mantienen el dominio aislado de detalles externos
 * 
 * Ejemplo: ProductRepository, NotificationPort
 */
package com.hexagonal.store.application.port.output;
