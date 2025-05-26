package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Vanesa"));
        assertFalse(svatky.jeVSeznamu("Veronika"));

    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        assertEquals(37,svatky.getPocetJmen());
        assertNotEquals(40,svatky.getPocetJmen());

    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        Set<String> seznamJmen = svatky.getSeznamJmen(); //vypise mi seznam 37 jmen
        assertEquals(37,seznamJmen.size()); //otestuje, jestli je opravdu 37 jmen v seznamu

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
    svatky.pridejSvatek("Veronika", MonthDay.of(2, 7));
    assertTrue(svatky.jeVSeznamu("Veronika"));
    assertEquals(svatky.vratKdyMaSvatek("Veronika"),MonthDay.of(2, 7));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Radek", MonthDay.of(3, 21));
        assertTrue(svatky.jeVSeznamu("Radek"));
        assertEquals(svatky.vratKdyMaSvatek("Radek"),MonthDay.of(3, 21));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Ema", MonthDay.of(4, 8));
        assertTrue(svatky.jeVSeznamu("Ema"));
        assertEquals(svatky.vratKdyMaSvatek("Ema"),MonthDay.of(4, 8));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        svatky.smazSvatek("Kamila");
        assertFalse(svatky.jeVSeznamu("Kamila"));
        Set<String> seznamJmen = svatky.getSeznamJmen();
        assertEquals(36,seznamJmen.size());
    }
}
