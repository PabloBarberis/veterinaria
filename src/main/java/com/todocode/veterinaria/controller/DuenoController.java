package com.todocode.veterinaria.controller;

import com.todocode.veterinaria.model.Dueno;
import com.todocode.veterinaria.model.Mascota;
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
@RequestMapping("/dueno")
public class DuenoController {

    @Autowired
    public DuenoService duenoServ;

    @Autowired
    public MascotaService mascoServ;

    @GetMapping("/traer")
    public List<Dueno> traerDueno() {
        return duenoServ.getDueno();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearDueno(@RequestBody Dueno dueno) {
        duenoServ.saveDueno(dueno);
        return new ResponseEntity<>("Se creo correctamente el dueño", HttpStatus.OK);
    }
    
    @PostMapping("/llenar")
    public ResponseEntity<String> llenarMascota(@RequestBody List<Dueno> listaDuenos) {
        
        for (Dueno dueno : listaDuenos) {
            duenoServ.saveDueno(dueno);
        }
        
        return new ResponseEntity<>("Se creo correctamente la lista", HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteDueno(Long id) {

        Dueno dueno = duenoServ.findDueno(id);
        List<Mascota> listaMascota = mascoServ.findByDuenoId(id);

        if (dueno == null) {
            return new ResponseEntity<>("No se encontro el dueño", HttpStatus.NOT_FOUND);
        }

        for (Mascota mascota : listaMascota) {
            mascota.setDueno(null);
            mascoServ.saveMascota(mascota);
        }

        duenoServ.deleteDueno(id);

        return new ResponseEntity<>("Se elimino el dueño", HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public Dueno editarDueno(@PathVariable Long id, @RequestBody Dueno dueno) {
        return duenoServ.editDueno(id, dueno);
    }
}
