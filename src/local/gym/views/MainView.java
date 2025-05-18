package views;

import controllers.UserController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import models.Implemento;
import models.Maquina;
import models.Persona;

public class MainView extends JFrame {

        private ArrayList<Implemento> implementos;
        private ArrayList<Maquina> maquinas;
        private List<Persona> personas = new ArrayList<>();
        UserController userController = new UserController(personas);

        public MainView() {
                setTitle("gym");
                setSize(400, 300);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }
}
