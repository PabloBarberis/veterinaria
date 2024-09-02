
package com.todocode.veterinaria.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascotaDuenoDTO {
    
    private String nombreMascota;
    private String especie;
    private String raza;
    private String nombreDueno;
    private String apellidoDueno;

    public MascotaDuenoDTO() {
    }

    
    
    public MascotaDuenoDTO(String nombreMascota, String especie, String raza, String nombreDueno, String apellidoDueno) {
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.nombreDueno = nombreDueno;
        this.apellidoDueno = apellidoDueno;
    }

    
    
}
