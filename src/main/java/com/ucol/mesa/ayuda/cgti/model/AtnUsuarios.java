package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */
public class AtnUsuarios extends UsuarioGeneral {
    private int dependencia;
    private int numTrabajador;
    private String contrasenia;
  
    public AtnUsuarios(){
        super();
    }
    
    public AtnUsuarios(String correo, String nombre1, String nombre2, String apellidoP, String apellidoM, int dependencia, int numTrabajador, String contrasenia){
        super(correo, nombre1, nombre2, apellidoP, apellidoM);
        this.dependencia=dependencia;
        this.numTrabajador=numTrabajador;
        this.contrasenia=contrasenia;
    }
      
    public int getDependencia() {
        return dependencia;
    }

    public void setDependencia(int dependencia) {
        this.dependencia = dependencia;
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
}
