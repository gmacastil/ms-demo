package com.lite.ms_demo.aplicacion;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.lite.ms_demo.dominio.Factura;
import java.security.SecureRandom;

public class ConsultarFactura {

    private static final Logger log = LoggerFactory.getLogger(ConsultarFactura.class);

    public Factura ejecutar(int id, int monto) {
        Factura factura = new Factura(id, monto);
        // Cálculos de impuesto y descuento
        // Constantes para mejorar legibilidad y mantenibilidad
        final double IMPUESTO_MIN = 0.15;
        final double IMPUESTO_MAX = 0.25;
        final double DESCUENTO_MAX = 0.05;
        
        // Inicialización de generador de números aleatorios seguro
        SecureRandom random = new SecureRandom();
        
        // Validación de monto para evitar cálculos con valores negativos
        if (monto < 0) {
            log.warn("Se detectó un monto negativo: {}. Los cálculos podrían no ser correctos.", monto);
        }
        
        // Cálculo de impuesto (entre 15% y 25%)
        double tasaImpuesto = IMPUESTO_MIN + (random.nextDouble() * (IMPUESTO_MAX - IMPUESTO_MIN));
        double impuesto = Math.round(monto * tasaImpuesto * 100) / 100.0;
        
        // Cálculo de descuento (entre 0% y 5%)
        double tasaDescuento = random.nextDouble() * DESCUENTO_MAX;
        double descuento = Math.round(monto * tasaDescuento * 100) / 100.0;
        
        // Cálculo del total redondeado a dos decimales para mayor precisión
        double total = Math.round((monto + impuesto - descuento) * 100) / 100.0;
        factura.setImpuesto(impuesto);
        factura.setDescuento(descuento);
        factura.setTotal(total);

        // Registrar en log con información detallada
        log.info("Factura calculada: ID={}, Monto={}, Impuesto={}, Descuento={}, Total={}",
                factura.getId(), factura.getMonto(), factura.getImpuesto(),
                factura.getDescuento(), factura.getTotal());
        log.debug("Detalles completos de la factura", factura.getValues());

        return factura;
    }
    
}
