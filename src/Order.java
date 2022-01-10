import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Order {

    private String orderID;
    private Date orderDate = new Date();
    private String klantnaam;
    private ArrayList<Product> itemList = new ArrayList<>();
    private double prijsTotal = 0;

    public Order(String orderID, String klantnaam) {
        orderDate.setTime(orderDate.getTime());
        this.orderID = orderID;
        this.klantnaam = klantnaam;
    }

    public void voegToe(Product p, int amount){
        for (int i = 0; i < amount; i++) {
            itemList.add(p);
            System.out.println(itemList);
        }

    }
    public void remove(int index){
        itemList.remove(index);
    }
    public void showIndexes(){
        for (int i = 0; i < itemList.size() ; i++) {
            System.out.println(i + " : " + itemList.get(i));

        }
    }

    public void calculate(){
        for (Product p : itemList) {
            prijsTotal += p.getPrijs();
            //System.out.println(p.getPrijs());
        }
        System.out.println("Current Price = " + prijsTotal);
        Klant klant = null;
        for (Klant k: CSVReadWriter.readFromKlant()) {
            if (k.getNaam().equals(this.klantnaam)){
                if (k.korting()<0){
                    klant = new KlantVip(klantnaam, (int)k.korting()*100);
                } else{
                    klant = new Klant(klantnaam);
                }
            }

        }
        System.out.println(klant);
        if (klant.korting()>0){
            prijsTotal *= 1-klant.korting();
            System.out.println("Korting: " + klant.korting());
            System.out.println("totaal: " + prijsTotal);
        }
    }
    public String returnCSVString(){
        String msg = this.orderDate.getTime()+";"+this.orderID
                +";"+this.klantnaam + ";" + prijsTotal+"\n";
        return msg;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getKlantnaam() {
        return klantnaam;
    }

    public void setKlantnaam(String klantnaam) {
        this.klantnaam = klantnaam;
    }

    public ArrayList<Product> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Product> itemList) {
        this.itemList = itemList;
    }

    public double getPrijsTotal() {
        return prijsTotal;
    }

    public void setPrijsTotal(double prijsTotal) {
        this.prijsTotal = prijsTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate=" + orderDate +
                ", klantnaam='" + klantnaam + '\'' +
                ", itemList=" + itemList +
                ", prijsTotal=" + prijsTotal +
                '}';
    }
}
