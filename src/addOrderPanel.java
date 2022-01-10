import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class addOrderPanel {
    private JPanel panel1;
    private JLabel labelDatum;
    private JButton buttonSubmit;
    private JList list1;
    private JButton buttonAddItem;
    private JButton buttonRemoveItem;
    private JLabel labelTotaalPrijs;
    private JLabel labelUur;
    private int prijs;
    DefaultListModel<String> modelItems = new DefaultListModel<>();
    public static OverzichtVoegOrderToe overzichtAdder = new OverzichtVoegOrderToe();

    JFrame frame = new JFrame();

    public addOrderPanel() {
        buttonAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddOrderAddItem addOrderAddItem = new AddOrderAddItem();
                addOrderAddItem.run();

            }
        });
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVReadWriter.purgeCO();
            }
        });
    }

    public void exit() {
        frame.dispose();
    }
    public void run(){
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Add Item To Menu");
        frame.pack();
        frame.setVisible(true);
        labelTotaalPrijs.setText("€"+prijs);
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd-mm-yyyy", Locale.ROOT);
        DateTimeFormatter dtfHour = DateTimeFormatter.ofPattern("HH:mm", Locale.ROOT);
        labelDatum.setText(dtfDate.format(LocalDateTime.now())+"");
        labelUur.setText(dtfHour.format(LocalDateTime.now())+"");
    }
}
