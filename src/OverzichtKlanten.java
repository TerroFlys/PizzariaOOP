import java.util.HashMap;

public class OverzichtKlanten {
    private HashMap<String, Klant> lijst = new HashMap<>();

    public OverzichtKlanten() {
    }

    public void voegToe(Klant k) {
        lijst.put(k.getNaam(), k);
    }

    public Klant selecteer(String klantNaam) {
        return lijst.get(klantNaam);
    }

    public HashMap<String, Klant> getLijst() {
        return lijst;
    }

    public void setLijst(HashMap<String, Klant> lijst) {
        this.lijst = lijst;
    }
}
