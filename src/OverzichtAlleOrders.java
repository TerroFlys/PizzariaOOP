import java.util.HashMap;

public class OverzichtAlleOrders {
    private HashMap<String, Order> lijst = new HashMap<>();

    public OverzichtAlleOrders() {
    }

    public void voegToe(Order o){
        lijst.put(o.getOrderID(), o);
    }

    public Order selecteer(String code) {
        return lijst.get(code);
    }

    public HashMap<String, Order> getLijst() {
        return lijst;
    }

    @Override
    public String toString() {
        return "OverzichtAlleOrders{" +
                "lijst=" + lijst +
                '}';
    }
}

