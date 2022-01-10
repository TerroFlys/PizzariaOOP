public class TestKlas {
    public static void main(String[] args) {
        /*Klant k1 = new Klant("Test Klant");
        Klant k2 = new Klant("Johhny");
        KlantVip kv1 = new KlantVip("Jeff", 5);
        Winkel w1 = new Winkel();
        Product p1 = new Product("001","Water", 0.75);
        w1.voegToeAanMenu(p1);
        w1.koop(k1,p1,2);
        Orders o1 = new Orders(k1);
        o1.voegItemToe(p1);
        w1.koop(kv1, p1,2);
        CSVReadWriter.writeToKlant("jeff;10", true);
        ArrayList<Klant> klantlijst = CSVReadWriter.readFromKlant();
        for (Klant k: klantlijst) {
            System.out.println(k.getNaam() + " " + k.korting());
        }*/
        //CSVReadWriter.purgeKlant();
        /*
        OverzichtProducten overzichtProducten = CSVReadWriter.readProducten();
        overzichtProducten.showAllToConsole();
        System.out.println(overzichtProducten.selecteer("P001"));
        Product p1 = new Product("D002", "Cola", 2);
        String cvsready = p1.CSVreadyString();
        System.out.println(cvsready);
        CSVReadWriter.writeProducten(cvsready,true);*/
/*
        Klant k1 = new Klant("Jeff");
        Klant k2 = new KlantVip("Jeff", 10);
        Order order1 = new Order("ID001", k1);
        Product kaas = new Product("P016", "Kaas", 20);
        order1.voegToe(kaas, 5);
        order1.calculate();
        // System.out.println(order1.getPrijsTotal());
        //System.out.println(order1.returnCSVString());
        order1.showIndexes();
        order1.remove(4);
        Product hesp = new Product("P111","Hesp",16);
        order1.voegToe(hesp, 1);
        order1.voegToe(kaas,1);
        System.out.println("-----------");
        order1.showIndexes();
        order1.remove(4);
        System.out.println("---------");
        order1.showIndexes();*/
        /*
        Product kaas = new Product("P016", "Kaas", 20);
        Product hesp = new Product("P016", "hesp", 20);
        OverzichtVoegOrderToe overzicht = new OverzichtVoegOrderToe();
        overzicht.voegToe(kaas,10);
        overzicht.voegToe(hesp,10);
        overzicht.voegToe(kaas,5);
        System.out.println(overzicht);
        Klant jeff = new KlantVip("jeff",5);
        Order o1 = overzicht.createOrder("001", jeff);*/
        /*
        Klant jeff = new Klant("jeffje");
        CSVReadWriter.writeToKlant(jeff.returnCsvReady(),true);
        System.out.println(jeff.korting());*//*
        Order o = new Order("10","jeffje");
        Product p1 = new Product("T001", "Test", 100);
        System.out.println(p1.CSVreadyString());
        o.voegToe(p1,2);
        o.showIndexes();
        o.remove(0);
        o.voegToe(p1,5);
        o.calculate();
        System.out.println(o);
        OverzichtAlleOrders oao = new OverzichtAlleOrders();
        oao.voegToe(o);
        Order o2 = oao.selecteer(o.getOrderID());
        System.out.println(o2);
        */
        /*
        Product p1 = new Product("T001", "Test 1", 1);
        Product p2 = new Product("T002", "Test 2", 2);
        Product p3 = new Product("T003", "Test 3 negative", -1);
        OverzichtProducten op = new OverzichtProducten();
        op.voegToe(p1);
        op.voegToe(p2);
        op.voegToe(p3);
        op.writeCSV();
        op.remove(p2.getProductCode());*/






    }
}
