package com.plulsite.boot.repository;

import com.plulsite.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipwreckRepository extends JpaRepository<Shipwreck,Long> {
}
