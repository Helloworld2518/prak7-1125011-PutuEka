package minggu.Pages;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import minggu.Controller.Controller;
import minggu.Model.UserModel;

public class Login {
    public static void main(String[] args) {
        String appName = "Praktikum Minggu 7";
        int width = 600;
        int height = 400;

        JFrame frame = new JFrame(appName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Controller controller = new Controller(new UserModel());

        CardLayout card = new CardLayout();
        frame.setLayout(card);

        JPanel panelLogin = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel usernameText = new JLabel("Username: ");
        JTextField userInput = new JTextField();

        JLabel passwordText = new JLabel("Password: ");
        JPasswordField password = new JPasswordField();

        JButton login = new JButton("Login");

        panelLogin.add(usernameText);
        panelLogin.add(userInput);
        panelLogin.add(passwordText);
        panelLogin.add(password);
        panelLogin.add(login);

        JPanel panelRegister = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel regisUserText = new JLabel("Username: ");
        JTextField userRegis = new JTextField();

        JLabel regisPasswordText = new JLabel("Password: ");
        JPasswordField passwordRegis = new JPasswordField();

        JButton register = new JButton("Register");

        panelRegister.add(regisUserText);
        panelRegister.add(userRegis);
        panelRegister.add(regisPasswordText);
        panelRegister.add(passwordRegis);
        panelRegister.add(register);

        frame.add(panelLogin, "Login");
        frame.add(panelRegister, "Register");

        card.show(frame.getContentPane(), "Register");

        register.addActionListener(e -> {
            String username = userRegis.getText();
            String pass = new String(passwordRegis.getPassword());

            controller.register(username, pass);

            card.show(frame.getContentPane(), "Login");

        });

        login.addActionListener(e -> {
            String user = userInput.getText();
            String pass = new String(password.getPassword());

            boolean cek = controller.isValid(user, pass);

            if (cek) {
                card.show(frame.getContentPane(), "Main Menu");
                JPanel mainApp = new JPanel();
                JLabel greeting = new JLabel("Hello " + user);

                mainApp.add(greeting);
                frame.add(mainApp, "Main Menu");

            } else {
                JDialog dialog = new JDialog(frame, "Invalid User", true);
                dialog.setSize(200, 150);
                dialog.add(new JLabel("Invalid Username or Password"));
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });

        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
