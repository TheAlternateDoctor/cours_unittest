package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class MoneyBagTest {
    @Test
    @DisplayName("Normalized Result")
    public void normalized(){
        Money m = new Money(15,"EUR");
        MoneyBag mb = new MoneyBag(m);
        mb.normalize("EUR");
        assertEquals(15, mb.get(0).amount(), "Normalized value not equal (EUR -> EUR)");
        m = new Money(15,"USD");
        mb = new MoneyBag(m);
        mb.normalize("EUR");
        assertEquals(12, mb.get(0).amount(), "Normalized value not equal (USD -> EUR)");
        m = new Money(15,"CHF");
        mb = new MoneyBag(m);
        mb.normalize("EUR");
        assertEquals(13, mb.get(0).amount(), "Normalized value not equal (CHF -> EUR)");
        m = new Money(15,"GBP");
        mb = new MoneyBag(m);
        mb.normalize("EUR");
        assertEquals(16, mb.get(0).amount(), "Normalized value not equal (GBP -> EUR)");
    }

    
}
