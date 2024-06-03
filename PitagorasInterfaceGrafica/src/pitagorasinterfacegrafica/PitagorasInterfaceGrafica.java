// Programa para calcular a hipotenusa usando o Teorema de Pitágoras
package pitagorasinterfacegrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PitagorasInterfaceGrafica extends JFrame {

    // componentes da interface grafica
    private JLabel labelA, labelB, labelResult;
    private JTextField textA, textB, textResult;
    private JButton buttonCalcular;

    // Construtor da classe
    public PitagorasInterfaceGrafica() { // Nome do construtor alterado
        super("Teorema de Pitágoras");

        // inicializaçao dos componentes
        inicializarComponentes();
        
        // configuraçao do layout
        configurarLayout();
        
        // adiçao dos componentes a interface
        adicionarComponentes();
        
        // adiçao de eventos aos jbuttons
        adicionarEventos();

        // Configuração do tamanho e visibilidade da janela
        setSize(400, 400);
        setLocationRelativeTo(null); // centraliza a janela na tela
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha o programa ao clicar no X
    }

    // Método para inicializar os componentes da interface
    private void inicializarComponentes() {
        labelA = new JLabel("Digite o valor de A:");
        labelB = new JLabel("Digite o valor de B:");
        labelResult = new JLabel("A hipotenusa é:");

        textA = new JTextField(5);
        textB = new JTextField(5);
        textResult = new JTextField(5);

        buttonCalcular = new JButton("Calcular");
    }

    // Metodo para configurar o layout da interface
    private void configurarLayout() {
        Container tela = getContentPane();
        tela.setLayout(null); // Desativa o layout automatico para permitir posicionamento absoluto
        tela.setBackground(new Color(120, 120, 120)); // Define a cor de fundo da tela

        // Posicionamento dos componentes na tela
        labelA.setBounds(20, 20, 150, 25);
        textA.setBounds(170, 20, 30, 25);

        labelB.setBounds(20, 60, 150, 25);
        textB.setBounds(170, 60, 30, 25);

        buttonCalcular.setBounds(60, 100, 90, 25);

        labelResult.setBounds(20, 140, 150, 25);
        textResult.setBounds(170, 140, 60, 25);
    }

    // Método para adicionar os componentes à interface
    private void adicionarComponentes() {
        Container tela = getContentPane();

        tela.add(labelA);
        tela.add(textA);
        tela.add(labelB);
        tela.add(textB);
        tela.add(buttonCalcular);
        tela.add(labelResult);
        tela.add(textResult);
    }

    // Método para adicionar eventos aos botões
    private void adicionarEventos() {
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularHipotenusa();
            }
        });
    }

    // Método para calcular a hipotenusa e exibir o resultado
    private void calcularHipotenusa() {
        try {
            // Obtenção dos valores dos catetos A e B
            double catetoA = Double.parseDouble(textA.getText());
            double catetoB = Double.parseDouble(textB.getText());

            // Cálculo da hipotenusa utilizando o Teorema de Pitágoras
            double hipotenusa = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
            
            // Exibição do resultado formatado na caixa de texto
            textResult.setText(String.format("%.2f", hipotenusa));
        } catch (NumberFormatException ex) {
            // Exibição de mensagem de erro caso valores inválidos sejam inseridos
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal
    public static void main(String[] args) {
        new PitagorasInterfaceGrafica();
    }
}
