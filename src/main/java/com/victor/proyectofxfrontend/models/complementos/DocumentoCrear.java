package com.victor.proyectofxfrontend.models.complementos;

import com.victor.proyectofxfrontend.models.Documento;

public class DocumentoCrear {
    private Documento documento;

    private Integer id_proyecto;

    public DocumentoCrear() {
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Integer getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
}
