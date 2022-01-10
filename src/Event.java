import java.util.Calendar;
import java.util.Date;

public class Event {
    public double korting(){
        Calendar cal = Calendar.getInstance();
        int dag = cal.get(Calendar.DAY_OF_WEEK);

        if (dag == 3){
            return 0.2;
        } else if(dag == 6) {
            return 0.1;
        }
        else {
            return 0;

        }

    }
}
