package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class Vehiculo {
    private int id_vehiculo;
    private String modelo;
    private int anio;
    private String estado;
    private int dependencia;
    private String marca;
    private int nivelGasolina;

    public Vehiculo(int id_vehiculo, String modelo, int anio, String estado, int dependencia, String marca, int nivelGasolina){
        this.id_vehiculo=id_vehiculo;
        this.modelo=modelo;
        this.anio=anio;
        this.estado=estado;
        this.dependencia=dependencia;
        this.marca=marca;
        this.nivelGasolina=nivelGasolina;
    }
    
    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDependencia() {
        return dependencia;
    }

    public void setDependencia(int dependencia) {
        this.dependencia = dependencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNivelGasolina() {
        return nivelGasolina;
    }

    public void setNivelGasolina(int nivelGasolina) {
        this.nivelGasolina = nivelGasolina;
    }
}
