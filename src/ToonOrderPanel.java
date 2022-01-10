import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ToonOrderPanel {
    private JFrame frame = new JFrame();
    private JPanel panel1;
    private JLabel labelDate;
    private JLabel labelUUR;
    private JLabel labelOrderID;
    private JLabel labelKlantNaam;
    private JLabel labelTotaalTXT;
    private JLabel labelTotaalint;
    private JButton buttonOK;

    public ToonOrderPanel() {
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }
    private void exit(){
        frame.dispose();
    }

    public void run(Order order){
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Order Info: " + order.getOrderID());
        //get scherm size
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (screensize.width-frame.getWidth())/2;
        int y = (int) (screensize.height-frame.getHeight())/2;
        //zet het ongv in het midden
        frame.setLocation(x,y);
        //maak de size beetje grooter
        frame.setSize(frame.getWidth()+150,frame.getHeight()+60);
        //zet de text in de labels
        labelOrderID.setText(order.getOrderID());
        labelKlantNaam.setText(order.getKlantnaam());
        labelTotaalint.setText("€"+order.getPrijsTotal());
        //formateer tijd
        DateTimeFormatter dtfLinks = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        DateTimeFormatter dtfRechts = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
        //zet de date
        Date date = order.getOrderDate();
        //zet de date om anar LocalDateTime want ik kan het niet formatten via Date
        labelDate.setText(dtfLinks.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
        labelUUR.setText(dtfRechts.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())));
    }
}
