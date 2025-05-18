package views;

import javax.swing.*;
import java.awt.*;

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

        public MainView() {
                super("Gymnasio La Arepa 'e Huevo");

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(800, 600);
                setLocationRelativeTo(null);

                cardPanel = new JPanel();
                cardLayout = new CardLayout();
                cardPanel.setLayout(cardLayout);

                PrimaryPanel primaryPanel = new PrimaryPanel(this);
                InventarioPanel inventarioPanel = new InventarioPanel(this);
                UsuariosPanel usuariosPanel = new UsuariosPanel(this);
                EmpleadosPanel empleadosPanel = new EmpleadosPanel(this);
                MantenimientosPanel mantenimientosPanel = new MantenimientosPanel(this);
                RutinasPanel rutinasPanel = new RutinasPanel(this);

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
