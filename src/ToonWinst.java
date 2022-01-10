import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;

public class ToonWinst {
    private JPanel panel1;
    private JLabel labelTextDag;
    private JLabel labelWinstDag;
    private JLabel labelTextWeek;
    private JLabel labelWinstWeek;
    private JLabel lebelTxt;

    public void run(){
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(frame.getWidth() +100,frame.getHeight());
        int x = (screenSize.width-frame.getWidth())/2;
        int y = (screenSize.height-frame.getHeight())/2;
        frame.setLocation(x,y);
        frame.setVisible(true);
        frame.setTitle("Winst");
        calculateWinst();
    }
    public void calculateWinst(){
        OverzichtAlleOrders orders = CSVReadWriter.readOrders();
        HashMap<String, Order> map = orders.getLijst();
        double dagwinst = calcDag(map);
        double weekwinst = calcWeek(map);
        labelWinstDag.setText(String.format("€%.2f", dagwinst));
        labelWinstWeek.setText(String.format("€%.2f", weekwinst));
    }

    private double calcWeek(HashMap<String,Order> map) {
        Date date = new Date();
        long currentTime = date.getTime();
        long week = 604800000L;
        double tot = 0;
        for (String s: map.keySet()) {
            long orderTime = map.get(s).getOrderDate().getTime();
            if (currentTime-orderTime<week){
                tot += map.get(s).getPrijsTotal();
            }

        }
        return tot;
    }

    private double calcDag(HashMap<String,Order> map) {
        Date date = new Date();
        long currentTime = date.getTime();
        long day = 86400000L;
        double tot = 0;
        for (String s: map.keySet()) {
            long orderTime = map.get(s).getOrderDate().getTime();
            if (currentTime-orderTime<day){
                tot += map.get(s).getPrijsTotal();
            }

        }
        return tot;

    }
}
