package com.todocode.veterinaria.services;

import com.todocode.veterinaria.model.Dueno;
import com.todocode.veterinaria.repository.IDuenoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenoService implements IDuenoService {

    @Autowired
    public IDuenoRepository duenoRepo;

    @Override
    public List<Dueno> getDueno() {
        return duenoRepo.findAll();
    }

    @Override
    public void saveDueno(Dueno dueno) {
        duenoRepo.save(dueno);
        
    }

    @Override
    public void deleteDueno(Long id) {
        duenoRepo.deleteById(id);
        
    }

    @Override
    public Dueno findDueno(Long id) {
        Dueno duenoEncontrado = duenoRepo.findById(id).orElse(null);
        return duenoEncontrado;
    }

    @Override
    public Dueno editDueno(Long id, Dueno dueno) {

        Dueno duenoEdit = this.findDueno(id);

        if (duenoEdit != null) {
            if (dueno.getDni() != null) {
                duenoEdit.setDni(dueno.getDni());
            }
            if (dueno.getNombre() != null) {
                duenoEdit.setNombre(dueno.getNombre());
            }
            if (dueno.getApellido() != null) {
                duenoEdit.setApellido(dueno.getApellido());
            }
            if (dueno.getCelular() != null) {
                duenoEdit.setCelular(dueno.getCelular());
            }

            duenoRepo.save(duenoEdit);

        }
        return duenoEdit;
    }
}
