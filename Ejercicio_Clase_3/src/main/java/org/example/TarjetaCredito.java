package org.example;


/**
 * Tarjeta de Crédito — producto activo de financiación rotativa.
 * El atributo {@code saldo} heredado representa la deuda acumulada (inicia en 0.0).
 * El límite de crédito define el tope máximo de consumo permitido.
 */
public class TarjetaCredito extends Producto {

    /** Límite máximo de crédito disponible para consumos. */
    private double limiteCredito;

    public TarjetaCredito(String numeroProducto, String clienteId, double limiteCredito) {
        super(numeroProducto, clienteId, 0.0); // deuda inicial = $0
        this.limiteCredito = limiteCredito;
    }

    /**
     * Registra un consumo incrementando la deuda acumulada,
     * siempre que no se supere el límite de crédito disponible.
     *
     * @param monto Importe del consumo a registrar.
     */
    public void pagarConTarjeta(double monto) {
        if (monto <= 0) {
            System.out.println("  [ERROR]     El monto de compra debe ser positivo.");
            return;
        }
        double deudaResultante = saldo + monto;
        if (deudaResultante <= limiteCredito) {
            saldo = deudaResultante;
            System.out.printf("  [COMPRA]    Consumo de $%.2f registrado — Deuda acumulada: $%.2f%n",
                    monto, saldo);
        } else {
            double disponible = limiteCredito - saldo;
            System.out.printf("  [RECHAZADO] Crédito insuficiente. Disponible: $%.2f%n", disponible);
        }
    }

    /**
     * Reduce la deuda acumulada si el monto es positivo.
     *
     * @param monto Importe del pago a aplicar.
     */
    public void pagarTarjeta(double monto) {
        if (monto <= 0) {
            System.out.println("  [ERROR]     El monto de pago debe ser positivo.");
            return;
        }
        saldo -= monto;
        if (saldo < 0) saldo = 0; // no permitir saldo acreedor
        System.out.printf("  [PAGO]      Acreditados $%.2f — Deuda restante: $%.2f%n", monto, saldo);
    }
}
