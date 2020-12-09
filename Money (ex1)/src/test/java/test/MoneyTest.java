package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
public class MoneyTest {
    @Test
    @DisplayName("test positif")
    public void positive(){
        Money money = new Money(-15,"EUR");
        assertEquals(0, money.amount(),"Amount negative");
        money = new Money(15,"EUR");
        assertEquals(15,money.amount(),"Not the right amount (may be 0)");
    }

    @Test
    @DisplayName("test currency")
    public void currencyNames(){
        Money money = new Money(0,"CAD");
        assertTrue(money.currency().equals("EUR"),"Unavailable currency");
        money = new Money(0,"USD");
        assertTrue(money.currency().equals("USD"),"Wrong currency (may be EUR)");
    }

    @Test
    @DisplayName("test add Money x2")
    public void addMoney(){
        Money money1 = new Money(15,"EUR");
        Money money2 = new Money(30,"EUR");
        assertEquals(45,money1.add(money2).amount(),"Not added properly.");
        money2 = new Money(30,"USD");
        assertEquals(15,money1.add(money2).amount(),"Added while different currencies.");
    }

    @Test
    @DisplayName("test add int")
    public void addInt(){
        Money money = new Money(15,"EUR");
        assertEquals(45,money.add(30,"EUR").amount(),"Not added properly");
        assertEquals(15,money.add(30,"USD").amount(),"Added while different currencies.");
    }
}
