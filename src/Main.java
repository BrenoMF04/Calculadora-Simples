import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField campo1, campo2, resultado;
    private JButton btnSomar, btnSubtrair, btnMultiplicar, btnDividir, btnIgual, btnLimpar;
    private char operacao;

    public Main() {
        setTitle("Calculadora Simples");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        Dimension tamanhoCampo = new Dimension(120, 30);

        campo1 = new JTextField();
        campo1.setPreferredSize(tamanhoCampo);
        campo2 = new JTextField();
        campo2.setPreferredSize(tamanhoCampo);

        add(campo1);
        add(campo2);

        resultado = new JTextField();
        resultado.setPreferredSize(new Dimension(260, 30));
        resultado.setEditable(false);
        add(resultado);

        JPanel painelBotoes = new JPanel(new GridLayout(3, 2, 10, 10));

        Dimension tamanhoBotao = new Dimension(80, 50);
        Font fonteBotao = new Font("Arial", Font.BOLD, 18);

        btnSomar = new JButton("+");
        btnSomar.setPreferredSize(tamanhoBotao);
        btnSomar.setFont(fonteBotao);

        btnSubtrair = new JButton("-");
        btnSubtrair.setPreferredSize(tamanhoBotao);
        btnSubtrair.setFont(fonteBotao);

        btnMultiplicar = new JButton("*");
        btnMultiplicar.setPreferredSize(tamanhoBotao);
        btnMultiplicar.setFont(fonteBotao);

        btnDividir = new JButton("/");
        btnDividir.setPreferredSize(tamanhoBotao);
        btnDividir.setFont(fonteBotao);

        btnIgual = new JButton("=");
        btnIgual.setPreferredSize(tamanhoBotao);
        btnIgual.setFont(fonteBotao);

        btnLimpar = new JButton("C");
        btnLimpar.setPreferredSize(tamanhoBotao);
        btnLimpar.setFont(fonteBotao);

        painelBotoes.add(btnSomar);
        painelBotoes.add(btnSubtrair);
        painelBotoes.add(btnMultiplicar);
        painelBotoes.add(btnDividir);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnIgual);

        add(painelBotoes);

        btnSomar.addActionListener(this);
        btnSubtrair.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);
        btnIgual.addActionListener(this);
        btnLimpar.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnLimpar) {
                campo1.setText("");
                campo2.setText("");
                resultado.setText("");
            } else if (e.getSource() == btnIgual) {
                double num1 = Double.parseDouble(campo1.getText());
                double num2 = Double.parseDouble(campo2.getText());
                double res = 0;

                switch (operacao) {
                    case '+': res = num1 + num2; break;
                    case '-': res = num1 - num2; break;
                    case '*': res = num1 * num2; break;
                    case '/':
                        if (num2 != 0) res = num1 / num2;
                        else resultado.setText("Erro: Divisão por zero");
                        break;
                }
                resultado.setText(String.valueOf(res));
            } else {
                operacao = e.getActionCommand().charAt(0);
            }
        } catch (NumberFormatException ex) {
            resultado.setText("Erro: Número inválido");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}