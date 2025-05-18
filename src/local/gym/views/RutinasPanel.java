package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RutinasPanel extends JPanel {

    private MainView mainView;

    public RutinasPanel(MainView mainView) {
        this.mainView = mainView;

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Routine Management");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton backButton = new JButton("Back to Main Menu");

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