package models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField textUsername;
    private JPasswordField textPassword;
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
        textUsername = new JTextField();
        textUsername.setPreferredSize(new Dimension(150, 25));
        textPassword = new JPasswordField();
        textPassword.setPreferredSize(new Dimension(150, 25));
        btnLogin = new JButton("Login");

        // Adiciona os componentes na janela com posicionamento centralizado
        gbc.gridx = 0;
        gbc.gridy = 0;
        window.add(labelUsername, gbc);

        gbc.gridx = 1;
        window.add(textUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        window.add(labelPassword, gbc);

        gbc.gridx = 1;
        window.add(textPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        window.add(btnLogin, gbc);

        // Adiciona o ActionListener ao botão
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém os valores dos campos de texto
                String username = textUsername.getText();
                String password = new String(textPassword.getPassword());

                // Verifica o login
                Connection conn = ConnectionDB.connect();
                if (conn != null) {
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;
                    try {
                        String query = "SELECT username, password FROM public.\"HRuser\" WHERE username = ?";
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, username);
                        rs = pstmt.executeQuery();

                        if (rs.next()) {
                            String dbUsername = rs.getString("username");
                            String dbPassword = rs.getString("password");

                            if (dbUsername.equals(username) && dbPassword.equals(password)) {
                                switchToStayScreen();  // Troca a tela se o login for válido
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid username or password");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao executar consulta: " + ex.getMessage());
                    } finally {
                        try {
                            if (rs != null) rs.close();
                            if (pstmt != null) pstmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        // Configurações da janela
        setSize(400, 300); // Defina o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    // Método para transição da tela de login para a tela de Stay
    private void switchToStayScreen() {
        getContentPane().removeAll(); // Remove todos os componentes da tela atual
        Stay stay = new Stay(this);   // Passa o frame atual para o Stay
        stay.windowStay();            // Exibe a tela Stay
        revalidate();                 // Revalida ao layout
        repaint();                    // Redesenha a janela
    }
}
