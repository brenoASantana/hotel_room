package models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel labelUsername;
    private JLabel labelPassword;
    private JFormattedTextField jFormattedTextUsername;
    private JFormattedTextField jFormattedTextPassword;
    private JButton btnLogin;

    public static void main(String[] args) {
        Login windowLogin = new Login();
        windowLogin.windowLogin();
    }

    public void windowLogin() {
        Container window = getContentPane();
        window.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Define os rótulos e campos de texto
        labelUsername = new JLabel("Username: ");
        labelPassword = new JLabel("Password: ");
        jFormattedTextUsername = new JFormattedTextField();
        jFormattedTextUsername.setPreferredSize(new Dimension(150, 25));
        jFormattedTextPassword = new JFormattedTextField();
        jFormattedTextPassword.setPreferredSize(new Dimension(150, 25));
        btnLogin = new JButton("Login");

        // Adiciona os componentes na janela com posicionamento centralizado
        gbc.gridx = 0;
        gbc.gridy = 0;
        window.add(labelUsername, gbc);

        gbc.gridx = 1;
        window.add(jFormattedTextUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        window.add(labelPassword, gbc);

        gbc.gridx = 1;
        window.add(jFormattedTextPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        window.add(btnLogin, gbc);

        // Adiciona o ActionListener ao botão
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém os valores dos campos de texto
                String username = jFormattedTextUsername.getText();
                String password = jFormattedTextPassword.getText();

                // Verifica o login (ajustar conforme necessário)
                if (true) {
                    openNextWindow();
                } else {
                    System.out.println("Invalid username or password");
                }
            }
        });

        // Configurações da janela
        setSize(400, 200); // Defina o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    // Método para abrir a próxima janela
    private void openNextWindow() {
        JFrame nextWindow = new JFrame("Next Window");
        nextWindow.setSize(300, 200);
        nextWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nextWindow.setLocationRelativeTo(null); 
    }
}
