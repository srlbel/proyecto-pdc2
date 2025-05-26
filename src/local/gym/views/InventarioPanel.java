package views;

import models.Inventario;
import models.Maquina;
import models.Implemento;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventarioPanel extends JPanel {

    private Inventario inventario;

    private DefaultListModel<Maquina> maquinasModel;
    private JList<Maquina> maquinasList;

    private DefaultListModel<Implemento> implementosModel;
    private JList<Implemento> implementosList;

    // Campos para agregar maquina
    private JTextField maquinaNombreField;
    private JTextField maquinaFechaField; // Formato: dd/MM/yyyy

    // Campos para agregar implemento
    private JTextField implementoNombreField;
    private JTextField implementoCantidadField;

    public InventarioPanel(JFrame parent, Inventario inventario) {
        this.inventario = inventario;
        setLayout(new BorderLayout());

        // Panel para máquinas
        JPanel maquinasPanel = new JPanel(new BorderLayout());
        maquinasPanel.setBorder(new TitledBorder("Máquinas"));

        maquinasModel = new DefaultListModel<>();
        maquinasList = new JList<>(maquinasModel);
        maquinasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollMaquinas = new JScrollPane(maquinasList);
        maquinasPanel.add(scrollMaquinas, BorderLayout.CENTER);

        JPanel maquinasInputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        maquinasInputPanel.add(new JLabel("Nombre:"));
        maquinaNombreField = new JTextField();
        maquinasInputPanel.add(maquinaNombreField);

        maquinasInputPanel.add(new JLabel("Fecha mantenimiento (dd/MM/yyyy):"));
        maquinaFechaField = new JTextField();
        maquinasInputPanel.add(maquinaFechaField);

        JButton agregarMaquinaBtn = new JButton("Agregar Máquina");
        maquinasInputPanel.add(new JLabel()); // espacio vacío
        maquinasInputPanel.add(agregarMaquinaBtn);

        maquinasPanel.add(maquinasInputPanel, BorderLayout.SOUTH);

        // Panel para implementos
        JPanel implementosPanel = new JPanel(new BorderLayout());
        implementosPanel.setBorder(new TitledBorder("Implementos"));

        implementosModel = new DefaultListModel<>();
        implementosList = new JList<>(implementosModel);
        implementosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollImplementos = new JScrollPane(implementosList);
        implementosPanel.add(scrollImplementos, BorderLayout.CENTER);

        JPanel implementosInputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        implementosInputPanel.add(new JLabel("Nombre:"));
        implementoNombreField = new JTextField();
        implementosInputPanel.add(implementoNombreField);

        implementosInputPanel.add(new JLabel("Cantidad:"));
        implementoCantidadField = new JTextField();
        implementosInputPanel.add(implementoCantidadField);

        JButton agregarImplementoBtn = new JButton("Agregar Implemento");
        implementosInputPanel.add(new JLabel()); // espacio vacío
        implementosInputPanel.add(agregarImplementoBtn);

        implementosPanel.add(implementosInputPanel, BorderLayout.SOUTH);

        // Agregar ambos paneles en el InventarioPanel
        JPanel listasPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        listasPanel.add(maquinasPanel);
        listasPanel.add(implementosPanel);

        add(listasPanel, BorderLayout.CENTER);

        // Cargar datos iniciales
        cargarDatos();

        // Eventos botones
        agregarMaquinaBtn.addActionListener(e -> agregarMaquina());
        agregarImplementoBtn.addActionListener(e -> agregarImplemento());
    }

    private void cargarDatos() {
        maquinasModel.clear();
        for (Maquina m : inventario.getMaquinas()) {
            maquinasModel.addElement(m);
        }
        implementosModel.clear();
        for (Implemento i : inventario.getImplementos()) {
            implementosModel.addElement(i);
        }
    }

    private void agregarMaquina() {
        String nombre = maquinaNombreField.getText().trim();
        String fechaStr = maquinaFechaField.getText().trim();

        if (nombre.isEmpty() || fechaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de máquina.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date fechaMantenimiento;
        try {
            fechaMantenimiento = sdf.parse(fechaStr);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. Use formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear máquina con constructor disponible
        Maquina maquina = new Maquina(0, nombre, "No especificada", false);
        inventario.agregarMaquina(maquina);
        maquinasModel.addElement(maquina);

        // Limpiar campos
        maquinaNombreField.setText("");
        maquinaFechaField.setText("");
    }

    private void agregarImplemento() {
        String nombre = implementoNombreField.getText().trim();
        String cantidadStr = implementoCantidadField.getText().trim();

        if (nombre.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de implemento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Implemento implemento = new Implemento(0, nombre, "No especificada", cantidad);
        inventario.agregarImplemento(implemento);
        implementosModel.addElement(implemento);

        // Limpiar campos
        implementoNombreField.setText("");
        implementoCantidadField.setText("");
    }
}