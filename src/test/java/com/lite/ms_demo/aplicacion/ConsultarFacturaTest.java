package com.lite.ms_demo.aplicacion;

import com.lite.ms_demo.dominio.Factura;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarFacturaTest {

    @Test
    @DisplayName("Debe crear una Factura con id y monto enviados")
    void ejecutar_creaFacturaConValoresDados() {
        ConsultarFactura servicio = new ConsultarFactura();

        int id = 123;
        int monto = 4500;

        Factura resultado = servicio.ejecutar(id, monto);

        assertNotNull(resultado, "La factura no debe ser nula");
        assertEquals(id, resultado.getId());
        assertEquals(4500.0, resultado.getMonto(), 0.0001);
    }

    @Test
    @DisplayName("Debe permitir valores en cero")
    void ejecutar_conCeros() {
        ConsultarFactura servicio = new ConsultarFactura();

        Factura resultado = servicio.ejecutar(0, 0);

        assertNotNull(resultado);
        assertEquals(0, resultado.getId());
        assertEquals(0.0, resultado.getMonto(), 0.0001);
    }

    @Test
    @DisplayName("Debe permitir valores negativos (sin validación en dominio)")
    void ejecutar_conNegativos() {
        ConsultarFactura servicio = new ConsultarFactura();

        Factura resultado = servicio.ejecutar(-1, -100);

        assertNotNull(resultado);
        assertEquals(-1, resultado.getId());
        assertEquals(-100.0, resultado.getMonto(), 0.0001);
    }
}
