package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValideringTest {

    @Test
    public void testGyldigFornavn() {
        assertTrue(Validering.validerFornavn("Anne"));
        assertTrue(Validering.validerFornavn("Lars-Petter"));
        assertTrue(Validering.validerFornavn("Anne Marie"));
    }
    
    @Test
    public void testUgyldigFornavn() {
        assertFalse(Validering.validerFornavn("anne")); // Må starte med stor bokstav
        assertFalse(Validering.validerFornavn("A")); // For kort
        assertFalse(Validering.validerFornavn("AbcdefghijklmnopqrstuvwxyZ")); // For langt (>20)
        assertFalse(Validering.validerFornavn("")); // Tom streng
        assertFalse(Validering.validerFornavn(null)); // Null
    }
    
    @Test
    public void testGyldigEtternavn() {
        assertTrue(Validering.validerEtternavn("Hansen"));
        assertTrue(Validering.validerEtternavn("Monsen-Hagen"));
    }
    
    @Test
    public void testUgyldigEtternavn() {
        assertFalse(Validering.validerEtternavn("hansen")); // Må starte med stor bokstav
        assertFalse(Validering.validerEtternavn("Hansen Larsen")); // Mellomrom ikke tillatt
        assertFalse(Validering.validerEtternavn("H")); // For kort
        assertFalse(Validering.validerEtternavn("")); // Tom streng
    }
    
    @Test
    public void testGyldigMobil() {
        assertTrue(Validering.validerMobil("12345678"));
        assertTrue(Validering.validerMobil("98765432"));
    }
    
    @Test
    public void testUgyldigMobil() {
        assertFalse(Validering.validerMobil("1234567")); // 7 siffer
        assertFalse(Validering.validerMobil("123456789")); // 9 siffer
        assertFalse(Validering.validerMobil("1234567a")); // Bokstav
        assertFalse(Validering.validerMobil("12 345 678")); // Mellomrom
        assertFalse(Validering.validerMobil("")); // Tom streng
    }
    
    @Test
    public void testGyldigPassord() {
        assertTrue(Validering.validerPassord("passord123"));
        assertTrue(Validering.validerPassord("12345678"));
    }
    
    @Test
    public void testUgyldigPassord() {
        assertFalse(Validering.validerPassord("pass")); // For kort (<8)
        assertFalse(Validering.validerPassord("")); // Tom streng
        assertFalse(Validering.validerPassord(null)); // Null
    }
    
    @Test
    public void testPassordRepetert() {
        assertTrue(Validering.validerPassordRepetert("passord123", "passord123"));
        assertFalse(Validering.validerPassordRepetert("passord123", "passord456"));
        assertFalse(Validering.validerPassordRepetert("passord", null));
    }
    
    @Test
    public void testGyldigKjonn() {
        assertTrue(Validering.validerKjonn("mann"));
        assertTrue(Validering.validerKjonn("kvinne"));
    }
    
    @Test
    public void testUgyldigKjonn() {
        assertFalse(Validering.validerKjonn("Mann")); // Stor M
        assertFalse(Validering.validerKjonn("gutt"));
        assertFalse(Validering.validerKjonn(""));
        assertFalse(Validering.validerKjonn(null));
    }
    
    @Test
    public void testValiderAlt() {
        // Gyldig input
        assertTrue(Validering.validerAlt(
                "Anne", "Hansen", "12345678", "passord123", "passord123", "kvinne"));
        
        // Ugyldig fornavn
        assertFalse(Validering.validerAlt(
                "anne", "Hansen", "12345678", "passord123", "passord123", "kvinne"));
        
        // Ugyldig mobil
        assertFalse(Validering.validerAlt(
                "Anne", "Hansen", "123", "passord123", "passord123", "kvinne"));
        
        // Passord matcher ikke
        assertFalse(Validering.validerAlt(
                "Anne", "Hansen", "12345678", "passord123", "passord456", "kvinne"));
    }
}
