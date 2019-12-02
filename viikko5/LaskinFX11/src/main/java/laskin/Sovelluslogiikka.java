package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    private int edTulos;
 
    public void plus(int luku) {
        edTulos = tulos;
        tulos += luku;
    }
     
    public void miinus(int luku) {
        edTulos = tulos;
        tulos -= luku;
    }
 
    public void nollaa() {
        edTulos = tulos;
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }

    public void peru() {
        tulos = edTulos;
    }
}