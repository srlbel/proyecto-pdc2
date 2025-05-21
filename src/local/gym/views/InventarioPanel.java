package views;

import models.Inventario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioPanel extends JPanel {

    private MainView mainView;
    private Inventario inventario;

    public InventarioPanel(MainView mainApp, Inventario inventario) {
        this.inventario = inventario;
        this.mainView = mainApp;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Inventorio");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton backButton = new JButton("Volver al menú principal");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showScreen("Primary");
            }
        });

        add(titleLabel, BorderLayout.NORTH);
        add(backButton, BorderLayout.SOUTH);
    }
}
