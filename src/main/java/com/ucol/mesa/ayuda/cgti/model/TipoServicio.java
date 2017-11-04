package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class TipoServicio {
    private int id_tipo_servicio;
    private String nombreTipoServicio;
    private int area;

    public TipoServicio(int id_tipo_servicio, String nombreTipoServicio, int area){
        this.id_tipo_servicio=id_tipo_servicio;
        this.nombreTipoServicio=nombreTipoServicio;
        this.area=area;
    }
   
    public int getId_tipo_servicio() {
        return id_tipo_servicio;
    }

    public void setId_tipo_servicio(int id_tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
    }

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
