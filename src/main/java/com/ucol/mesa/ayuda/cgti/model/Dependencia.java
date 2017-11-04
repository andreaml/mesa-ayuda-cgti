package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class Dependencia {
    private int id_dependencia;
    private String calle;
    private String campus;
    private String nombreDependencia;
    private int numero;
    private String colonia;
    private int codPostal;
    private String ciudad;

    public Dependencia(int id_dependencia, String calle, String campus, String nombreDependencia, int numero, String colonia, int codPostal, String ciudad){
        this.id_dependencia=id_dependencia;
        this.calle= calle;
        this.campus=campus;
        this.nombreDependencia= nombreDependencia;
        this.numero= numero;
        this.colonia= colonia;
        this.codPostal=codPostal;
        this.ciudad=ciudad;
    }
    
    public int getId_dependencia() {
        return id_dependencia;
    }

    public void setId_dependencia(int id_dependencia) {
        this.id_dependencia = id_dependencia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getNombreDependencia() {
        return nombreDependencia;
    }

    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }    
    
}
