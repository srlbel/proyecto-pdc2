package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuariosPanel extends JPanel {

    private MainView mainView;

    public UsuariosPanel(MainView mainView) {
        this.mainView = mainView;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("User Management");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JTextArea contentArea = new JTextArea("This is the Usuarios section.\nAdd your user management UI here.");
        contentArea.setEditable(false);

        JButton backButton = new JButton("Back to Main Menu");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.showScreen("Primary");
            }
        });

        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(contentArea), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}