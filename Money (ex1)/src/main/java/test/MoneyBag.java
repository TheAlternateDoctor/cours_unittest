package test;

import java.util.ArrayList;
import java.util.Map;


public class MoneyBag {
    private ArrayList<Money> moneyArray = new ArrayList<Money>();
    private final Map<String,Double> conversionTable = Map.of("USD",1.22,"CHF",1.08,"GBP",0.9,"EUR",1.0);
    
    public MoneyBag(ArrayList<Money> mList){
        moneyArray.addAll(mList);
    }
    public MoneyBag(MoneyBag mb){
        for(Money money:mb.getAll()){
            moneyArray.add(money);
        }
    }
    public MoneyBag(){}
    public MoneyBag(Money m){
        moneyArray.add(m);
    }

    public void add(Money m){
        moneyArray.add(m);
    }

    public void subb(MoneyBag mb){
        for(Money money:mb.getAll()){
            moneyArray.remove(money);
        }
    }

    public Money get(int index){
        return moneyArray.get(index);
    }
    public ArrayList<Money> getAll(){
        return moneyArray;
    }

    public void normalize(String currency){
        double amount = 0.0;
        for(int i=0;i<moneyArray.size();i++){
            switch(moneyArray.get(i).currency()){
                case "EUR":
                    amount = (double)moneyArray.get(i).amount();
                    break;
                case "USD":
                    amount = (double)moneyArray.get(i).amount()/1.22;
                    break;
                case "CHF":
                    amount = (double)moneyArray.get(i).amount()/1.08;
                    break;
                case "GBP":
                    amount = (double)moneyArray.get(i).amount()/0.90;
                    break;
            }
            moneyArray.set(i, new Money((int)(amount * conversionTable.get(currency)),currency));
        }

    }

    public boolean equals(MoneyBag mb){
        MoneyBag temp1 = new MoneyBag(this);
        MoneyBag temp2 = new MoneyBag(mb);
        temp1.normalize("EUR");
        temp2.normalize("EUR");
            if(temp1.getAll().equals(temp2.getAll()))
                return true;
            else
                return false;
    }
}
