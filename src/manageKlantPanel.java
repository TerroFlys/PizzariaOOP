import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageKlantPanel {
    private JButton buttonAddKlant;
    private JPanel panel1;
    private JButton buttonRemoveCustomer;
    private JButton buttonShowCustomerList;

    public manageKlantPanel() {
        buttonAddKlant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addKlantPanel addKlant = new addKlantPanel();
                addKlant.run();
            }
        });
        buttonRemoveCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCustomerPanel removeCustomer = new removeCustomerPanel();
                removeCustomer.run();
            }
        });
    }

    public void run(){
        JFrame frame = new JFrame();
        frame.setTitle("Manage Customers");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        buttonShowCustomerList.setEnabled(false);

    }
}
