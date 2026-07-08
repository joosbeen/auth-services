package com.company.autenticacion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contraseña;

    @NotBlank(message = "La confirmación de contraseña es obligatoria")
    private String contraseña_confirm;

    public RegisterRequest() {
    }

    public RegisterRequest(String nombre, String correo, String contraseña, String contraseña_confirm) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.contraseña_confirm = contraseña_confirm;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseña_confirm() {
        return contraseña_confirm;
    }

    public void setContraseña_confirm(String contraseña_confirm) {
        this.contraseña_confirm = contraseña_confirm;
    }
}
