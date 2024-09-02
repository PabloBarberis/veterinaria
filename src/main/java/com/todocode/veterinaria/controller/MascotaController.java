package com.todocode.veterinaria.controller;

import com.todocode.veterinaria.model.Dueno;
import com.todocode.veterinaria.model.Mascota;
import com.todocode.veterinaria.model.MascotaDuenoDTO;
import com.todocode.veterinaria.services.DuenoService;
import com.todocode.veterinaria.services.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    public DuenoService duenoServ;

    @Autowired
    public MascotaService mascoServ;
    

    @GetMapping("/traer")
    public List<Mascota> traerMascotas() {
        return mascoServ.getMascotas();
    }

    @GetMapping("/traerdatos/{id}")
    public MascotaDuenoDTO traerDatos(@PathVariable Long id) {

        return mascoServ.mostrarDatos(id);
    }

    @GetMapping("/perros/caniche")
    public ResponseEntity<List<Mascota>> getPerrosCaniche() {
        List<Mascota> listaMascota = mascoServ.findPerrosCaniche();

        if (mascoServ.findPerrosCaniche().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaMascota, HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearMascota(@RequestBody Mascota mascota) {
        mascoServ.saveMascota(mascota);
        return new ResponseEntity<>("Se creo correctamente la mascota", HttpStatus.OK);
    }
    
    @PostMapping("/llenar")
    public ResponseEntity<String> llenarMascota(@RequestBody List<Mascota> listaMascotas) {
        
        for (Mascota Mascota : listaMascotas) {
            mascoServ.saveMascota(Mascota);
        }
        
        return new ResponseEntity<>("Se creo correctamente la lista", HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deletemascota(Long id) {

        Mascota mascota = mascoServ.findMascota(id);
//        List<Mascota> listaMascota = mascoServ.findByDuenoId(id);

        if (mascota == null) {
            return new ResponseEntity<>("No se encontro la mascota", HttpStatus.NOT_FOUND);
        }
//
//        for (Mascota mascota : listaMascota) {
//            mascota.setDueno(null);
//            mascoServ.saveMascota(mascota);
//        }

//        duenoServ.deleteDueno(id);
        mascoServ.deleteMascota(id);
        return new ResponseEntity<>("Se elimino la mascota", HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public Mascota editarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascoServ.editMascota(id, mascota);

    }

}
