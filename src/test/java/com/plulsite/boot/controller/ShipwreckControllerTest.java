package com.plulsite.boot.controller;

import com.plulsite.boot.model.Shipwreck;
import com.plulsite.boot.repository.ShipwreckRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository sr;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void list() {
    }

    @Test
    void create() {
    }

    @Test
    void get() {
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);

        when(sr.findById(1L)).thenReturn(java.util.Optional.of(shipwreck));

        Optional<Shipwreck> shipwreck1 = sc.get(1L);

        assertEquals(1L,shipwreck1.get().getId().longValue());

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}