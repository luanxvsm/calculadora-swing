import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperationsPanel extends JPanel implements ActionListener{

    //setando variaveis

    private JTextField txtText;
    private char op;
    private double valor1;
    private double valor2;
    private JButton btnSoma;
    private JButton btnSub;
    private JButton btnMulti;
    private JButton btnDiv;
    private JButton btnRes;
    private JButton btnClear;

    public OperationsPanel(JTextField txtText){
        this.txtText = txtText; //setando o txt do painel de operações 

        setLayout(new GridLayout(3,2)); //setando o formato da grade de botoes de operacoes

        //Adicionando os botoes de operacoes

        btnSoma = new JButton("+");
        btnSoma.addActionListener(this);
        add(btnSoma);

        btnSub = new JButton("-");
        btnSub.addActionListener(this);
        add(btnSub);

        btnMulti = new JButton("X");
        btnMulti.addActionListener(this);
        add(btnMulti);

        btnDiv = new JButton("/");
        btnDiv.addActionListener(this);
        add(btnDiv);

        btnRes = new JButton("=");
        btnRes.addActionListener(this);
        add(btnRes);

        btnClear = new JButton("C");
        btnClear.addActionListener(this);
        add(btnClear);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Action performed pra realizar as operacoes
        if(txtText.getText().isEmpty()){ //if para se o valor for vazio ele limpar a operacao
            return;
        }

        JButton btn = (JButton) e.getSource();

        if(btn == btnClear){ // Implementando o botao de limpar 
            op = '\u0000';
            txtText.setText("");
        } else if(btn == btnRes){ //comecando o if para fazer as operacoes
            try { //try catch para mostrar uma mensagem de erro se tiver string na caixa de texto
                valor2 = Double.parseDouble(txtText.getText());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erro operaçao invalida.");
            }

            double result = 0.0;

            //implementando as operacoes
            if(op == '+'){
                result = valor1 + valor2;
            } else if(op == '-'){
                result = valor1 - valor2;
            } else if(op == 'X'){
                result = valor1 * valor2;
            } else if(op == '/'){
                result = valor1 / valor2; 
            }

            txtText.setText(String.valueOf(result));
            op = '\u0000';
            valor1 = result;
            valor2 = 0;
        } else{
            op = btn.getText().charAt(0);
            try { //try catch para mostrar uma mensagem de erro se tiver string na caixa de texto
                valor2 = Double.parseDouble(txtText.getText());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Erro operaçao invalida.");
            }
            txtText.setText("");
        }
    }
}
