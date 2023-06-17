import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperationsPanel extends JPanel implements ActionListener{

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
        this.txtText = txtText;

        setLayout(new GridLayout(3,2));

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
    public void actionPerformed(ActionEvent e) {
        if(txtText.getText().isEmpty()){
            return;
        }

        JButton btn = (JButton) e.getSource();

        if(btn == btnClear){
            op = '\u0000';
            txtText.setText("");
        } else if(btn == btnRes){
            valor2 = Double.parseDouble(txtText.getText());

            double result = 0.0;
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
            valor1 = Double.parseDouble(txtText.getText());
            txtText.setText("");
        }
    }
}
