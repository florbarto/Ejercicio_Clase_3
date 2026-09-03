package org.example;

/**
 * Plazo Fijo — producto de inversión a término.
 * El capital inmovilizado (saldo) genera intereses al vencimiento según
 * la tasa y el plazo pactados.
 */
public class PlazoFijo extends Producto {

    /** Cantidad de días del plazo pactado. */
    private int plazoDias;

    /** Tasa de interés anual expresada en porcentaje (ej: 45.0 = 45%). */
    private double tasaInteres;

    public PlazoFijo(String numeroProducto, String clienteId,
                     double capital, int plazoDias, double tasaInteres) {
        super(numeroProducto, clienteId, capital);
        this.plazoDias   = plazoDias;
        this.tasaInteres = tasaInteres;
    }

    /**
     * Calcula e imprime el resultado del plazo fijo al vencimiento:
     * capital original, ganancia generada y monto total a percibir.
     *
     * Fórmula: Ganancia = saldo * (tasaInteres / 100) * (plazoDias / 365.0)
     */
    public void simularVencimiento() {
        double ganancia    = saldo * (tasaInteres / 100) * (plazoDias / 365.0);
        double montoTotal  = saldo + ganancia;

        System.out.println("  [SIMULACIÓN DE VENCIMIENTO]");
        System.out.printf("    Capital invertido : $%.2f%n", saldo);
        System.out.printf("    Plazo             : %d días%n", plazoDias);
        System.out.printf("    Tasa anual        : %.2f%%%n", tasaInteres);
        System.out.printf("    Ganancia generada : $%.2f%n", ganancia);
        System.out.printf("    Monto al cobro    : $%.2f%n", montoTotal);
    }
}
