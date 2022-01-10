import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class addKlantPanel {
    private JPanel panel1;
    private JTextField textFieldNaam;
    private JButton buttonSubmit;
    private JCheckBox checkBoxIsVip;
    private JLabel labelVipLevel;
    private JTextField textFieldVipLevel;
    private JLabel labelNaam;
    JFrame frame = new JFrame();

    public addKlantPanel() {
        checkBoxIsVip.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBoxIsVip.isSelected()){
                    textFieldVipLevel.setEnabled(true);
                    textFieldVipLevel.setVisible(true);
                    labelVipLevel.setVisible(true);
                } else {
                    textFieldVipLevel.setEnabled(true);
                    textFieldVipLevel.setVisible(false);
                    labelVipLevel.setVisible(false);
                }
            }
        });
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer viplevel = null;
                if (checkBoxIsVip.isSelected()){
                    try {
                        viplevel = Integer.parseInt(textFieldVipLevel.getText());
                    } catch (NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "VIP level is invalid.");
                    }
                    if (viplevel<0 || viplevel>20){
                        JOptionPane.showMessageDialog(null, "VIP level is invalid.\nVip level must be between 1 and 20.");
                        viplevel = null;

                    }
                } else {
                    viplevel = -1;
                }
                String klantNaam = textFieldNaam.getText();

                if (viplevel!=null){
                    String toCsv = klantNaam + ";";
                    toCsv += viplevel;
                    CSVReadWriter.writeToKlant(toCsv,true);
                    frame.dispose();

                }





            }
        });
    }
    public void run(){

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.pack();
        frame.setTitle("Add Customer");
        labelVipLevel.setVisible(false);
        textFieldVipLevel.setVisible(false);
    }
}
