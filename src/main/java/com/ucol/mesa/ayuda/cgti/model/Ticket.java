package com.ucol.mesa.ayuda.cgti.model;

/**
 * @author 20126225
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private int id_ticket;
    private String titulo;
    private String descripcion;
    private int tipoServicio;
    private String emisor;
    private String especialista;
    private LocalDate fecha;
    private LocalTime hora;
    private int servicio;
    private String comentarios;
    private int estadoSatisfaccion;
    private int estadoTicket;
    
    public Ticket(String titulo, String descripcion, int tipoServicio,
            String emisor, LocalDate fecha, LocalTime hora, int estadoTicket){
        this.titulo= titulo;
        this.descripcion= descripcion;
        this.tipoServicio= tipoServicio;
        this.emisor= emisor;
        this.fecha= fecha;
        this.hora= hora;
        this.estadoTicket= estadoTicket;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getEstadoSatisfaccion() {
        return estadoSatisfaccion;
    }

    public void setEstadoSatisfaccion(int estadoSatisfaccion) {
        this.estadoSatisfaccion = estadoSatisfaccion;
    }

    public int getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(int estadoTicket) {
        this.estadoTicket = estadoTicket;
    }
}
