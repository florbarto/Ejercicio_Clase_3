package org.example;

/**
 * Clase intermedia que representa una cuenta bancaria transaccional.
 * Agrega operaciones de depósito y retiro sobre la clase base Producto.
 */
public class CuentaBancaria extends Producto {

    public CuentaBancaria(String numeroProducto, String clienteId, double saldoInicial) {
        super(numeroProducto, clienteId, saldoInicial);
    }

    /**
     * Incrementa el saldo de la cuenta si el monto es positivo.
     *
     * @param monto Importe a acreditar.
     */
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.printf("  [DEPÓSITO]  Acreditados $%.2f — Saldo actual: $%.2f%n", monto, saldo);
        } else {
            System.out.println("  [ERROR]     El monto a depositar debe ser positivo.");
        }
    }

    /**
     * Disminuye el saldo únicamente si el monto es positivo y hay fondos suficientes.
     *
     * @param monto Importe a debitar.
     */
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("  [ERROR]     El monto a retirar debe ser positivo.");
            return;
        }
        if (saldo >= monto) {
            saldo -= monto;
            System.out.printf("  [RETIRO]    Debitados $%.2f — Saldo actual: $%.2f%n", monto, saldo);
        } else {
            System.out.printf("  [ALERTA]    Fondos insuficientes. Saldo disponible: $%.2f%n", saldo);
        }
    }
}

