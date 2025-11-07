package com.lite.ms_demo.infraestructura;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lite.ms_demo.aplicacion.ConsultarFactura;
import com.lite.ms_demo.dominio.Factura;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Controller {

    @Value("${app.factor}")
    private int factor;

    @Value("${app.monto}")
    private int monto;

    @GetMapping("/factura")
    public Factura getFactura() {
        ConsultarFactura factura = new ConsultarFactura();
        return factura.ejecutar(factor, monto);
    }

    @GetMapping("/calcular")
    public String calcular(@RequestParam String param) {
        return new String();
    }
    

}
