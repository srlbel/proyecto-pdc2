package views;

import javax.swing.JFrame;
import models.Implemento;
import java.util.ArrayList;

public class MainView extends JFrame {

    private ArrayList<Implemento> implementos;

    public MainView() {
        setTitle("gym");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        implementos = new ArrayList<>();

        implementos.add(new Implemento(101, "Colchoneta", "Estacion de trabajo funcional", 20));
        implementos.add(new Implemento(102, "Mancuernas", "Estanteria de mancuernas", 20));
        implementos.add(new Implemento(103, "Barras multifunciones", "Estacion de trabajo funcional", 8));
        implementos.add(new Implemento(104, "Banda elastica", "Estacion de trabajo funcional", 10));
        implementos.add(new Implemento(105, "Pelota suiza", "Estacion de cardio", 5));

      for (Implemento implemento: implementos){
        implemento.mostrarDatos();
      }

        setVisible(true);
    }
}
