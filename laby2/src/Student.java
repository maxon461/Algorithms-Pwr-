import java.util.ArrayList;
import java.util.Iterator;

public class Student  {
    private String nazwisko;
    private String imie;
    private String indeks;
    private double sr_ocena;

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public double getSr_ocena() {
        return sr_ocena;
    }

    public void setSr_ocena(double sr_ocena) {
        this.sr_ocena = sr_ocena;
    }

    @Override
    public String toString() {
        return "Student [indeks=" + indeks + ", nazwisko=" + nazwisko + ", imie=" + imie + ", sr_ocena=" + sr_ocena
                + "]";
    }

    

    public Student(String nazwisko, String imie, String indeks, double sr_ocena) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.indeks = indeks;
        this.sr_ocena = sr_ocena;
    }

    public Student() {
        this.nazwisko = "None";
        this.imie = "None";
        this.indeks = "None";
        this.sr_ocena = 0;
    }

   
    

    
    
    
}
