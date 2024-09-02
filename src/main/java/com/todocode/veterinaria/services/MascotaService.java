package com.todocode.veterinaria.services;


import com.todocode.veterinaria.model.Mascota;
import com.todocode.veterinaria.model.MascotaDuenoDTO;
import com.todocode.veterinaria.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    public IMascotaRepository mascoRepo;

    @Override
    public List<Mascota> getMascotas() {
        return mascoRepo.findAll();
    }

    @Override
    public ResponseEntity<String> saveMascota(Mascota mascota) {
        
        if (mascota == null) {
            return new ResponseEntity<>("la mascota no puede ser nula, guachin", HttpStatus.BAD_REQUEST);
        }
        
        mascoRepo.save(mascota);
        return new ResponseEntity<>("Se guardo correctamente la mascota", HttpStatus.OK);
    }

    @Override
    public  ResponseEntity<String>  deleteMascota(Long id) {
        mascoRepo.deleteById(id);
        return new ResponseEntity<>("Se guardo correctamente la mascota", HttpStatus.OK);
    }

    @Override
    public Mascota findMascota(Long id) {
        return mascoRepo.findById(id).orElse(null);
    }

    @Override
    public Mascota editMascota(Long id, Mascota mascota) {

        Mascota mascoEdit = this.findMascota(id);

        if (mascoEdit != null) {
            if (mascota.getNombre() != null) {
                mascoEdit.setNombre(mascota.getNombre());
            }
            if (mascota.getEspecie() != null) {
                mascoEdit.setEspecie(mascota.getEspecie());
            }
            if (mascota.getRaza() != null) {
                mascoEdit.setRaza(mascota.getRaza());
            }
            if (mascota.getColor() != null) {
                mascoEdit.setColor(mascota.getColor());
            }
            if (mascota.getDueno() != null) {
                //si tiene dueño, primero lo seteo como null, guardo, y despues
                //le seteo el nuevo dueño recibido
                if (mascoEdit.getDueno() !=null) {
                    mascoEdit.setDueno(null);
                    mascoRepo.save(mascoEdit);
                    mascoEdit.setDueno(mascota.getDueno());
                }
                
            }
            //guardo todo
            mascoRepo.save(mascoEdit);

        }
        return mascoEdit;
    }

    @Override
    public MascotaDuenoDTO mostrarDatos(Long id) {
        Mascota masco = mascoRepo.findById(id).orElse(null);
        
        return new MascotaDuenoDTO(masco.getNombre(), masco.getEspecie(),
                masco.getRaza(), masco.getDueno().getNombre(), masco.getDueno().getApellido());
    }

    @Override
    public List<Mascota> findByDuenoId(Long duenoID) {
        return mascoRepo.findByDuenoId(duenoID);
    }

    @Override
    public List<Mascota> findPerrosCaniche() {
        return mascoRepo.findByEspecieAndRaza("perro", "caniche");
    }
}


