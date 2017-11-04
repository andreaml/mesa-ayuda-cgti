package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class Area {
    private int id_area;
    private String nombreArea;
    private int dependencia;
      
    public Area(int id_area, String nombreArea, int dependencia){
        this.id_area=id_area;
        this.nombreArea=nombreArea;
        this.dependencia=dependencia;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public int getDependencia() {
        return dependencia;
    }

    public void setDependencia(int dependencia) {
        this.dependencia = dependencia;
    }
}
