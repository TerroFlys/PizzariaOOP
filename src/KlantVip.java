public class KlantVip extends Klant{
    private int vipLevel;

    public KlantVip(String naam, int vipLevel) {
        super(naam);
        this.vipLevel = vipLevel;
    }
    @Override
    public String returnCsvReady(){
        return super.getNaam() + ";" + this.vipLevel;
    }
    @Override
    public String toString() {
        return super.toString() + "KlantVip{" +
                "vipLevel=" + vipLevel +
                '}';
    }
    @Override
    public double korting(){
        return 0.01*this.vipLevel;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

}
