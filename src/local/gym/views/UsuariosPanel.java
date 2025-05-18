package views;

import controllers.UserController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.Persona;

public class UsuariosPanel extends JPanel {

    private MainView mainView;
    private UserController userController;
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UsuariosPanel(MainView mainView, UserController userController) {
        this.mainView = mainView;
        this.userController = userController;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("User Management");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        String[] coluString = { "ID", "Name", "Cedula" };
        tableModel = new DefaultTableModel(coluString, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userTable = new JTable(tableModel);
        JScrollPane tableScrollPanel = new JScrollPane(userTable);

        JButton backButton = new JButton("Back to Main Menu");

        backButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainView.showScreen("Primary");
                }
            }
        );

        add(titleLabel, BorderLayout.NORTH);
        add(tableScrollPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        loadAndDisplayUsers();
    }

    private void loadAndDisplayUsers() {
        List<Persona> personas = userController.getAll(); // Get data from your controller

        // Clear existing rows from the table model
        tableModel.setRowCount(0);

        // Add new rows to the table model
        for (Persona persona : personas) {
            // Create a data row - Adjust these calls based on your Persona class methods
            Object[] rowData = {
                persona.getId(),
                persona.getNombre(),
                persona.getCedula(),
                /* Replace with your name method */
            };
            tableModel.addRow(rowData);
        }
    }
}
