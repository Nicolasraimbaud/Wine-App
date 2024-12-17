package com.nicolas.catalogue_vins.service;

import com.nicolas.catalogue_vins.entity.Vin;
import com.nicolas.catalogue_vins.repository.VinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VinService {

    @Autowired
    private VinRepository vinRepository;

    // Méthode pour récupérer tous les vins
    public List<Vin> getAllVins() {
        return vinRepository.findAll();
    }

    public Optional<Vin> getVinById(Long id) {
        return vinRepository.findById(id); // Retourne un Optional
    }

    // Méthode pour ajouter un vin
    public Vin saveVin(Vin vin) {
        return vinRepository.save(vin);
    }

    public boolean deleteVin(Long id) {
        if (vinRepository.existsById(id)) {
            vinRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Vin> updateVin(Long id, Vin updatedVin) {
        return vinRepository.findById(id).map(vin -> {
            vin.setNom(updatedVin.getNom());
            vin.setAnnee(updatedVin.getAnnee());
            vin.setPrix(updatedVin.getPrix());
            return vinRepository.save(vin);
        });
    }
}
