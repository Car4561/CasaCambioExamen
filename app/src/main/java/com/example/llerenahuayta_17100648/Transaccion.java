package com.example.llerenahuayta_17100648;

public class Transaccion {
    private int codigo;
    private double envia;
    private double recibe;
    private double valorTipoCambio;
    private String monedaTipocambio;
    private String fechaCreacion;
    private String estado;

    public Transaccion(int codigo, double envia, double recibe, double valorTipoCambio, String monedaTipocambio, String estado, String fechaCreacion) {
        this.codigo = codigo;
        this.envia = envia;
        this.recibe = recibe;
        this.valorTipoCambio = valorTipoCambio;
        this.monedaTipocambio = monedaTipocambio;
        this.estado=estado;
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getEnvia() {
        return envia;
    }

    public void setEnvia(double envia) {
        this.envia = envia;
    }

    public double getRecibe() {
        return recibe;
    }

    public void setRecibe(double recibe) {
        this.recibe = recibe;
    }

    public double getValorTipoCambio() {
        return valorTipoCambio;
    }

    public void setValorTipoCambio(double valorTipoCambio) {
        this.valorTipoCambio = valorTipoCambio;
    }

    public String getMonedaTipocambio() {
        return monedaTipocambio;
    }

    public void setMonedaTipocambio(String monedaTipocambio) {
        this.monedaTipocambio = monedaTipocambio;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
