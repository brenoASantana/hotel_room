package models;

import java.awt.Container;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

        // Define os rótulos
        JLabel labelCep = new JLabel("CEP: ");
        JLabel labelTel = new JLabel("Telefone: ");
        JLabel labelCpf = new JLabel("CPF: ");
        JLabel labelData = new JLabel("Data: ");
        labelCep.setBounds(50, 40, 100, 20);
        labelTel.setBounds(50, 80, 100, 20);
        labelCpf.setBounds(50, 120, 100, 20);
        labelData.setBounds(50, 160, 100, 20);

        // Define as máscaras
        MaskFormatter mascaraCep = createMaskFormatter("#####-###");
        MaskFormatter mascaraTel = createMaskFormatter("(##)####-####");
        MaskFormatter mascaraCpf = createMaskFormatter("#########-##");
        MaskFormatter mascaraData = createMaskFormatter("##/##/####");

        // Seta as máscaras nos JFormattedTextField
        JFormattedTextField jFormattedTextCep = new JFormattedTextField(mascaraCep);
        JFormattedTextField jFormattedTextTel = new JFormattedTextField(mascaraTel);
        JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
        JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);
        jFormattedTextCep.setBounds(150, 40, 100, 20);
        jFormattedTextTel.setBounds(150, 80, 100, 20);
        jFormattedTextCpf.setBounds(150, 120, 100, 20);
        jFormattedTextData.setBounds(150, 160, 100, 20);

        // Adiciona os rótulos e campos de texto
        janela.add(labelCep);
        janela.add(labelTel);
        janela.add(labelCpf);
        janela.add(labelData);
        janela.add(jFormattedTextCep);
        janela.add(jFormattedTextTel);
        janela.add(jFormattedTextCpf);
        janela.add(jFormattedTextData);

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
            return null; // Unreachable, but required for compilation
        }
    }
}
