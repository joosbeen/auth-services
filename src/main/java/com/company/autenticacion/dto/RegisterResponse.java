package com.company.autenticacion.dto;

import java.time.LocalDateTime;

public class RegisterResponse {

    private String message;
    private String nombre;
    private String correo;
    private Boolean estatus;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualizacion;

    public RegisterResponse() {
    }

    public RegisterResponse(String message, String nombre, String correo, Boolean estatus, LocalDateTime fechaRegistro, LocalDateTime fechaActualizacion) {
        this.message = message;
        this.nombre = nombre;
        this.correo = correo;
        this.estatus = estatus;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
