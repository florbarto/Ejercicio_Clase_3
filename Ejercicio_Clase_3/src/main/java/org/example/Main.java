package org.example;

/**
 * Clase ejecutable — Prueba de aceptación de la jerarquía de productos bancarios.
 *
 * Ejecutar con IntelliJ IDEA: botón ▶ sobre este archivo, o Run > Run 'Main'.
 * Ejecutar con Maven: mvn compile exec:java
 */
public class Main {

    public static void main(String[] args) {

        // =====================================================================
        System.out.println("=== Paso 1: Validación de Caja de Ahorro ===");
        // =====================================================================

        CajaAhorro ca = new CajaAhorro("CA-0001", "CLI-001", 5000.00);
        ca.consultarEstado();

        ca.retirar(1000.00);   // Esperado: saldo $4,000
        ca.retirar(6000.00);   // Esperado: alerta fondos insuficientes

        ca.consultarEstado();

        // =====================================================================
        System.out.println("\n=== Paso 2: Validación de Cuenta Corriente (Sobregiro) ===");
        // =====================================================================

        CuentaCorriente cc = new CuentaCorriente("CC-0001", "CLI-002", 1000.00, 2000.00);
        cc.consultarEstado();

        cc.retirar(2500.00);   // Esperado: saldo -$1,500 (dentro del sobregiro)
        cc.retirar(1000.00);   // Esperado: rechazado (superaría -$2,500 > límite -$2,000)

        cc.consultarEstado();

        // =====================================================================
        System.out.println("\n=== Paso 3: Validación de Plazo Fijo ===");
        // =====================================================================

        PlazoFijo pf = new PlazoFijo("PF-0001", "CLI-003", 10000.00, 30, 45.0);
        pf.consultarEstado();
        pf.simularVencimiento();
        // Esperado: Ganancia = 10000 * (45/100) * (30/365) ≈ $369.86

        // =====================================================================
        System.out.println("\n=== Paso 4: Validación de Tarjeta de Crédito ===");
        // =====================================================================

        TarjetaCredito tc = new TarjetaCredito("TC-0001", "CLI-004", 50000.00);
        tc.consultarEstado();   // Deuda inicial: $0

        tc.pagarConTarjeta(15000.00);   // Esperado: deuda $15,000
        tc.pagarConTarjeta(40000.00);   // Esperado: rechazado (disponible $35,000)
        tc.pagarTarjeta(5000.00);       // Esperado: deuda $10,000

        tc.consultarEstado();           // Balance final: $10,000 de deuda
    }
}
