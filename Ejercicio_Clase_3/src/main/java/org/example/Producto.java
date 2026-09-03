package org.example;

/**
 * Clase base que representa un producto bancario genérico.
 * Todas las líneas de producto del core bancario heredan de esta clase.
 */
public class Producto {

    protected String numeroProducto;
    protected String clienteId;
    protected double saldo;

    /**
     * Constructor base de un producto bancario.
     *
     * @param numeroProducto Identificador único del producto.
     * @param clienteId      Identificador del cliente titular.
     * @param saldoInicial   Saldo o deuda inicial del producto.
     */
    public Producto(String numeroProducto, String clienteId, double saldoInicial) {
        this.numeroProducto = numeroProducto;
        this.clienteId      = clienteId;
        this.saldo          = saldoInicial;
    }

    /**
     * Imprime por consola el estado actual del producto:
     * número de producto y saldo/balance vigente.
     */
    public void consultarEstado() {
        System.out.printf("Producto: %-15s | Cliente: %-10s | Saldo: $%.2f%n",
                numeroProducto, clienteId, saldo);
    }
}
