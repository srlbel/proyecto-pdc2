package views;

import javax.swing.JFrame;
import models.Implemento;
import java.util.ArrayList;

public class MainView extends JFrame {

    private ArrayList<Implemento> implementos;
    private ArrayList<Maquina> maquinas;

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

      maquinas = new ArrayList<>();

      maquinas.add(new Maquina(201, "Caminadora", "Estacion de cardio", false))
      maquinas.add(new Maquina(201, "Eliptica", "Estacion de trabajo funcional", false))
      maquinas.add(new Maquina(201, "Press banco plano", "Estacion de trabajo superior", true))
      maquinas.add(new Maquina(201, "Maquina de aductores", "Estacion de trabajo inferior", false))
      maquinas.add(new Maquina(201, "Prensa para pierna", "Estacion de trabajo inferior", true))

      for (Maquina maquina: maquinas){
        maquina.mostrarDatos();
      }

  
        setVisible(true);
    }
}
