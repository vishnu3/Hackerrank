package com.plulsite.boot.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void home() {
        HomeController homeController =  new HomeController();
        String s = homeController.home();
        assertEquals(s,"Vishnu !! Spring is ready for you");
    }
}