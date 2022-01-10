import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;

public class menuPanel {
    private JPanel panel1;
    private JLabel labelMenuTitel;
    private JList list1;
    private JButton buttonOK;
    private JButton buttonShowProduct;
    private JButton buttonRemoveProduct;
    private JButton buttonAdd;
    String geselecteerd = "";
    JFrame frame = new JFrame();
    DefaultListModel<String> modelItemsMenu = new DefaultListModel<>();

    OverzichtProducten overzichtProducten = CSVReadWriter.readProducten();

    public menuPanel() {
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (buttonShowProduct.isEnabled() == false) {
                    buttonShowProduct.setEnabled(true);
                    buttonRemoveProduct.setEnabled(true);
                }
                geselecteerd = list1.getSelectedValue().toString();
                System.out.println("Geselecteerd: " + geselecteerd);

            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonShowProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemOpMenuPanel itemopmenu = new itemOpMenuPanel();
                itemopmenu.run(overzichtProducten.selecteer(geselecteerd));

            }
        });
        buttonRemoveProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renderer();
                overzichtProducten.remove(geselecteerd);
                renderer();
                buttonShowProduct.setEnabled(false);
                buttonRemoveProduct.setEnabled(false);
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addProductPanel addproduct = new addProductPanel();
                addproduct.run();
                renderer();
            }
        });

        frame.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                renderer();
            }
        });
    }

    public void run() {

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Menu");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);

        renderer();
    }

    private void renderer() {
        overzichtProducten = CSVReadWriter.readProducten();
        buttonShowProduct.setEnabled(false);
        buttonRemoveProduct.setEnabled(false);
        list1.setModel(modelItemsMenu);
        modelItemsMenu.removeAllElements();
        Iterator<String> it = overzichtProducten.getLijst().keySet().iterator();
        while (it.hasNext()) {
            modelItemsMenu.addElement(it.next());
        }
    }
}
