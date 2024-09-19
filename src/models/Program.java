package models;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Program {
    public static void main(String[] args) {
        TestandoJFormattedTextField field = new TestandoJFormattedTextField();
        field.testaJFormattedTextField();
    }
}

class TestandoJFormattedTextField extends JFrame {
    private static final long serialVersionUID = 1L;

    public void testaJFormattedTextField() {
        Container janela = getContentPane();
        setLayout(null);

        
        setTitle("Dados de Estadia");

       
        JLabel labelRoomNumber = new JLabel("Room Number:");
        JLabel labelStartDate = new JLabel("Start Date:");
        JLabel labelFinalDate = new JLabel("Final Date:");
        labelRoomNumber.setBounds(50, 40, 100, 20);
        labelStartDate.setBounds(50, 80, 100, 20);
        labelFinalDate.setBounds(50, 120, 100, 20);
       
    
        JButton btnSubmit = new JButton("Enviar");
        btnSubmit.setBounds(150, 160, 80, 30); // Ajustando a posição do botão
        
   
        MaskFormatter mascaraRoomNumber = createMaskFormatter("####");
        MaskFormatter mascaraStartDate = createMaskFormatter("##/##/####");
        MaskFormatter mascaraFinalDate = createMaskFormatter("##/##/####");

        
        JFormattedTextField jFormattedTextRoomNumber = new JFormattedTextField(mascaraRoomNumber);
        JFormattedTextField jFormattedTextStartDate = new JFormattedTextField(mascaraStartDate);
        JFormattedTextField jFormattedTextFinalDate = new JFormattedTextField(mascaraFinalDate);
        jFormattedTextRoomNumber.setBounds(150, 40, 30, 20);
        jFormattedTextStartDate.setBounds(150, 80, 70, 20);
        jFormattedTextFinalDate.setBounds(150, 120, 70, 20);
        

        
        janela.add(labelRoomNumber);
        janela.add(labelStartDate);
        janela.add(labelFinalDate);
        janela.add(jFormattedTextRoomNumber);
        janela.add(jFormattedTextStartDate);
        janela.add(jFormattedTextFinalDate);
        janela.add(btnSubmit);
    
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
        
        setSize(400, 250); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
