package org.example.verkoop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
public class verkoopTest {

    // We zorgen met mocking dat we geen database of systeem nodig hebben om de testen te schrijven
    // We gebruiken een mock voor de Service, hier bestaat momenteel enkel een Interface voor
    @Mock
    VerkoopService verkoopService;

    @BeforeEach
    void setUp() {
        initMocks(this);

        when(verkoopService.verwerkVerkoop(eq(true), eq(true), eq(true), eq(true)))
                .thenReturn("Voorraad wordt bijgewerkt en bestelmelding wordt gestuurd & verkoop gelukt!");

        when(verkoopService.verwerkVerkoop(eq(true), eq(false), eq(false), eq(true)))
                .thenReturn("Controleer voorraad melding");

        when(verkoopService.verwerkVerkoop(eq(true), eq(false), eq(false), eq(false)))
                .thenReturn("Voorraad wordt bijgewerkt");

        when(verkoopService.verwerkVerkoop(eq(false), eq(false), eq(false), eq(false)))
                .thenReturn("Verkoop niet gelukt!");
    }
    @Test
    void ts1() {
        assertEquals("Voorraad wordt bijgewerkt en bestelmelding wordt gestuurd & verkoop gelukt!",
                verkoopService.verwerkVerkoop(true, true, true, true));
    }

    @Test
    void ts3() {
        assertEquals("Controleer voorraad melding",
                verkoopService.verwerkVerkoop(true, false,false, true));
    }

    @Test
    void ts4() {
        assertEquals("Voorraad wordt bijgewerkt",
                verkoopService.verwerkVerkoop(true, false, false, false));
    }

    @Test
    void ts16() {
        assertEquals("Verkoop niet gelukt!",
                verkoopService.verwerkVerkoop(false,false, false, false));
    }
}
