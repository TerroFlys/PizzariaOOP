public class Klant {
    private String naam;



    public Klant(String naam) {
        this.naam = naam;
    }
    public String returnCsvReady(){
        return this.naam + ";" + -1;
    }


    public void koop(Product p, int amount){
        double prijs = (p.getPrijs() * amount) * (1-korting()-new Event().korting());
        System.out.println(prijs);
    }
    public double korting(){
        return 0;
    }
    @Override
    public String toString() {
        return "Klant{" +
                "naam='" + naam + '\'' +
                '}';
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}
