package test;

import java.util.Arrays;
import java.util.List;

public class Money {
    private int fAmount;
    private String fCurrency;
    private List<String> currencies = Arrays
            .asList(new String[] { "EUR", "USD", "CHF", "GBP" });
    public Money(int amount, String currency){
        if(amount>=0)
            fAmount = amount;
        else
            fAmount = 0;
        if(currencies.contains(currency))
            fCurrency = currency;
        else
            fCurrency = "EUR";
    }
    public int amount(){
        return fAmount;
    }
    public String currency(){
        return fCurrency;
    }
    public Money add(Money m){
        int result = fAmount;
        if(fCurrency.equals(m.currency()))
            result +=m.amount();
        return new Money(result,fCurrency);
    }
    public Money add(int namount, String ncurrency){
        int result = fAmount;
        if(fCurrency.equals(ncurrency))
            result +=namount;
        return new Money(result,fCurrency);
    }
}
