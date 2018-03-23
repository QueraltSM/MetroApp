package metroapp.buyticket;
import java.awt.*;

class Print {
    Font fuente = new Font("Dialog", Font.PLAIN, 10);
    PrintJob pj;
    Graphics pagina;

    Print()
    {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Printing Ticket", null);
    }

    public void imprimir(String Cadena) {
        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);

            pagina.drawString(Cadena, 60, 60);

            pagina.dispose();
            pj.end();
        } catch(Exception e) {
            System.out.println("The printer has been canceled.");
        }
    }
}


