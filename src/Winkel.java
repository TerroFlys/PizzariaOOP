import java.util.HashMap;

public class Winkel {
    private HashMap<String, Product> menu = new HashMap<>();
    public void koop(Klant k, Product p, int aantal) {
        k.koop(p,aantal);
    }

    public void voegToeAanMenu(Product p) {
        menu.put(p.getBeschrijving(), p);
    }
}
