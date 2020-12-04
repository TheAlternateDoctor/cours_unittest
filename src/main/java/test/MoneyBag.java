package test;

import java.util.ArrayList;
import org.decimal4j.util.DoubleRounder;

public class MoneyBag {
    private ArrayList<Money> moneyArray = new ArrayList<Money>();
    /*
        Conversion
        1 EUR=1.22 USD
        1 EUR=0.90 GBP
        1 EUR=1.08 CHF
    */
    
    public MoneyBag(ArrayList<Money> mList){
        moneyArray.addAll(mList);
    }
    public MoneyBag(){}
    public MoneyBag(Money m){
        moneyArray.add(m);
    }

    public void add(Money m){
        moneyArray.add(m);
    }

    public Money get(int index){
        return moneyArray.get(index);
    }

    public double getNormalized(String currency){
        double amount = 0.0;
        for(Money money:moneyArray){
            switch(money.currency()){
                case "EUR":
                    amount += (double)money.amount();
                    break;
                case "USD":
                    amount += (double)money.amount()*1.22;
                    break;
                case "CHF":
                    amount += (double)money.amount()*1.08;
                    break;
                case "GBP":
                    amount += (double)money.amount()*0.90;
                    break;
            }
        }
        switch(currency){
            case "USD":
                amount *= 1.22;
                break;
            case "CHF":
                amount *= 1.08;
                break;
            case "GBP":
                amount *= 0.90;
                break;
        }
        return DoubleRounder.round(amount,2);
    }

    public boolean equals(MoneyBag mb){
        if(mb.getNormalized("EUR")==this.getNormalized("EUR"))
            return true;
        return false;
    }
}
