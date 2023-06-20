import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel{
    private JTextField txtNumber; //setando o txt
    public TextPanel(){
        setLayout(new FlowLayout());

        txtNumber = new JTextField(28); //o tamanho da caixa de texto
        txtNumber.setHorizontalAlignment(JTextField.RIGHT); //a posicao da caixa de texto
        txtNumber.setEnabled(false); 
        add(txtNumber);
    }
    public JTextField getTxtNumber() {
        return txtNumber;
    }
}
