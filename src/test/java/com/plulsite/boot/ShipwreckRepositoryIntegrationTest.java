package com.plulsite.boot;

import com.plulsite.boot.model.Shipwreck;
import com.plulsite.boot.repository.ShipwreckRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BootApplication.class)
public class ShipwreckRepositoryIntegrationTest {

    @Autowired
    private ShipwreckRepository sr;

    @Test
    public void testFindAll(){
        List<Shipwreck> shipwrecks = sr.findAll();
        assertThat(shipwrecks.size(),is(greaterThanOrEqualTo(0)));
    }
}
