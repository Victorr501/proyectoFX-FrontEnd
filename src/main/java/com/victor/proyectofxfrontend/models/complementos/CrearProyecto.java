package com.victor.proyectofxfrontend.models.complementos;

import com.victor.proyectofxfrontend.models.Proyecto;

public class CrearProyecto {
    private Proyecto proyectoDTO;
    private Integer id_usuario;

    public CrearProyecto(Proyecto proyectoDTO, Integer id_usuario) {
        this.proyectoDTO = proyectoDTO;
        this.id_usuario = id_usuario;
    }

    public CrearProyecto() {
    }

    public Proyecto getProyectoDTO() {
        return proyectoDTO;
    }

    public void setProyectoDTO(Proyecto proyectoDTO) {
        this.proyectoDTO = proyectoDTO;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
