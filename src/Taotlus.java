import java.time.LocalDate;
import java.util.Date;

public class Taotlus {
    private String taotlejaNimi;
    private String tooteNimi;
    private LocalDate taotluseKuupäev;

    public Taotlus(String taotlejaNimi, String tooteNimi) {
        this.taotlejaNimi = taotlejaNimi;
        this.tooteNimi = tooteNimi;
        taotluseKuupäev = LocalDate.now();
    }

    public String getTaotlejaNimi() {
        return taotlejaNimi;
    }

    public String getTooteNimi() {
        return tooteNimi;
    }

    public LocalDate getTaotluseKuupäev() {
        return taotluseKuupäev;
    }

}
