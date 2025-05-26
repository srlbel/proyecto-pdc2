package views;

import models.Inventario;
import models.Maquina;
import models.Implemento;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InventarioPanel extends JPanel {

    private Inventario inventario;
    private MainView mainView;

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

    public InventarioPanel(MainView mainView, Inventario inventario) {
	this.mainView = mainView;
        this.inventario = inventario;
        setLayout(new BorderLayout());

        JButton backButton = new JButton("Volver al Menú Principal");

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

	backButton.addActionListener(
	    new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        	mainView.showScreen("Primary");
                    }
                });

        implementosPanel.add(implementosInputPanel, BorderLayout.SOUTH);

        // Agregar ambos paneles en el InventarioPanel
        JPanel listasPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        listasPanel.add(maquinasPanel);
        listasPanel.add(implementosPanel);
	listasPanel.add(backButton);

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(fechaStr); // validar formato de fecha
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. Use formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Concatenamos fecha al nombre para que se muestre
        Maquina maquina = new Maquina(0, nombre + " (Mantenimiento: " + fechaStr + ")", "No especificada", false);
        inventario.agregarMaquina(maquina);
        maquinasModel.addElement(maquina);

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

        // Concatenamos cantidad al nombre para que se muestre
        Implemento implemento = new Implemento(0, nombre + " (Cantidad: " + cantidad + ")", "No especificada", cantidad);
        inventario.agregarImplemento(implemento);
        implementosModel.addElement(implemento);

        implementoNombreField.setText("");
        implementoCantidadField.setText("");
    }
}
