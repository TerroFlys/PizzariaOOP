import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addProductPanel {
    private JFrame frame;
    private JPanel panel1;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    private JLabel labelProductCode;
    private JLabel labelProductBeschrijving;
    private JLabel labelProductPrijs;
    private JTextField textFieldPrijs;
    private JTextField textFieldBescrijving;
    private JTextField textFieldCode;

    public addProductPanel() {
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code= textFieldCode.getText();
                String beschrijving = textFieldBescrijving.getText();
                Double prijs = null;
                try {
                    prijs = Double.parseDouble(textFieldPrijs.getText());
                } catch (NumberFormatException err){
                    err.printStackTrace();
                }
                if (prijs == null){
                    JOptionPane.showMessageDialog(null, "Ongeldige prijs");
                    textFieldPrijs.requestFocus();

                } else {
                    Product p = new Product(code, beschrijving, prijs);
                    OverzichtProducten.addCSV(p);
                    //Ik weet niet hoe ik vanaf hier, de lijst in menu kan updaten
                    // dus dat update pas als een andere actie ondernomen word
                    exit();
                }

            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }
    public void exit() {
        frame.dispose();
    }
    public void run(){
    frame = new JFrame();
    frame.setContentPane(panel1);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setTitle("Add Item To Menu");
    frame.pack();
    frame.setVisible(true);
    }

}
