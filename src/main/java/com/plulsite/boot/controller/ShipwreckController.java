package com.plulsite.boot.controller;

import com.plulsite.boot.model.Shipwreck;
import com.plulsite.boot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @GetMapping("/shipwrecks")
    public List<Shipwreck> list() {
        return shipwreckRepository.findAll();
    }

    @PostMapping("/shipwrecks")
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @GetMapping("/shipwrecks/{id}")
    public Optional<Shipwreck> get(@PathVariable Long id) {
        return shipwreckRepository.findById(id);
    }

    @PutMapping("/shipwrecks/{id}")
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        Optional<Shipwreck> shipwreckOptional = shipwreckRepository.findById(id);
        BeanUtils.copyProperties(shipwreck, shipwreckOptional.get());
        return shipwreckRepository.saveAndFlush(shipwreckOptional.get());
    }

    @DeleteMapping("/shipwrecks/{id}")
    public Shipwreck delete(@PathVariable Long id) {
        Optional<Shipwreck> shipwreckOptional = shipwreckRepository.findById(id);
        shipwreckRepository.delete(shipwreckOptional.get());
        return shipwreckOptional.get();
    }

}
