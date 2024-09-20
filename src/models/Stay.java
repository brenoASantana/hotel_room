package models;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Stay extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel labelRoomNumber;
    private JLabel labelStartDate;
    private JLabel labelFinalDate;
    private JFormattedTextField jFormattedTextRoomNumber;
    private JFormattedTextField jFormattedTextStartDate;
    private JFormattedTextField jFormattedTextFinalDate;
    private JButton btnSubmit;
    private JFrame parentFrame;

    // Construtor que recebe o frame pai
    public Stay(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void windowStay() {
        parentFrame.setTitle("Stay Screen");

        Container window = parentFrame.getContentPane();
        window.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

        // Definindo os rótulos e campos de texto
        labelRoomNumber = new JLabel("Room Number:");
        labelStartDate = new JLabel("Start Date:");
        labelFinalDate = new JLabel("Final Date:");

        MaskFormatter mascaraRoomNumber = createMaskFormatter("####");
        MaskFormatter mascaraStartDate = createMaskFormatter("##/##/####");
        MaskFormatter mascaraFinalDate = createMaskFormatter("##/##/####");

        jFormattedTextRoomNumber = new JFormattedTextField(mascaraRoomNumber);
        jFormattedTextRoomNumber.setPreferredSize(new Dimension(100, 25));
        jFormattedTextStartDate = new JFormattedTextField(mascaraStartDate);
        jFormattedTextStartDate.setPreferredSize(new Dimension(100, 25));
        jFormattedTextFinalDate = new JFormattedTextField(mascaraFinalDate);
        jFormattedTextFinalDate.setPreferredSize(new Dimension(100, 25));

        btnSubmit = new JButton("Enviar");

        // Posicionando os componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        window.add(labelRoomNumber, gbc);

        gbc.gridx = 1;
        window.add(jFormattedTextRoomNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        window.add(labelStartDate, gbc);

        gbc.gridx = 1;
        window.add(jFormattedTextStartDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        window.add(labelFinalDate, gbc);

        gbc.gridx = 1;
        window.add(jFormattedTextFinalDate, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        window.add(btnSubmit, gbc);

        // Adicionando ação ao botão
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = jFormattedTextRoomNumber.getText();
                String startDate = jFormattedTextStartDate.getText();
                String finalDate = jFormattedTextFinalDate.getText();

                // Criando o pop-up com os dados
                String message = String.format("Room Number: %s\nStart Date: %s\nFinal Date: %s", 
                                                roomNumber, startDate, finalDate);
                JOptionPane.showMessageDialog(null, message, "Dados Enviados", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private MaskFormatter createMaskFormatter(String mask) {
        try {
            MaskFormatter formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter('_');
            return formatter;
        } catch (ParseException e) {
            System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
            return null;
        }
    }
}
