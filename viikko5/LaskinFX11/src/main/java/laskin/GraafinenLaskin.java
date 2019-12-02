package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GraafinenLaskin extends Pane {
    TextField tuloskentta, syotekentta;
    Sovelluslogiikka sovellus;
    Button nollaa, undo;

    public GraafinenLaskin() {
        super();
        sovellus = new Sovelluslogiikka();
        
        VBox layout = new VBox(10);
        
        tuloskentta = new TextField("0"); 
        tuloskentta.setEditable(false);
        syotekentta = new TextField(""); 
        
        HBox napit = new HBox(10);
        Button plus = new Button("+");
        Button miinus = new Button("-");
        nollaa = new Button("Z");
        nollaa.disableProperty().set(true);
        undo = new Button("undo"); 
        undo.disableProperty().set(true);
        
        napit.getChildren().addAll(plus, miinus, nollaa, undo);
                 
        plus.setOnAction(e -> komento(1));
        miinus.setOnAction(e -> komento(2));
        nollaa.setOnAction(e -> komento(0));
        undo.setOnAction(e -> komento(3));
        
        layout.getChildren().addAll(tuloskentta, syotekentta, napit);   
        
        getChildren().add(layout);
    }

    private void komento(int i) {
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        switch (i) {
            case 1:
                sovellus.plus(arvo);
                break;
            case 2:
                sovellus.miinus(arvo);
                break;
            case 3:
                sovellus.peru();
                break;
            case 0:
                sovellus.nollaa();
        }
        
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
}
