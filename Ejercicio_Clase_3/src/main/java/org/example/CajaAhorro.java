package org.example;

/**
 * Cuenta de Caja de Ahorro — producto pasivo transaccional.
 * Hereda el comportamiento estándar de CuentaBancaria sin adiciones operativas.
 */
public class CajaAhorro extends CuentaBancaria {

    public CajaAhorro(String numeroProducto, String clienteId, double saldoInicial) {
        super(numeroProducto, clienteId, saldoInicial);
    }
}
