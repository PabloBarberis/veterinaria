/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todocode.veterinaria.repository;

import com.todocode.veterinaria.model.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */
@Repository
public interface IMascotaRepository  extends JpaRepository<Mascota, Long>{
    
    List<Mascota> findByDuenoId(Long duenoID);
    
    List<Mascota> findByEspecieAndRaza(String especie, String raza);
}
