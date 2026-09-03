package org.example;

/**
 * Cuenta Corriente — producto pasivo con facilidad de sobregiro autorizado.
 * Extiende CuentaBancaria y sobreescribe retirar() para permitir saldo negativo
 * hasta el límite de sobregiro configurado.
 */
public class CuentaCorriente extends CuentaBancaria {

    /** Límite máximo de deuda permitida por sobregiro (valor positivo). */
    private double limiteSobregiro;

    public CuentaCorriente(String numeroProducto, String clienteId,
                           double saldoInicial, double limiteSobregiro) {
        super(numeroProducto, clienteId, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    /**
     * Permite retirar fondos dejando el saldo en negativo,
     * siempre que la deuda resultante no supere el límite de sobregiro autorizado.
     *
     * @param monto Importe a debitar.
     */
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("  [ERROR]     El monto a retirar debe ser positivo.");
            return;
        }
        double saldoResultante = saldo - monto;
        if (saldoResultante >= -limiteSobregiro) {
            saldo = saldoResultante;
            System.out.printf("  [RETIRO]    Debitados $%.2f — Saldo actual: $%.2f%n", monto, saldo);
        } else {
            System.out.printf("  [RECHAZADO] Operación rechazada: supera el límite de sobregiro de $%.2f%n",
                    limiteSobregiro);
        }
    }
}

