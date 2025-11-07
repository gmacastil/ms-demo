package com.lite.ms_demo.dominio;

import java.util.HashMap;

import net.logstash.logback.argument.StructuredArgument;

import static net.logstash.logback.argument.StructuredArguments.entries;

public class Factura {
    private int id;
    private double monto;
    private double impuesto;
    private double descuento;
    private double total;

    public Factura(int id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }   

    public double getMonto() {
        return monto;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setDescuento(double descuento) {    
        this.descuento = descuento;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
    public double getImpuesto() {
        return impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getTotal() {
        return total;
    }
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public StructuredArgument getValues() {
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.id);
        map.put("monto", this.monto);
        map.put("impuesto", this.impuesto);
        map.put("descuento", this.descuento);       
        map.put("total", this.total);
        return entries(map);
   }
}
