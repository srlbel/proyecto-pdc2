package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import controllers.EjercicioController;
import controllers.EmpleadoController;
import controllers.ImplementoController;
import controllers.MaquinaController;
import controllers.RutinaController;
import controllers.UserController;
import models.Ejercicio;
import models.Entrenador;
import models.Implemento;
import models.Inventario;
import models.Maquina;
import models.Persona;
import models.Rutina;

public class MainView extends JFrame {
        private JPanel cardPanel;
        private CardLayout cardLayout;

        // Constantes para crear las cartas
        private static final String PRIMARY_SCREEN = "Primary";
        private static final String INVENTARIO_SCREEEN = "Inventario";
        private static final String USUARIOS_SCREEN = "Usuarios";
        private static final String EMPLEADOS_SCREEN = "Empleados";
        private static final String VISITAS_SCREEN = "Mantenimientos";
        private static final String RUTINAS_SCREEN = "Rutinas";

        private static UserController userController;
        private static EmpleadoController empleadoController;
        private static EjercicioController ejercicioController;
        private static ImplementoController implementoController;
        private static MaquinaController maquinaController;
        private static RutinaController rutinaController;

        public MainView() {
                super("Gymnasio La Arepa 'e Huevo");

                List<Persona> personas = new ArrayList<>();
                List<Ejercicio> ejercicios = new ArrayList<>();
                List<Rutina> rutinas = new ArrayList<>();

                Inventario inventarioImplementos = new Inventario();

                userController = new UserController(personas);
                empleadoController = new EmpleadoController(personas);
                ejercicioController = new EjercicioController(ejercicios);
                implementoController = new ImplementoController(inventarioImplementos);
                maquinaController = new MaquinaController(inventarioImplementos);
                rutinaController = new RutinaController(rutinas);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(800, 600);
                setLocationRelativeTo(null);

                cardPanel = new JPanel();
                cardLayout = new CardLayout();
                cardPanel.setLayout(cardLayout);

                PrimaryPanel primaryPanel = new PrimaryPanel(this);
                InventarioPanel inventarioPanel = new InventarioPanel(this, inventarioImplementos);
                UsuariosPanel usuariosPanel = new UsuariosPanel(this, userController);
                EmpleadosPanel empleadosPanel = new EmpleadosPanel(this, empleadoController);
                MantenimientosPanel mantenimientosPanel = new MantenimientosPanel(this, maquinaController);
                RutinasPanel rutinasPanel = new RutinasPanel(this, rutinaController, userController);

                cardPanel.add(primaryPanel, PRIMARY_SCREEN);
                cardPanel.add(inventarioPanel, INVENTARIO_SCREEEN);
                cardPanel.add(usuariosPanel, USUARIOS_SCREEN);
                cardPanel.add(empleadosPanel, EMPLEADOS_SCREEN);
                cardPanel.add(mantenimientosPanel, VISITAS_SCREEN);
                cardPanel.add(rutinasPanel, RUTINAS_SCREEN);

                getContentPane().add(cardPanel);

                showScreen(PRIMARY_SCREEN);
        }

        public void showScreen(String screenName) {
                cardLayout.show(cardPanel, screenName);
        }
}
