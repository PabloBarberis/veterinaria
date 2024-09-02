/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todocode.veterinaria.services;

import com.todocode.veterinaria.model.Dueno;

import java.util.List;

/**
 *
 * @author pablo
 */
public interface IDuenoService {
    
    public List<Dueno> getDueno();

    public void saveDueno(Dueno dueno);

    public void deleteDueno(Long id);

    public Dueno findDueno(Long id);

    public Dueno editDueno(Long id, Dueno dueno);

}
