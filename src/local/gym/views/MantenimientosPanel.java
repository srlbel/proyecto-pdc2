package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MantenimientosPanel extends JPanel {

    private MainView mainView;

    public MantenimientosPanel(MainView mainView) {
        this.mainView = mainView;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Gestion de Mantenimientos");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton verButton = new JButton("Ver mantenimientos");
        JButton nuevoButton = new JButton("Nuevo Mantenimiento");
        JButton backButton = new JButton("Volver al menu principal");

        buttonPanel.add(verButton);
        buttonPanel.add(nuevoButton);
        buttonPanel.add(backButton);

        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(
            MantenimientosPanel.this,
            "Los mantenimientos registrados se veran aqui",
            JOptionPane.INFORMATION_MESSAGE);
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del mantenimiento:");
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha (YYYY-MM-DD):");

            if (descripcion != null && fecha != null) {
            JOptionPane.showMessageDialog(
                MantenimientosPanel.this,
                "Mantenimiento creado:\nDescripción: " + descripcion + "\nFecha: " + fecha,
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );
            }}
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Primary");
            }
        });

        add(titleLabel, BorderLayout.NORTH);
        add(backButton, BorderLayout.SOUTH);
    }
}
