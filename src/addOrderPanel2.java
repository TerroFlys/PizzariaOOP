import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class addOrderPanel2 {
    private JPanel panel1;
    private JLabel labelKlant;
    private JComboBox comboBoxKlant;
    private JComboBox comboBoxProduct;
    private JLabel labelProduct;
    private JComboBox comboBoxAmount;
    private JLabel labelAmount;
    private JButton buttonSubmit;
    JFrame frame = new JFrame();
    DefaultComboBoxModel<String> klantComboBoxModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> productComboBoxModel = new DefaultComboBoxModel<>();

    public addOrderPanel2() {
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OverzichtProducten overzichtProducten = new OverzichtProducten();
                overzichtProducten = CSVReadWriter.readProducten();
                Order order = new Order(CSVReadWriter.returnNextOrderID(),comboBoxKlant.getSelectedItem().toString());
                order.voegToe(overzichtProducten.selecteer(comboBoxProduct.getSelectedItem().toString()),
                        Integer.parseInt(comboBoxAmount.getSelectedItem().toString()));
                order.calculate();
                CSVReadWriter.writeOrders(order.returnCSVString(),true);
                exit();
            }
        });
    }
    private void exit(){
        frame.dispose();
    }

    public void run(){
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setTitle("Add order");
        frame.setVisible(true);
        frame.setContentPane(panel1);
        frame.pack();
        Dimension schermsize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(frame.getWidth() +100,frame.getHeight());
        int x = (schermsize.width-frame.getWidth())/2;
        int y = (schermsize.height-frame.getHeight())/2;
        frame.setLocation(x, y);
        renderer();
        comboBoxKlant.setModel(klantComboBoxModel);
        comboBoxProduct.setModel(productComboBoxModel);
    }

    private void renderer(){
        klantComboBoxModel.removeAllElements();
        productComboBoxModel.removeAllElements();
        //producten
        OverzichtProducten overzichtProducten = CSVReadWriter.readProducten();
        Iterator<String> it = overzichtProducten.getLijst().keySet().iterator();
        while (it.hasNext()) {
            productComboBoxModel.addElement(it.next());
        }
        //klanten
        ArrayList<Klant> klantenLijst = new ArrayList<>();
        klantenLijst = CSVReadWriter.readFromKlant();
        for (Klant k: klantenLijst) {
            if (k != null){
                klantComboBoxModel.addElement(k.getNaam());
            }
        }

    }
}
