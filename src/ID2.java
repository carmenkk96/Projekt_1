import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ID2 {
   /* private Taotlus taotlus;
    private String id;
    private List<String> idKogu = new ArrayList<>();


    public ID2(Taotlus taotlus) throws FileNotFoundException {
        this.taotlus = taotlus;
        generateID();
    }

    private void generateID() throws FileNotFoundException {
        this.id = taotlus.getTaotluseKuupäev().toString().replaceAll("-", "").substring(2) + "-" +
                taotlus.getTaotlejaNimi().substring(0, 2).toUpperCase() + taotlus.getTooteNimi().substring(0, 4).toUpperCase();
        if (idKogu.contains(this.id)) {
            this.id = taotlus.getTaotluseKuupäev().toString().replaceAll("-", "").substring(2) + "-" +
                    taotlus.getTaotlejaNimi().substring(0, 2).toUpperCase() + taotlus.getTooteNimi().substring(0, 4).toUpperCase();
            if (idKogu.contains(this.id)) {
                veaTeade();
            }
        }
        salvestaAndmebaasi(this.id);
        idKogu.add(this.id);
    }

    public void veaTeade () {
        System.out.println("Taotlust ei registreeritud - ID on juba andmebaasis olemas. Palun proovi uuesti!");
    }

    public void salvestaAndmebaasi(String id) throws FileNotFoundException {
        if (idKogu.contains(this.id) == false) {
            try(PrintWriter pw = new PrintWriter(new FileOutputStream("andmebaas.txt", true))) {
                pw.println(taotlus.getTaotluseKuupäev() + " " + taotlus.getTooteNimi() + " " + taotlus.getTaotlejaNimi() + " " + this.id);
            }
        }
    }


    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        if (this.id == null) {
            veaTeade();
           return null;}
        else
            return "Taotlus: " + id + " (" + taotlus.getTaotlejaNimi() + ", " + taotlus.getTooteNimi() + ", " + taotlus.getTaotluseKuupäev() +")";
    }

    public List<String> getIdKogu() {
        return idKogu;
    }*/
}
