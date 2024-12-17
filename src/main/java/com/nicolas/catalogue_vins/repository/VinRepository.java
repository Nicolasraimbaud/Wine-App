package com.nicolas.catalogue_vins.repository;

import com.nicolas.catalogue_vins.entity.Vin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinRepository extends JpaRepository<Vin, Long> {
}
