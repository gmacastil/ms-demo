package com.lite.ms_demo.aplicacion;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.lite.ms_demo.dominio.Factura;

public class ConsultarFactura {

    private static final Logger log = LoggerFactory.getLogger(ConsultarFactura.class);

    public Factura ejecutar(int id, int monto) {
        Factura factura = new Factura(id, monto);
        // Cálculos aleatorios del monto
        double impuesto = monto * (Math.random() * 0.1 + 0.15); // 15-25%
        double descuento = monto * (Math.random() * 0.05); // 0-5%
        double total = monto + impuesto - descuento;
        factura.setImpuesto(impuesto);
        factura.setDescuento(descuento);
        factura.setTotal(total);

        // Registrar en log
        log.info(null, factura.getValues());

        return factura;
    }
    
}
