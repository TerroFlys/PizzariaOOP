import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PizzariaPanel {
    private JPanel panel1;
    private JButton buttonAddOrder;
    private JButton buttonManageKlant;
    private JButton buttonMenu;
    private JButton buttonCheckEarnings;
    private JButton buttonSettings;
    private JList listOrders;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    OverzichtAlleOrders overzichtAlleOrders = CSVReadWriter.readOrders();

    public PizzariaPanel() {
        buttonManageKlant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageKlantPanel managePanel = new manageKlantPanel();
                managePanel.run();
                render();
            }
        });
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel menupanel = new menuPanel();
                menupanel.run();
                render();
            }
        });
        buttonAddOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrderPanel2 addOrder = new addOrderPanel2();
                addOrder.run();
                render();
            }
        });
        listOrders.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //maak order
                Order o = overzichtAlleOrders.selecteer(listOrders.getSelectedValue().toString());
                //toon order
                ToonOrderPanel toonOrderPanel = new ToonOrderPanel();
                toonOrderPanel.run(o);
            }
        });
        buttonCheckEarnings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ToonWinst toonWinst = new ToonWinst();
                toonWinst.run();
            }
        });
    }

    public void run(){
        //maakt de JFrame in de run, ik heb deze nergens anders nodig
        JFrame frame = new JFrame();
        //sluit de applicatie
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.pack();
        frame.setTitle("Pizzaria");
        frame.setVisible(true);
        //dingen voor de lijst
        render();
        listOrders.setModel(listModel);

    }
    private void render(){
        //Ik weet niet hoe ik dit kan laten gebeuren als er een nieuw item word toegevoegt
        //dus probeer ik het op zoveel mogelijk plaatsen te zetten.
        listModel.removeAllElements();
        overzichtAlleOrders = CSVReadWriter.readOrders();
        for (String oID: overzichtAlleOrders.getLijst().keySet()) {
            listModel.addElement(oID);
        }
    }
}
