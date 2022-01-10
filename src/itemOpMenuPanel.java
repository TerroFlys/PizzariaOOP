import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itemOpMenuPanel {
    private JPanel panel1;
    private JButton buttonOK;
    private JLabel labelName;
    private JLabel labelPrice;
    private JFrame frame;

    public itemOpMenuPanel() {
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void run(Product p){
        frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.pack();
        frame.setTitle("Product: " + p.getProductCode());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        renderer(p);
    }
    private void renderer(Product p) {
        labelName.setText(p.getBeschrijving());
        labelPrice.setText("€"+p.getPrijs());
    }
}
