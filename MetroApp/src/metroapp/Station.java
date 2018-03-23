package metroapp;
import metroapp.file.MetroAppFile;
import java.util.*;
import metroapp.checkarrival.CheckArrivalGUI;

public class Station implements Comparable <Station> {
    private int code;
    private String place;
    protected static Station s;

    private Time time = CheckArrivalGUI.time;

    private static ArrayList <Line> lines =  MetroAppFile.myRepository.lines;
    private ArrayList<Line> aux = new ArrayList<Line>();

    public Station(int code, String place) {
        this.code = code;
        this.place = place;
    }


    public Station(int code){
        this.code = code;
    }


    public String getPlace(){
        return place;
    }


    public ArrayList<Line> getLinesOfStation(){
        Line line = new Line();
        Iterator iter = lines.iterator();
        while (iter.hasNext()) {
            line = (Line)iter.next();
            for (Station i : line.getStations()) {
                if (i.getPlace().equals(place)) {
                    aux.add(line);
                }
            }
        }
        return aux;
    }


    public void setTime(Time t){
        this.time = t;
    }

    public void removeTime(){
        this.time = null;
    }


    // CU 3 : CHECK ARRIVALS
    public String getTime(){
        String result = "";
                for (Line j : getLinesOfStation()) {
                    if (time.getLine().equals(j)) {
                        result += time.stationTimetable() + "\n";
                        break;
                    }
                }
            
        
        return result;
    }

    public int getCode(){
        return code;
    }



    @Override
    public int compareTo(Station s){
        if ((s.getPlace().compareTo(place)) < 0) {
            return 1;
        } else if ((s.getPlace().compareTo(place)) > 0) {
            return -1;
        }
        return 0;

    }



    @Override
    public String toString(){
        return "                   " + place;
    }

}
