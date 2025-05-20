package application;

import javax.swing.SwingUtilities;

import views.MainView;

public class MainClass {

    public static void main(String[] args) {
        new MainView();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView view = new MainView();
                view.setVisible(true);
            }
        });
    }
}
