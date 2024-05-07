package com.tesji.practicaspinner.model;

public class CarrerasModel {
    private int cliente;
    private int pago;
    private int monto;

    public String mostrarInfo() {
        String infoCarrera = "";
        String clienteT="No hay tipo";
        String pagoT = "No hay tipo";
        String des = "";
        double pagoTotal = 0;
        double montoE = 0;
        int bandera = 1;

        if (pago==0){
            bandera = 0;
        } else if( pago == 1){
            pagoT = "Credito";
            des = " \n El aumento en el costo es de: ";
            if (cliente==0){
                bandera = 0;
            }else if (cliente == 1){
                clienteT = "General";
                montoE = 0.1;
                pagoTotal = monto + (monto * montoE);

            }else if (cliente == 2){
                clienteT = "Afiliado";
                montoE = 0.05;
                pagoTotal = monto + (monto * montoE);
            }
        } else if (pago == 2) {
            pagoT = "Contado";
            des = " \n El descuento en el costo es de: ";
            if (cliente==0){
                bandera = 0;
            }else if (cliente == 1){
                clienteT = "General";
                montoE = 0.15;
                pagoTotal = monto - (monto * montoE);
            }else if (cliente == 2){
                clienteT = "Afiliado";
                montoE = 0.20;
                pagoTotal = monto - (monto * montoE);
            }
        }

        if (bandera == 1) {
            infoCarrera = " El tipo de cliente es: " + clienteT + "\n El formato de pago es: " + pagoT + "\n El monto bruto es: " + monto
                    + des + montoE + "%  \n El monto a pagar es de: " + pagoTotal;
        } else {
            infoCarrera = "Error de ejecucion, prueba de nuevo";
        }

        return infoCarrera;
    }


    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


}
