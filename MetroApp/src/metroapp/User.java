package metroapp;
import java.text.NumberFormat;
import java.util.ArrayList;

public class User implements Comparable<User>{
    private String name, lastName, DNI = "";
    private Card card;
    private double price;
    private int choice;
    private static ArrayList <Station> stations =  Repository.stations;
    private static ArrayList  <Line> lines =  Repository.lines;
    private static ArrayList  <User> users =   Repository.users;
    private int totalOfStations = 0;

    private Line l;
    private int c1, c2;



    public User(Card card, String name, String lastName, String DNI) {
        this.card = card;
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
    }
    
     public User(String name, String lastName, String DNI) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
    }


    public User(Card card, String DNI){
        this.card = card;
        this.DNI = DNI;
    }
    
    public User(String DNI){
        this.DNI = DNI;
    }
    public User(){}


    public Card getUserCard(){
        return card;
    }
  
    public String getPrice(Line l, int c1, int c2, int choice){
        this.choice = choice;
        int count = 1;
        this.l = l;
        for (int i = 0; i< l.getStations().size(); i++) {
            for (int j = i+1; j < l.getStations().size(); j++) {
                if (l.getStations().get(i).getCode() == c1) {
                    count++;
                    this.c1 = c1;
                }

                if (l.getStations().get(i).getCode() == c1 &&
                        l.getStations().get(j).getCode() == c2) {
                    this.c2 = c2;
                    totalOfStations = count;
                    break;
                }
            }
        }
        totalOfStations--;
        if (choice == 0) {
            this.price =  totalOfStations*0.80;
        } else {
            this.price = totalOfStations*0.60;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "\n\n               Trip costs: " + 
                formatter.format(price).substring(2) + " €";
    }
    
    public double getCost(Line l, int c1, int c2, int choice){
        return price;
    }
    
    public void chargeTicket(double cost){
        card.chargeMoney(cost);
    }

    public String getDNI() {
        return this.DNI;
    }

    public int getNCard(){
        return card.getNumber();
    }

    public boolean equals(User u){
        return u.getDNI().equals(DNI);
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }


    // CU 5: CHECK BALANCE
    public String getMoneyCard(){
        for (User i : users) {
            if (i.getNCard() == getNCard() && i.getDNI().equals(DNI)) {
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                return "\n\n             "
                        + "          "
                        + "    "+ i.getName() + " " + i.getLastName() 
                        + " has" 
                        + formatter.format(card.getMoney()).substring(1) + "€";
            }
        }
        return "";
    }

   
    public boolean buyTicket(){
        if (card.getMoney()>=price) {
            card.setMoney(card.getMoney() - price);
            return true;
        }
        return false;
    }

   
    public String resume() {
        for (User i : users) {
            if (i.getDNI().equals(DNI)) {
                if (buyTicket()) return "\n\n\n                  "
                + "            Buy was succesful.\n";
        return "\n\n\n                    There was an error. Not enough money. \n";
   
            }
            
        }
        return "\n\n\n                    No person matches";
        
        }


    // CU 8 : Print Ticket
    public String printTicket(Line l, int c1, int c2, double cost){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String result = "";
        String A = "";
        String B = "";
        for (Station s : stations) {
            if (s.getCode() == c1) {
                A = s.getPlace();
            }
            if (s.getCode() == c2) {
                B = s.getPlace();
            }
        }
        
        for (User u : users) {
            if (u.getDNI().equals(DNI) && buyTicket()) {
                result += "\n   Passenger: " + getName() + " " + getLastName() + "\n\n";
                result += "   Line : " + l.getNLine() + "\n\n";
                result += "   From: " + A +  "    To: " + B + "\n\n";
                result += "   Cost: " + formatter.format(cost).substring(1) + "€" + "\n";
                return result;
            }
        }
        return "\n\n\n\n                   Results are invalid. Try again.";
    }


    @Override
    public String toString(){
        return lastName + " " + name;
    }


    
    @Override
    public int compareTo(User u){
        if (u.getLastName().compareTo(lastName)<0) {
            return 1;
        } else if (u.getLastName().compareTo(lastName)>0) {
            return -1;
        }
        return 0;
    }
}