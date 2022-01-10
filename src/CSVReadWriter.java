import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class CSVReadWriter {
    public static ArrayList<Klant> readFromKlant() {
        ArrayList<Klant> klantenLijst = new ArrayList<>();
        File klantFile = new File("./files/klant.csv");
        try {
            Scanner klantReader = new Scanner(klantFile);
            while (klantReader.hasNextLine()) {
                String data = klantReader.nextLine();
                String[] attributes = data.split(";");
                if (attributes.length==2){
                    Klant k = createKlant(attributes);
                    klantenLijst.add(k);
                }

            }
            klantReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return klantenLijst;
    }
    public static void writeProducten(String CSVready, boolean append){
        try {
            FileWriter prodWriter = new FileWriter("./files/product.csv", append);
            if (append){
                //voor add
                prodWriter.append(CSVready);
            } else {
                //voor remove
                prodWriter.append(CSVready);
            }
            prodWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void writeOrders(String CSVready, boolean append){
        try {
            FileWriter orderWriter = new FileWriter("./files/order.csv", append);
            orderWriter.append(CSVready);
            System.out.println("Appended.");
            orderWriter.close();
            System.out.println("Order writer closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String returnNextOrderID(){
        File orders = new File("./files/order.csv");
        String ID="0";
        try {
            Scanner orderReader = new Scanner(orders);
            while (orderReader.hasNextLine()){
                String data = orderReader.nextLine();
                String[] att = data.split(";");
                System.out.println(att.length);
                try {
                    if (att[1]!=null){
                        ID = att[1];
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ID = (Integer.parseInt(ID)+1) + "";
        } catch (NumberFormatException err){

        }
        return ID;
    }


    public static OverzichtProducten readProducten(){
        OverzichtProducten overzicht = new OverzichtProducten();
        File productFile = new File("./files/product.csv");
        try {
            Scanner productReader = new Scanner(productFile);

            while (productReader.hasNextLine()){
                String data = productReader.nextLine();
                String[] attributes = data.split(";");
                if (attributes.length==3){
                    Product p = createProduct(attributes);
                    overzicht.voegToe(p);
                }
            }
            productReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Return overzicht");
        return overzicht;
    }

    private static Product createProduct(String[] attributes) {
        String productcode = attributes[0];
        String beschrijving = attributes[1];
        double prijs = 0;
        try {
            prijs = Double.parseDouble(attributes[2]);

        } catch (NumberFormatException e) {
            System.out.println("Error:\n"+e);
           prijs = -1;
        }
        Product p = new Product(productcode, beschrijving, prijs);
        return p;

    }

    private static Klant createKlant(String[] attributes) {
        if (attributes.length == 2) {
            String naam = attributes[0];
            int vip = Integer.parseInt(attributes[1]);
            if (vip < 0) {
                return new KlantVip(naam, vip);
            } else {
                return new Klant(naam);
            }
        } else {
            System.out.println("Something is wrong with the attributes");
            for (String s: attributes) {
                System.out.println(s);
            }
            return null;
        }


    }



    public static void writeToKlant( String csvReadyFormat,boolean append){
        try {
            FileWriter klantWriter = new FileWriter("./files/klant.csv", append);
            if (append){
                klantWriter.append(csvReadyFormat);
                klantWriter.append("\n");
            }
            else {
                klantWriter.write(csvReadyFormat);


            }
            System.out.println("Done");
            klantWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error:\n" + e);
        }
    }

    public static void purgeKlant() {
        try {
            FileWriter klantWriter = new FileWriter("./files/klant.csv");
            klantWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void purgeCO() {
        try {
            FileWriter klantWriter = new FileWriter("./files/currentOrder.csv");
            klantWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OverzichtAlleOrders readOrders() {
        OverzichtAlleOrders overzicht = new OverzichtAlleOrders();
        File orderFile = new File("./files/order.csv");
        try {
            Scanner orderReader = new Scanner(orderFile);
            while (orderReader.hasNextLine()){
                String data = orderReader.nextLine();
                String[] attributes = data.split(";");
                if (attributes.length==4){
                    Order o = createOrder(attributes);
                    overzicht.voegToe(o);
                }
            }
            orderReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Return overzicht");

        return overzicht;
    }

    public static Order createOrder(String[] s){
        Order o = new Order(s[1],s[2]);
        o.setPrijsTotal(Double.parseDouble(s[3]));
        Date date = new Date();
        date.setTime(Long.parseLong(s[0]));
        o.setOrderDate(date);
        return o;

    }

    public void cleanWhiteSpaceKlant(){
        try {
            FileWriter klantWriter = new FileWriter("./files/klant.csv", false);
            klantWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
