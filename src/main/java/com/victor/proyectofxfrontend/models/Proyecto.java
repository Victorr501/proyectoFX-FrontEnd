package com.victor.proyectofxfrontend.models;

import java.time.LocalDate;

public class Proyecto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String fechaCreacion;
    private Integer idUsuario;

    public Proyecto(Integer id, String nombre, String descripcion, String fechaCreacion, Integer idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
    }

    public Proyecto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
