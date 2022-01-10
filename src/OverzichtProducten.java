import java.util.HashMap;
import java.util.Iterator;

public class OverzichtProducten {
    private HashMap<String, Product> lijst = new HashMap<>();

    public OverzichtProducten() {
    }
    public void writeCSV(){
        String CSVreadyString ="";
        for (String s: lijst.keySet() ) {
            Product p = lijst.get(s);
            CSVreadyString += p.CSVreadyString();
        }
        CSVReadWriter.writeProducten(CSVreadyString, false);
    }

    public static void addCSV(Product p){
        if (p.getPrijs() < 0) {
            System.out.println("Invalid price, not adding item:");
            System.out.println(p);
        } else {
            CSVReadWriter.writeProducten(p.CSVreadyString(), true);
        }
    }
    public void voegToe(Product p) {
        if (p.getPrijs() < 0) {
            System.out.println("Invalid price, not adding item:");
            System.out.println(p);
        } else {
            lijst.put(p.getProductCode(), p);
        }

    }


    public Product selecteer(String code) {
        return lijst.get(code);
    }

    public void showAllToConsole() {
        System.out.println("Size: " + lijst.size());
        for (String s : lijst.keySet()) {
            System.out.println("Code: " + s + "  product: " + lijst.get(s));
        }
    }

    public HashMap<String, Product> getLijst() {
        return lijst;
    }

    public void setLijst(HashMap<String, Product> lijst) {
        this.lijst = lijst;
    }

    public void remove(String code) {

        Iterator<String> it = lijst.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().equals(code)) {
                it.remove();
                writeCSV();
                System.out.println("removed");
                return;
            }
        }
        System.out.println("Finished function, this means the code given did not match any code in the hashmap.");
    }
}
