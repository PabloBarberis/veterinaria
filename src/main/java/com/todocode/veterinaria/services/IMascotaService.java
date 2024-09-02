/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todocode.veterinaria.services;


import com.todocode.veterinaria.model.Mascota;
import com.todocode.veterinaria.model.MascotaDuenoDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author pablo
 */

public interface IMascotaService {

    public List<Mascota> getMascotas();

    public  ResponseEntity<String>  saveMascota(Mascota mascota);

    public  ResponseEntity<String>  deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public Mascota editMascota(Long id, Mascota mascota);
    
    public MascotaDuenoDTO mostrarDatos (Long id);
    
    public List<Mascota> findByDuenoId(Long duenoID);
    
    public List<Mascota> findPerrosCaniche();

}
