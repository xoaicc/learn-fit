package Tut12;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoaTest {
    private Boa jen;
    private Boa ken;

    @BeforeEach
    void setUp() {
        jen = new Boa("Jennifer", 2, "grapes");
        ken = new Boa("Kenneth", 3, "granola bars");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isHealthy() {
        System.out.println("jen is healthy? " + jen.isHealthy());
        System.out.println("ken is healthy? " + ken.isHealthy());
    }

    @Test
    void fitsInCage() {
        System.out.println("jen is fits in cage? " + jen.fitsInCage(3));
        System.out.println("ken is fits in cage? " + ken.fitsInCage(2));
    }

    @Test
    void lengthInInches() {
        System.out.println("jen's length (inches): " + jen.lengthInInches());
        System.out.println("ken's length (inches): " + ken.lengthInInches());
    }
}