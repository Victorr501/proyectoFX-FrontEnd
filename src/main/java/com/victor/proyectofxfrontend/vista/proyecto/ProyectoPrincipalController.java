package com.victor.proyectofxfrontend.vista.proyecto;

import com.victor.proyectofxfrontend.models.Proyecto;
import com.victor.proyectofxfrontend.services.ProyectoServices;

public class ProyectoPrincipalController {
    //id proyecto
    private Integer id;

    //id de usuario
    private Integer idUsuario;
    private Proyecto proyecto;
    private ProyectoServices proyectoServices = new ProyectoServices();

    public void setId(Integer id) throws Exception {
        this.id = id;
        proyecto = proyectoServices.getProyecto(id);
        idUsuario = proyecto.getIdUsuario();
    }
}
