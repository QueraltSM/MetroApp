package metroapp;
import java.util.*;
import metroapp.checkarrival.CheckArrivalGUI;

public class Time{
    private int minuteStart;
    private int minuteStop;
    private int delay;
    private int hourStart;
    private int hourStop;
    private int intervalo;

    private String arrivingTime;
    private Line l;
 

    private String s;
    
    private Calendar calendario = new GregorianCalendar();
    private int horaActual = calendario.get(Calendar.HOUR_OF_DAY);
    private int  minutosActual = calendario.get(Calendar.MINUTE);

    private static Time t = CheckArrivalGUI.time;
    
    private static int d = CheckArrivalGUI.delay;

    
 
    public Time() {}
    
    public Line getLine(){
        return l;
    }
    
    public Time(int hourStart, int minuteStart, int hourStop, int minuteStop, int intervalo, int delay){
        this.minuteStart = minuteStart;
        this.delay = delay;
        this.hourStart = hourStart;
        this.hourStop = hourStop;
        this.intervalo = intervalo;
        this.minuteStop = minuteStop;
    }

    public Time(Line l, String arrivingTime, int d){
        this.l=l;
        this.d = d;
        this.arrivingTime = arrivingTime;
    }


    public Time(String s){
        this.s=s;
    }


    public int getD(){
        return d;
    }


    public boolean equals(Time time){
        return time.toString().equals(s);
    }

    @Override
    public String toString(){
        return s;
    }

    public String getArrivingTime(){
        return arrivingTime;
    }


    // STATION'S TIMETABLE
    public String stationTimetable(){
            String[] s = getArrivingTime().split(" ");
            for (int i = 0; i < s.length; i++) {
                int hora = Integer.parseInt(s[i].substring(0, 2));
                int minutos = Integer.parseInt(s[i].substring(3)) + CheckArrivalGUI.delay;
                
            if (hora == horaActual && minutos == minutosActual) {
                return "Metro " + l + " is coming now.";

            } else if (hora == horaActual && minutos > minutosActual) {
               return "Metro " + l + " passes in " + (minutos - minutosActual) + " minutes.";
                
            //} else if (hora == horaActual && minutos<minutosActual) {
                //return "Metro " + l + " passes in "  + (minutosActual-minutos) + " minutes.";
            
            } else if (hora > horaActual && minutos == minutosActual) {
                return "Metro " + l + " passes in " + (hora - horaActual) + " hours.";
                
            } else if (hora > horaActual && minutos < minutosActual && minutos!=0) {
                return "Metro " + l + " passes in " + (60 - (minutosActual - minutos)) + " minutes.";

            } else if (hora > horaActual && minutos > minutosActual) {
                return "Metro " + l + " passes in " + (hora - horaActual) + " hours and " + (minutos - minutosActual) + " minutes.";
               
            } else if (hora>horaActual && minutos==0) {
                return "Metro " + l + " passes in " + (hora - horaActual) + " hours and " + (60 - minutosActual) + " minutes.";

            } else if (hora == 0) {
                if (minutos == 0) {
                    return "Metro " + l + " passes in " + (24 - horaActual) + " hours and " + (60 - minutosActual) + " minutes.";
                } else if (minutos > minutosActual) {
                    return "Metro " + l + " passes in " + (24 - horaActual) + " hours and " + (minutos - minutosActual) + " minutes.";
                } else if (minutos < minutosActual) {
                    return "Metro " + l + " passes in " + (24 - horaActual) + " hours and " + (60 - (minutosActual - minutos)) + " minutes.";
                }

            }
        }

        int hora = Integer.parseInt(s[0].substring(0, 2));
        int minutos = Integer.parseInt(s[0].substring(3)) + delay;
        
        String result = "Metro " + l + " passes in " + ((24-horaActual)+hora) + " hours";
        if (minutos > minutosActual) {
            result += " and " + (minutos - minutosActual) + " minutes.";
        } else if (minutos < minutosActual) {
            result += " and " + (60 - (minutosActual - minutos)) + " minutes.";
        } else {
            result += ".";
        }
        return result;
        
    }

    // LINE'S TIMETABLE 
    public String lineTimetable(){
        String timetable = "";
        int count = 0;
        minuteStart += delay;
        if(delay == 60 || delay%60 == 0){
            minuteStart = 0;
            int j = delay/60;
            for(int i = 0; i < j; i++){
                hourStart++;
                hourStop++;
                if(hourStop == 24){
                    hourStop--;
                    i = j;
                }
            }
        }
        boolean entro = false;
        for(int i = hourStart; i < hourStop; i++){
            for(int j = minuteStart; j < 61; j = j + intervalo){
                if(entro) j = j + intervalo;
                if (j == 60 && !entro) {
                    i++;
                    if (i<10) {
                        timetable += "                [0" + i + ":" + "00" + "]";
                    } else {
                        timetable += "                [" + i + ":" + "00" + "]";
                    }
                    i--;
                    entro = true;
                    count++;
                } else if(j == 0){
                    if (i<10) {
                        timetable += "                [0" + i + ":" + "00" + "]";
                    } else {
                        timetable += "                [" + i + ":" + "00" + "]";
                    }
                    entro = false;
                    count++;
                } else{
                    if (i<10) {
                        if (j>=61) {
                            timetable += "                [0" + (i+1) + ":" + (j-60) + "]";
                        } else if (j<10) {
                            timetable += "                [0" + i + ":0" + j + "]";
                        } else {
                            timetable += "                [0" + i + ":" + j + "]";
                        }

                    } else {
                        if (j>=61) { 

                            if ((j-60)<10) {
                                timetable += "                [" + (i+1) + ":0" + (j-60) + "]";
                            } else {
                                timetable += "                [" + (i+1) + ":" + (j-60) + "]";
                            }

                        }  else if (j<10) {
                            timetable += "                [" + i + ":0" + j + "]";
                        } else {
                            timetable += "                [" + i + ":" + j + "]";
                        }
                    }
                    entro = false;
                    count++;
                }
                if (count%3==0) {
                    timetable += "\n";
                }
            }
        }
        return timetable;
    }
}