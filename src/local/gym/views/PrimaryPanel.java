package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel {

    private MainView mainView;

    public PrimaryPanel(MainView mainView) {
        this.mainView = mainView;

        setLayout(new GridLayout(0, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Bienvenido! Seleccione una opción: ");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton inventarioButton = new JButton("Inventario");
        JButton usuariosButton = new JButton("Usuarios");
        JButton empleadosButton = new JButton("Empleados");
        JButton mantenimientosButton = new JButton("Mantenimientos");
        JButton rutinasButton = new JButton("Rutinas");

        inventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Inventario");
            }
        });

        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Usuarios");
            }
        });

        empleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Empleados");
            }
        });

        mantenimientosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Mantenimientos");
            }
        });

        rutinasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Rutinas");
            }
        });

        add(welcomeLabel);
        add(inventarioButton);
        add(usuariosButton);
        add(empleadosButton);
        add(mantenimientosButton);
        add(rutinasButton);
    }
}
