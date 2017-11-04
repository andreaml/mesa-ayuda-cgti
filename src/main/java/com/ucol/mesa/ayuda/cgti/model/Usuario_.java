/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.mesa.ayuda.cgti.model;

/**
 *
 * @author andreaml
 */
public class Usuario_ {
    private String usuario;
    private String contrasenia;
    
    public Usuario_(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
}
