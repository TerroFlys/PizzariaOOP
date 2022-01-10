public class Product {
    private String productCode;
    private String beschrijving;
    private double prijs;

    public Product(String productcode, String beschrijving, double prijs) {
        this.productCode = productcode;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }
    public String CSVreadyString(){
        String CSVready= this.getProductCode()+";"+this.getBeschrijving()+
                ";"+this.getPrijs()+"\n";;
        return CSVready;

    }
    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                '}';
    }

    public String getProductCode() {
        return productCode;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }
}
