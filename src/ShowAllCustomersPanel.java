import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShowAllCustomersPanel {
    private JPanel panel1;
    private JButton buttonOk;
    private JList listKlanten;
    private JFrame frame;
    DefaultListModel<String> modelLijstKlanten = new DefaultListModel<>();
    private ArrayList<Klant> klantenLijst = new ArrayList<>();

    public ShowAllCustomersPanel() {
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listKlanten.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String geselecteerd = listKlanten.getSelectedValue().toString();
            }
        });
    }
    public void run(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.setTitle("Customer List");
        frame.pack();
        renderList();
    }
    public void renderList(){
        modelLijstKlanten.removeAllElements();
        klantenLijst = CSVReadWriter.readFromKlant();
        for (Klant k: klantenLijst) {
            modelLijstKlanten.addElement(k.getNaam());
        }
    }
}
