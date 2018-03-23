package metroapp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import metroapp.main.MetroApp;

public class Line implements Comparable<Line> {
    private int nLine;
    private ArrayList <Station> lineStations = new ArrayList<Station>();
    private Repository myRepository = MetroApp.myRepository;
    private ArrayList <Station> stations = myRepository.stations;
    private ArrayList<Line> lines = myRepository.lines;
    private Time t1;
    private Time t2;
    private SortedSet<Incidence> incidences = new TreeSet<Incidence>();


    public Line(int nLine, Time t1, Time t2){
        this.nLine = nLine;
        this.t1 = t1;
        this.t2 = t2;
    }
    
    public Line(int nLine){
        this.nLine = nLine;
    }

    public String route1(){
        return lineStations.get(0).getPlace() + " - " + lineStations.get(lineStations.size()-1).getPlace();
    }
    
     public String route2(){
        return lineStations.get(lineStations.size()-1).getPlace() + " - " + lineStations.get(0).getPlace();
    }

    public int getNLine(){
        return nLine;
    }
    
    public Line(){}

    public void addIncidence(Incidence i){
        incidences.add(i);
    }
    
    public void removeIncidence(Incidence i){
        incidences.remove(i);
    }
    
    // CU 9 : CHECK INCIDENCES
    public String allIncidences(){
        String result = "";
        Iterator iter = incidences.iterator();
        while (iter.hasNext()) {
            result += "\n\n             " + ((Incidence)iter.next()).toString();
        }
        if (result.equals("")) {
            return "\n\n\n\n\n"
                    + "       "
                    + "                        There is no incidence in line " +
                    nLine +".";
        }
        return result;
    }
    
    
   
    public void setTime(Time t1, Time t2){
        this.t1 = t1;
        this.t2 = t2;
    }
    
    
    public String getTime1(){
        return "\n\n                                " + route1() + "\n\n" +  t1.lineTimetable(); 
    }
    
    
    public String getTime2(){
        return "\n\n                                " + route2() + "\n\n" + t2.lineTimetable();
    }

    public void setTime1(Time t1){
        this.t1 = t1;
        
    }
    
    public void setTime2(Time t2){
        this.t2 = t2;
        
    }
    
    public ArrayList<Station> getStations(){
        ArrayList<Station> s = new ArrayList<>();
        for (Station i : lineStations) {
            s.add(i);            
        }

        return s;
    }


    @Override
    public String toString(){
        return nLine + "";
    }

    @Override
    public int compareTo(Line l){
        if (l.getNLine()<nLine) {
            return 1;
        } else if (l.getNLine()>nLine) {
            return -1;
        }
        return 0;
    }

 
    public void addStationToLine(Station s){
        for (Station i : stations) {
            if (i.getCode() == s.getCode()) {
                lineStations.add(i);
            }   
        }
    }

    
    public void removeStationToLine(Station s){
        for (Station i : stations) {
            if (i.getCode() == s.getCode()) {
                lineStations.remove(i);
            }   
        }
    }
    
       // CU 4 : CHECK ROUTES
    public String howToGet(String c1, String c2){
        ArrayList<Line> ls = new ArrayList<>();
        String res = "";

        for (Line l : myRepository.getLines()) {
            for (int i = 0; i<l.getStations().size(); i++) {
             
                if (l.getStations().get(i).getPlace().equals(c1)) {
               
                   
                    for (int j = i+1; j<l.getStations().size(); j++) {
                        if (l.getStations().get(j).getPlace().equals(c2)) {
                            
                            ls.add(l);
                            res += l.getNLine() + ", ";
                        }
                    }

                } else if (l.getStations().get(i).getPlace().equals(c2)) {
                    for (int j = i+1; j<l.getStations().size(); j++) {
                        if (l.getStations().get(j).getPlace().equals(c1)) {
                            ls.add(l);
                            res += l.getNLine() + ", ";
                        }
                    }
                }
                
                
            }
        }

        if (ls.size()>1) {
            return "\n\n             User can take lines: " + res.substring(0, res.length()-2);
        } else if (ls.size()==1) {
            return "\n\n             User can take line " + res.substring(0, res.length()-2);
        }
        return "\n\n         There is no metro you can take.";

    }

}