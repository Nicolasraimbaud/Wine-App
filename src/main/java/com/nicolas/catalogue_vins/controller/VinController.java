package com.nicolas.catalogue_vins.controller;

import com.nicolas.catalogue_vins.entity.Vin;
import com.nicolas.catalogue_vins.service.VinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vins")
public class VinController {

    @Autowired
    private VinService vinService;

    // GET: Récupérer tous les vins
    @GetMapping
    public List<Vin> getAllVins() {
        return vinService.getAllVins();
    }

    // GET: Récupérer un vin par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Vin> getVinById(@PathVariable Long id) {
        return vinService.getVinById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Ajouter un nouveau vin
    @PostMapping
    public Vin createVin(@RequestBody Vin vin) {
        return vinService.saveVin(vin);
    }

    // PUT: Mettre à jour un vin existant
    @PutMapping("/{id}")
    public ResponseEntity<Vin> updateVin(@PathVariable Long id, @RequestBody Vin updatedVin) {
        return vinService.updateVin(id, updatedVin)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Supprimer un vin par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVin(@PathVariable Long id) {
        if (vinService.deleteVin(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
