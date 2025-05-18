
package views;

import models.Rutina;
import models.Usuario;
import services.RutinaService;
import services.UsuarioService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class RutinasPanel extends JPanel { // Declaracion de campos 

    private MainView mainView; // para navegar entre pantallas 

    private JTable rutinaTable; //  tabla para mostrar rutnias 

    private JComboBox<Usuario> usuarioComboBox; // menu para selecionar usuarios 

    private JButton asignarButton; // boton para asignar la rutina 

    private RutinaService rutinaService = new RutinaService();
    private UsuarioService usuarioService = new UsuarioService(); // manejan la logica 

    // constructor y layout
    public RutinasPanel(MainView mainView) { // guarda la referencia en  el panel principal 
        this.mainView = mainView;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Routine Management", SwingConstants.CENTER); // da el titulo 
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Tabla de rutinas
        rutinaTable = new JTable(); // muestra datos en filas 
        JScrollPane scrollPane = new JScrollPane(rutinaTable); // desplazamiento vertical como orizontal 
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con combo y botón
        JPanel bottomPanel = new JPanel();  // sub panel controles de abajo 
        bottomPanel.setLayout(new FlowLayout()); // para colocar los componentes de izquierda aderecha 

        usuarioComboBox = new JComboBox<>();
        cargarUsuarios(); // carga una lista con usuaris de usuaris servidor 

        asignarButton = new JButton("Asignar rutina al usuario");
        asignarButton.addActionListener(this::asignarRutinaAUsuario); // llama un metodo cuando se precione 

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> mainView.showScreen("Primary")); // volver al menu 

        bottomPanel.add(new JLabel("Seleccionar Usuario:")); // agrega todos los elementos al panel inferior 
        bottomPanel.add(usuarioComboBox);
        bottomPanel.add(asignarButton);
        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);

        cargarRutinas();
    }
// cargador de rutinas 
    private void cargarRutinas() { // tiene todos las rutinas 
        List<Rutina> rutinas = rutinaService.obtenerTodas(); 
        String[] columnNames = {"ID", "Nombre", "Descripción"}; // define las colubnas para la tabla 
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Rutina rutina : rutinas) {
            model.addRow(new Object[]{rutina.getId(), rutina.getNombre(), rutina.getDescripcion()}); // agrega una rutina a la tabla 
        } // la actualiza 

        rutinaTable.setModel(model);
    }

    private void cargarUsuarios() { // carga el usuario 
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        for (Usuario u : usuarios) {
            usuarioComboBox.addItem(u);
        }
    }

    private void asignarRutinaAUsuario(ActionEvent e) { // asigna la rutina 
        int selectedRow = rutinaTable.getSelectedRow();
        Usuario usuario = (Usuario) usuarioComboBox.getSelectedItem();

        if (selectedRow >= 0 && usuario != null) { // llama al metodo del servicio  para asignar 
            Long rutinaId = (Long) rutinaTable.getValueAt(selectedRow, 0);
            rutinaService.asignarRutinaAUsuario(rutinaId, usuario.getId());
            JOptionPane.showMessageDialog(this, "Rutina asignada con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una rutina y un usuario.");
        }
    }
}
