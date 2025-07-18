package com.victor.proyectofxfrontend.models.complementos;

public class Login {
    private String correo;
    private String contrasena;

    public Login(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Login(){}
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
