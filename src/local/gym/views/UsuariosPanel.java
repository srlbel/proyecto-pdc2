package views;

import controllers.UserController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Cliente;
import models.Persona;
import models.Rutina;

public class UsuariosPanel extends JPanel {

    private MainView mainView;
    private UserController userController;
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UsuariosPanel(MainView mainView, UserController userController) {
        this.mainView = mainView;
        this.userController = userController;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Clientes");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        String[] columnString = { "ID", "Nombre", "Telefono", "Cedula", "Email", "Mensualidad", "Dia Renovación",
                "Ha Pagado" };
        tableModel = new DefaultTableModel(columnString, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        userTable = new JTable(tableModel);
        JScrollPane tableScrollPanel = new JScrollPane(userTable);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton createButton = new JButton("Crear Usuario");
        JButton deleteButton = new JButton("Borrar Usuario");
        JButton updateButton = new JButton("Actualizar Usuario");
        JButton verRutinasButton = new JButton("Ver rutinas");
        JButton backButton = new JButton("Back to Main Menu");

        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(verRutinasButton);
        buttonPanel.add(backButton);

        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainView.showScreen("Primary");
                    }
                });

        createButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createNewUser();
                    }
                });

        verRutinasButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // manageUserRutinas();
                    }
                });

        deleteButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteUser();
                    }
                });

        updateButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateUser();
                    }
                });

        add(titleLabel, BorderLayout.NORTH);
        add(tableScrollPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loadAndDisplayUsers();
    }

    private void createNewUser() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField cedulaField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField mensualidadField = new JTextField();
        JTextField diaRenovacionField = new JTextField();
        JCheckBox haPagadoCheckBox = new JCheckBox("Ha pagado", false);

        Object[] message = {
                "ID", idField,
                "Name: ", nameField,
                "Phone: ", phoneField,
                "Cedula: ", cedulaField,
                "Email: ", emailField,
                "Mensualidad: ", mensualidadField,
                "Día Renovación", diaRenovacionField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Crear Cliente Nuevo", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String idStr = idField.getText().trim();
            String name = nameField.getText().trim();
            String telefono = phoneField.getText().trim();
            String cedula = cedulaField.getText().trim();
            String email = emailField.getText().trim();
            String mensualidadStr = mensualidadField.getText().trim();
            String diaRenovacionStr = diaRenovacionField.getText().trim();
            boolean haPagado = haPagadoCheckBox.isSelected();

            if (idStr.isEmpty()
                    || name.isEmpty()
                    || telefono.isEmpty()
                    || cedula.isEmpty()
                    || email.isEmpty()
                    || mensualidadStr.isEmpty()
                    || diaRenovacionStr.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "All fields must be filled.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                double mensualidad = Double.parseDouble(mensualidadStr);
                int diaRenovacion = Integer.parseInt(diaRenovacionStr);

                boolean success = userController.createCliente(
                        id,
                        name,
                        telefono,
                        cedula,
                        email,
                        mensualidad,
                        diaRenovacion,
                        haPagado);

                if (success) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Client created successfully.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    loadAndDisplayUsers();
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Failed to create client.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Formato invalido", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteUser() {
        int selectedRow = userTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a client to delete.",
                    "No Client Selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int userId = (int) tableModel.getValueAt(selectedRow, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete the selected client?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = userController.delete(userId);

            if (success) {
                JOptionPane.showMessageDialog(
                        this,
                        "Client deleted successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                loadAndDisplayUsers();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Failed to delete client.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateUser() {
        int selectedRow = userTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a client to update.",
                    "No Client Selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int clientId = (int) tableModel.getValueAt(selectedRow, 0);
        String currentName = (String) tableModel.getValueAt(selectedRow, 1);
        String currentTelefono = (String) tableModel.getValueAt(selectedRow, 2);
        String currentCedula = (String) tableModel.getValueAt(selectedRow, 3);
        String currentEmail = (String) tableModel.getValueAt(selectedRow, 4);
        double currentMensualidad = (double) tableModel.getValueAt(selectedRow, 5);
        int currentDiaRenovacion = (int) tableModel.getValueAt(selectedRow, 6);
        boolean currentHaPagado = tableModel.getValueAt(selectedRow, 7).equals("Yes");

        JTextField nameField = new JTextField(currentName);
        JTextField phoneField = new JTextField(currentTelefono);
        JTextField cedulaField = new JTextField(currentCedula);
        JTextField emailField = new JTextField(currentEmail);
        JTextField mensualidadField = new JTextField(String.valueOf(currentMensualidad));
        JTextField diaRenovacionField = new JTextField(String.valueOf(currentDiaRenovacion));
        JCheckBox haPagadoCheckBox = new JCheckBox("Paid", currentHaPagado);

        Object[] message = {
                "Name:", nameField,
                "Phone:", phoneField,
                "Cedula:", cedulaField,
                "Email:", emailField,
                "Monthly Fee:", mensualidadField,
                "Renewal Day:", diaRenovacionField,
                haPagadoCheckBox
        };

        int option = JOptionPane.showConfirmDialog(
                this,
                message,
                "Update Client", // Updated title
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String newName = nameField.getText().trim();
            String newTelefono = phoneField.getText().trim();
            String newCedula = cedulaField.getText().trim();
            String newEmail = emailField.getText().trim();
            String newMensualidadStr = mensualidadField.getText().trim();
            String newDiaRenovacionStr = diaRenovacionField.getText().trim();
            boolean newHaPagado = haPagadoCheckBox.isSelected();

            if (newName.isEmpty()
                    || newTelefono.isEmpty()
                    || newCedula.isEmpty()
                    || newEmail.isEmpty()
                    || newMensualidadStr.isEmpty()
                    || newDiaRenovacionStr.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "All fields must be filled.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double newMensualidad = Double.parseDouble(newMensualidadStr);
                int newDiaRenovacion = Integer.parseInt(newDiaRenovacionStr);

                Cliente newClient = new Cliente(clientId, newDiaRenovacionStr, newTelefono, newCedula, newEmail,
                        newMensualidad, newDiaRenovacion, newHaPagado, null);

                Cliente success = userController.update(
                        clientId,
                        newClient);

                if (success.equals(newClient)) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Client updated successfully.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    loadAndDisplayUsers();
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Failed to update client.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid number format for Monthly Fee or Renewal Day.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadAndDisplayUsers() {
        List<Cliente> personas = userController.getAll();

        tableModel.setRowCount(0);

        for (Cliente persona : personas) {
            Object[] rowData = {
                    persona.getId(),
                    persona.getNombre(),
                    persona.getTelefono(),
                    persona.getCedula(),
                    persona.getEmail(),
                    persona.getMensualidad(),
                    persona.getDiaRenovacion(),
                    persona.getHaPagado() ? "Sí" : "No"
            };
            tableModel.addRow(rowData);
        }
    }
}
