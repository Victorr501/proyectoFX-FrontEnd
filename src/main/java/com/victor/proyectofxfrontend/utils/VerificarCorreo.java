package com.victor.proyectofxfrontend.utils;

import jakarta.mail.internet.InternetAddress;

public class VerificarCorreo {
    public  static boolean esCorrectoValido(String correo){
        try {
            InternetAddress emailAddr = new InternetAddress(correo);
            emailAddr.validate();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
