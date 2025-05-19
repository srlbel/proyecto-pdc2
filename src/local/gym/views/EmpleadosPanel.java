package views;

import controllers.EmpleadoController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.Entrenador;
import models.Turno;

public class EmpleadosPanel extends JPanel {

    private MainView mainView;
    private EmpleadoController empleadoController;
    private JTable entrenadorTable;
    private DefaultTableModel tableModel;

    public EmpleadosPanel(MainView mainView, EmpleadoController empleadoController) {
        this.mainView = mainView;
        this.empleadoController = empleadoController;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Entrenadores");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        String[] columnString = { "ID", "Nombre", "Telefono", "Cedula", "Email", "Salario", "Turno" };
        tableModel = new DefaultTableModel(columnString, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        entrenadorTable = new JTable(tableModel);
        JScrollPane tableScrollPanel = new JScrollPane(entrenadorTable);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton createButton = new JButton("Crear Entrenador");
        JButton deleteButton = new JButton("Borrar Entrenador");
        JButton updateButton = new JButton("Actualizar Entrenador");
        JButton backButton = new JButton("Volver al Menú Principal");

        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);

        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainView.showScreen("Primary"); // Assuming "Primary" is your main menu panel key
                    }
                });

        createButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createNewEntrenador();
                    }
                });

        deleteButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteEntrenador();
                    }
                });

        updateButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateEntrenador();
                    }
                });

        add(titleLabel, BorderLayout.NORTH);
        add(tableScrollPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loadAndDisplayEntrenadores();
    }

    private void createNewEntrenador() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField cedulaField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField salarioField = new JTextField();
        JComboBox<Turno> turnoComboBox = new JComboBox<>(Turno.values());

        Object[] message = {
                "ID:", idField,
                "Nombre:", nameField,
                "Telefono:", phoneField,
                "Cedula:", cedulaField,
                "Email:", emailField,
                "Salario:", salarioField,
                "Turno:", turnoComboBox
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Crear Nuevo Entrenador",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String idStr = idField.getText().trim();
            String name = nameField.getText().trim();
            String telefono = phoneField.getText().trim();
            String cedula = cedulaField.getText().trim();
            String email = emailField.getText().trim();
            String salarioStr = salarioField.getText().trim();
            Turno turno = (Turno) turnoComboBox.getSelectedItem();

            if (idStr.isEmpty()
                    || name.isEmpty()
                    || telefono.isEmpty()
                    || cedula.isEmpty()
                    || email.isEmpty()
                    || salarioStr.isEmpty()
                    || turno == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Todos los campos deben ser llenados.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                double salario = Double.parseDouble(salarioStr);

                boolean success = empleadoController.createEntrenador(
                        id,
                        name,
                        telefono,
                        cedula,
                        email,
                        salario,
                        turno);

                if (success) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Entrenador creado exitosamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    loadAndDisplayEntrenadores();
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Error al crear el entrenador.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Formato de número inválido para el ID o Salario.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteEntrenador() {
        int selectedRow = entrenadorTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecciona un entrenador para borrar.",
                    "Ningún Entrenador Seleccionado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int entrenadorId = (int) tableModel.getValueAt(selectedRow, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres borrar el entrenador seleccionado?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = empleadoController.delete(entrenadorId);

            if (success) {
                JOptionPane.showMessageDialog(
                        this,
                        "Entrenador borrado exitosamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                loadAndDisplayEntrenadores();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Error al borrar el entrenador.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateEntrenador() {
        int selectedRow = entrenadorTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecciona un entrenador para actualizar.",
                    "Ningún Entrenador Seleccionado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int entrenadorId = (int) tableModel.getValueAt(selectedRow, 0);
        String currentName = (String) tableModel.getValueAt(selectedRow, 1);
        String currentTelefono = (String) tableModel.getValueAt(selectedRow, 2);
        String currentCedula = (String) tableModel.getValueAt(selectedRow, 3);
        String currentEmail = (String) tableModel.getValueAt(selectedRow, 4);
        double currentSalario = (double) tableModel.getValueAt(selectedRow, 5);
        Turno currentTurno = (Turno) tableModel.getValueAt(selectedRow, 6);

        JTextField nameField = new JTextField(currentName);
        JTextField phoneField = new JTextField(currentTelefono);
        JTextField cedulaField = new JTextField(currentCedula);
        JTextField emailField = new JTextField(currentEmail);
        JTextField salarioField = new JTextField(String.valueOf(currentSalario));
        JComboBox<Turno> turnoComboBox = new JComboBox<>(Turno.values());
        turnoComboBox.setSelectedItem(currentTurno);

        Object[] message = {
                "Nombre:", nameField,
                "Telefono:", phoneField,
                "Cedula:", cedulaField,
                "Email:", emailField,
                "Salario:", salarioField,
                "Turno:", turnoComboBox
        };

        int option = JOptionPane.showConfirmDialog(
                this,
                message,
                "Actualizar Entrenador",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String newName = nameField.getText().trim();
            String newTelefono = phoneField.getText().trim();
            String newCedula = cedulaField.getText().trim();
            String newEmail = emailField.getText().trim();
            String newSalarioStr = salarioField.getText().trim();
            Turno newTurno = (Turno) turnoComboBox.getSelectedItem();

            if (newName.isEmpty()
                    || newTelefono.isEmpty()
                    || newCedula.isEmpty()
                    || newEmail.isEmpty()
                    || newSalarioStr.isEmpty()
                    || newTurno == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Todos los campos deben ser llenados.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double newSalario = Double.parseDouble(newSalarioStr);

                Entrenador updatedEntrenador = new Entrenador(
                        entrenadorId,
                        newName,
                        newTelefono,
                        newCedula,
                        newEmail,
                        newSalario,
                        newTurno);

                Entrenador success = empleadoController.update(entrenadorId, updatedEntrenador);

                if (success != null) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Entrenador actualizado exitosamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    loadAndDisplayEntrenadores();
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Error al actualizar el entrenador.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Formato de número inválido para el Salario.",
                        "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadAndDisplayEntrenadores() {
        List<Entrenador> entrenadores = empleadoController.getAll();

        tableModel.setRowCount(0);

        for (Entrenador entrenador : entrenadores) {
            Object[] rowData = {
                    entrenador.getId(),
                    entrenador.getNombre(),
                    entrenador.getTelefono(),
                    entrenador.getCedula(),
                    entrenador.getEmail(),
                    entrenador.getSalario(),
                    entrenador.getTurno()
            };
            tableModel.addRow(rowData);
        }
    }
}
