import java.util.ArrayList;
import java.util.HashMap;

public class OverzichtVoegOrderToe {
    private HashMap<Product, Integer> lijst = new HashMap<>();

    public OverzichtVoegOrderToe() {
    }

    public Order createOrder(String orderID, Klant k){
        ArrayList<Product> itemlijst;
        Order order = new Order(orderID,k.getNaam());
        for (Product p: lijst.keySet()) {
            order.voegToe(p,lijst.get(p));
        }
        System.out.println(order);
        return order;
    }
    public void voegToe(Product p, int amount){
        if (lijst.get(p)!=null){
            lijst.put(p, lijst.get(p) + amount);
            System.out.println("not null");
        }
        else {
            lijst.put(p,amount);
            System.out.println("is null");
        }
    }

    @Override
    public String toString() {
        return "OverzichtVoegOrderToe{" +
                "lijst=" + lijst +
                '}';
    }

    public HashMap<Product, Integer> getLijst() {
        return lijst;
    }
}
