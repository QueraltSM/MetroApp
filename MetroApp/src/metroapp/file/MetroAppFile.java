package metroapp.file;
import java.io.File;
import java.util.Scanner;
import metroapp.Line;
import metroapp.Repository;
import metroapp.main.MetroApp;
import metroapp.Station;

public class MetroAppFile {
    public static Repository myRepository = new Repository();
    public static String place = "";
    public static String num = "";
    public static int code = 0;

    public static void loadFromFile(Repository myRepository){
            try{
                Scanner s=new Scanner(new File("src/metroapp/file/metroappfile.txt"));
                int i, k, c, n=s.nextInt();
                for(i=0;i<n;i++){
                    c=s.nextInt();
                  
                    switch (c) {
                        case 0:
                            myRepository.addLineToRepository(new Line(Integer.parseInt(s.next())));
                            break;
                        case 1:
                            code = Integer.parseInt(s.next());
                            num = String.valueOf(s.next());
                      
                            for (int j = 0; j<Integer.parseInt(num); j++) {
                                place += s.next() + " ";
                            }

                            myRepository.addStationToRepository(new Station(code, place.substring(0, place.length()-1)));
                            num = "";
                            place = "";
                            break;
 
                        default:
                            break;
                    }
                }
            
            } catch(Exception e){
            }      
    }
    
    public static void main(String[] args){
        loadFromFile(myRepository);
        new MetroApp().setVisible(true);
    }
}