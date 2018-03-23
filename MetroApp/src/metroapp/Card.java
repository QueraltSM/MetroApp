package metroapp;

import metroapp.file.MetroAppFile;

public class Card implements Comparable<Card> {
    private int nCard;
    private double money;
    private static Repository myRepository = MetroAppFile.myRepository;

    public Card(){}

    public Card(int nCard, double money){
        this.nCard = nCard;
        this.money = money;
    }

    public Card(int nCard){
        this.nCard = nCard;
    }

    public String theCardIsOfUser(){
        for (User i : myRepository.getUsers()) {
            if (i.getNCard() == nCard) {
                return i.getName() + " " + i.getLastName();
            }
        }
        return "";

    }

    public void setMoney(double moreMoney){
        this.money += moreMoney;
    }

    public boolean chargeMoney(double lessMoney){
        if (money-lessMoney>0) {
            this.money -= lessMoney;
            return true;
        }
        return false;
    }

    public double getMoney(){
        return this.money;
    }

    public int getNumber(){
        return nCard;
    }

    @Override
    public int compareTo(Card c){
        if (nCard<c.getNumber()) {
            return -1;
        } else if (nCard>c.getNumber()) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Card c){
        return c.getNumber()==nCard;
    }
}