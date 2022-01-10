import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class removeCustomerPanel {
    private JPanel panel1;
    private JList listKlanten;
    private JButton buttonShowInfo;
    private JButton buttonRemoveSelected;
    private JButton buttonRemoveAll;
    DefaultListModel<String> modelLijstKlanten = new DefaultListModel<>();
    private ArrayList<Klant> klantenLijst = new ArrayList<>();
    private int currentSelected;


    public removeCustomerPanel() {
        listKlanten.setModel(modelLijstKlanten);
        buttonRemoveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int isSure = JOptionPane.showConfirmDialog(null,"You are about to remove all customer data," +
                        "\nAre you sure\nThis cannot be undone","Please confirm", JOptionPane.YES_NO_OPTION);
                if (isSure == JOptionPane.YES_OPTION){
                    CSVReadWriter.purgeKlant();
                    modelLijstKlanten.removeAllElements();
                }

            }
        });
        buttonRemoveSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klantenLijst.remove(currentSelected);
                String CSVready = "";
                for (Klant k: klantenLijst) {
                    CSVready += k.returnCsvReady() + "\n";
                }
                CSVReadWriter.writeToKlant(CSVready, false);
                renderLijst();
            }
        });
        listKlanten.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String geselecteerd = listKlanten.getSelectedValue().toString();

                for (int i = 0; i < klantenLijst.size(); i++) {
                    if (klantenLijst.get(i).getNaam().equals(geselecteerd)){
                        currentSelected = i;
                    }
                }
                System.out.println(currentSelected);
                buttonRemoveSelected.setEnabled(true);
            }
        });
    }
    public void run(){
        JFrame frame = new JFrame();
        frame.setTitle("Remove Customer");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        renderLijst();
    }
    public void renderLijst(){
        modelLijstKlanten.removeAllElements();
        klantenLijst = CSVReadWriter.readFromKlant();
        for (Klant k: klantenLijst) {
            if (k != null) {
                modelLijstKlanten.addElement(k.getNaam());
            }

        }
    }
}
