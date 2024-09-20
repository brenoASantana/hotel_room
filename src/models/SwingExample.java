package models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Conexão");
        JButton button = new JButton("Buscar Dados");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = ConnectionDB.connect();
                if (conn != null) {
                    try {
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM sua_tabela");
                        
                        while (rs.next()) {
                            System.out.println("Dado: " + rs.getString("sua_coluna"));
                        }
                    } catch (SQLException ex) {
                        System.out.println("Erro ao executar consulta: " + ex.getMessage());
                    } finally {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
