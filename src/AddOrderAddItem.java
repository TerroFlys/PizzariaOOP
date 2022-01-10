import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class AddOrderAddItem {
    private JPanel panel1;
    private JList listProducts;
    private JLabel labelAmount;
    private JComboBox comboBox1;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    JFrame frame = new JFrame();
    DefaultListModel<String> modelItems = new DefaultListModel<>();
    OverzichtProducten overzichtProducten = CSVReadWriter.readProducten();
    String geselecteerd = "";

    public AddOrderAddItem() {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();

            }
        });
        listProducts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                comboBox1.setEnabled(true);
                buttonSubmit.setEnabled(true);
                geselecteerd = listProducts.getSelectedValue().toString();

            }
        });
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void exit(){
        frame.dispose();
    }
    public void run(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Add item");
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.pack();
        //tries to center on the screen
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //screen size
        frame.setLocation((int) ((size.width-frame.getWidth())/2), (int) ((size.height-frame.getHeight())/2));
        renderer();
    }
    private void renderer() {
        overzichtProducten = CSVReadWriter.readProducten();
        buttonSubmit.setEnabled(false);
        comboBox1.setEnabled(false);
        listProducts.setModel(modelItems);
        modelItems.removeAllElements();
        Iterator<String> it = overzichtProducten.getLijst().keySet().iterator();
        while (it.hasNext()) {
            modelItems.addElement(it.next());
        }
    }

}
