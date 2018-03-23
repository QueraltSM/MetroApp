package metroapp;
import java.util.*;
public class Repository {
    public static ArrayList<Line> lines = new ArrayList<Line>();
    public static ArrayList<Station> stations = new ArrayList<Station>();
    public static ArrayList<User> users = new ArrayList<User>();
   


    public void addStationToRepository(Station s){
        stations.add(s);
    }

    public void addLineToRepository(Line l){
        lines.add(l);
    }


    public void addUserToRepository(User u){
        users.add(u);
    }



    public void removeStationToRepository(Station s){
        Iterator iter = stations.iterator();
        while (iter.hasNext()) {
            if (((Station)iter.next()).getCode() == s.getCode()) {
                stations.remove(s);
            }
        }
    }


    public void removeLineToRepository(Line l){
        Iterator iter = lines.iterator();
        while (iter.hasNext()) {
            if (((Line)iter.next()).getNLine() == l.getNLine()) {
                lines.remove(l);
            }
        }
    }


    public void removeUserToRepository(User u){
        Iterator iter = users.iterator();
        while (iter.hasNext()) {
            if (((User)iter.next()).getDNI().equals(u.getDNI())) {
                users.remove(u);
            }
        }
    }

    public ArrayList<User> getUsers(){
        return users;
    }


    public ArrayList<Line> getLines(){
        return lines;
    }

    public ArrayList<Station> getStations(){
        return stations;
    }


    // CU 6: CHECK RATES
    public String showRates(){
        return "\n              Trip with credit costs 0.60€ per station.\n\n"
                + "           Trip with no credit costs 0.80€ per station.";
    }



}