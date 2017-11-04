package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class Especialista extends UsuarioGeneral{
    private int area;
    private int numTrabajador;
    private String contrasenia;
    private String profesion;
    
    public Especialista(){
        super();
    }
    
    public Especialista(String correo, String nombre1, String nombre2, String apellidoP, String apellidoM, int area, int numTrabajador, String contrasenia, String profesion){
        super(correo, nombre1, nombre2, apellidoP, apellidoM);
        this.area=area;
        this.numTrabajador=numTrabajador;
        this.contrasenia=contrasenia;
        this.profesion=profesion;
    }
    
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumTrabajador() {
        return numTrabajador;
    }

    public void setNumTrabajador(int numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
