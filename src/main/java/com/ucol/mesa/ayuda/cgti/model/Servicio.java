package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class Servicio {
    private int id_servicio;
    private String nombreServicio;
    private String especialista;
    private int id_vehiculo;
    private int nivelGasolinaInicio;
    private int nivelGasolinaFin;
    
    public Servicio(){}
    
    public Servicio(int id_servicio, String nombreServicio, String especialista, int id_vehiculo, int nivelGasolinaInicio){
        this.id_servicio=id_servicio; 
        this.nombreServicio=nombreServicio;
        this.especialista=especialista;
        this.id_vehiculo=id_vehiculo;
        this.nivelGasolinaInicio=nivelGasolinaInicio;   
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int vehiculo) {
        this.id_vehiculo = vehiculo;
    }
    
    public int getNivelGasolinaInicio() {
        return nivelGasolinaInicio;
    }

    public void setNivelGasolinaInicio(int nivelGasolinaInicio) {
        this.nivelGasolinaInicio = nivelGasolinaInicio;
    }

    public int getNivelGasolinaFin() {
        return nivelGasolinaFin;
    }

    public void setNivelGasolinaFin(int nivelGasolinaFin) {
        this.nivelGasolinaFin = nivelGasolinaFin;
    }
}
