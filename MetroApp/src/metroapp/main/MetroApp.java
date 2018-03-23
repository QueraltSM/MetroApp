package metroapp.main;
import java.applet.AudioClip;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import metroapp.Card;
import metroapp.Incidence;
import metroapp.Line;
import metroapp.Repository;
import metroapp.Station;
import metroapp.Time;
import metroapp.User;
import metroapp.file.MetroAppFile;

public class MetroApp extends javax.swing.JFrame {
static AudioClip sonido;

    public static Repository myRepository = MetroAppFile.myRepository;
    public static  ArrayList<Card> cards = new ArrayList<Card>();
    
    public static User u;
    
    public static Line l;
    public static Line l1;
    public static Line l2;
    public static Line l3;
    public static Line l4;
    public static Line l5;
    
    public static Station s1;
    public static Station s2;
    public static Station s3;
    public static Station s4;
    public static Station s5;
    public static Station s6;
    public static Station s7;
    public static Station s8;
    public static Station s9;
    public static Station s10;
    
    public static User u1;
    public static User u2;
    public static User u3;
    public static User u4;
    public static User u5;
    
    public  static Card c1;
    public  static Card c2;
    public  static Card c3;
    public  static Card c4;
    public  static Card c5;
    
    protected static Time t1 = new Time(8, 40, 21, 00, 20, 5);
    protected static Time t2 = new Time(7, 00, 14, 30, 10, 0);
    protected static Time t3 = new Time(6, 20, 20, 10, 15, 10);
    protected static Time t4 = new Time(12, 40, 23, 00, 5, 5);
    protected static Time t5 = new Time(15, 00, 22, 00, 30, 20);

    /**
     * Creates new form Preview
     */
    
    public MetroApp() {
        init();
        initComponents();
        setTitle("MetroApp");
        setResizable(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(white);
        Timer timer = new Timer (4015, new ActionListener () { 
            public void actionPerformed(ActionEvent e) { 
                   new MetroAppGUI().setVisible(true);
                   dispose();
            } 
        });
        
        timer.start(); 
        timer.setRepeats(false);
        
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Images/music.wav"));
        sonido.loop();
    }
    
    private void init(){
        l1 = myRepository.getLines().get(0);
        l2 = myRepository.getLines().get(1);
        l3 = myRepository.getLines().get(2);
        l4 = myRepository.getLines().get(3);
        l5 = myRepository.getLines().get(4);
        
        s1 = myRepository.getStations().get(0);
        s2 = myRepository.getStations().get(1);
        s3 = myRepository.getStations().get(2);
        s4 = myRepository.getStations().get(3);
        s5 = myRepository.getStations().get(4);
        s6 = myRepository.getStations().get(5);
        s7 = myRepository.getStations().get(6);
        s8 = myRepository.getStations().get(7);
        s9 = myRepository.getStations().get(8);
        s10 = myRepository.getStations().get(9);
        
        
        u = new User();
        l = new Line();
      
        l1.setTime1(t1);
        l1.setTime2(t3);
        l2.setTime1(t2);
        l2.setTime2(t5);
        l3.setTime1(t3);
        l3.setTime2(t4);
        l4.setTime1(t4);
        l4.setTime2(t1);
        l5.setTime1(t5);
        l5.setTime2(t2);
        
        
        Incidence i1 = new Incidence("\n                               Track cut subway: Oxford Street.\n\n"
                + "                               Delay in arriving: 5 minutes.");
        l1.addIncidence(i1);
        l4.addIncidence(i1);
        l5.addIncidence(i1);
        
        Incidence i2 = new Incidence("\n                                   Road Accident: Whitehall. \n\n"
                + "                                Delay in arriving: 15 minutes.");
        l5.addIncidence(i2);
        
        Incidence i3 = new Incidence("\n                      Track cut subway by detachment: Smithfield.\n\n"
                + "                               Delay in arriving: 10 minutes.");
        l3.addIncidence(i3);
       
        c1 = new Card(1, 10.0);
        c2 = new Card(20128, 7.20);
        c3 = new Card(77391, 15.0);
        c4 = new Card(40461, 50.20);
        c5 = new Card(78533, 8.50);

        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);        
                
        u1 = new User(c1, "Steve", "Jobs", "A");
        u2 = new User(c2, "Bill", "Gates", "34557819G");
        u3 = new User(c3, "Ada", "Lovelace", "56733817T");
        u4 = new User(c4, "Larry", "Page", "19126724K");
        u5 = new User(c5, "Alan", "Turing", "92734651M");
        
        myRepository.addUserToRepository(u1);
        myRepository.addUserToRepository(u2);
        myRepository.addUserToRepository(u3);
        myRepository.addUserToRepository(u4);
        myRepository.addUserToRepository(u5);
        

        l1.addStationToLine(s1);
        l1.addStationToLine(s3);
        l1.addStationToLine(s4);
        l1.addStationToLine(s10);
        l1.addStationToLine(s9);
        l1.addStationToLine(s7);

        l2.addStationToLine(s2);
        l2.addStationToLine(s5);
        l2.addStationToLine(s7);
        l2.addStationToLine(s6);
        l2.addStationToLine(s8);
        l2.addStationToLine(s3);

        l3.addStationToLine(s3);
        l3.addStationToLine(s2);
        l3.addStationToLine(s4);
        l3.addStationToLine(s9);
        l3.addStationToLine(s6);
        l3.addStationToLine(s7);

        l4.addStationToLine(s4);
        l4.addStationToLine(s1);
        l4.addStationToLine(s5);
        l4.addStationToLine(s8);
        l4.addStationToLine(s10);
        l4.addStationToLine(s2);

        l5.addStationToLine(s5);
        l5.addStationToLine(s6);
        l5.addStationToLine(s8);
        l5.addStationToLine(s9);
        l5.addStationToLine(s10);
        l5.addStationToLine(s1); 
        
          
        
        

    }
    
    public void actionPerformed(ActionEvent e) {
         this.dispose();
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MetroApp.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new MetroAppGUI().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
