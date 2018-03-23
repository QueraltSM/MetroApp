package metroapp;
public class Incidence implements Comparable <Incidence> {
    private String incidence;
    
    public Incidence(String incidence){
        this.incidence = incidence;
    }
    public String toString(){
        return incidence;
    }
    public int compareTo(Incidence i){
        if (i.toString().compareTo(incidence)<0) {
            return 1;
        } else if (i.toString().compareTo(incidence)>0)  {
            return -1;
        }
        return 0;
    }
}
