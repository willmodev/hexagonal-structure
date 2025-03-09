/**
 * NOTA: Este paquete está obsoleto y se mantiene temporalmente por compatibilidad.
 * 
 * Según la arquitectura hexagonal correcta:
 * - Los puertos de entrada (interfaces de casos de uso) deben estar en el paquete application.port.input
 * - Las implementaciones de servicios deben estar en el paquete application.service
 *
 * Por favor, no añadir nuevas clases a este paquete.
 * En su lugar, utilizar la estructura correcta:
 * - Interfaces de casos de uso: application.port.input
 * - Implementaciones: application.service
 */
package com.hexagonal.store.application.usecase;
