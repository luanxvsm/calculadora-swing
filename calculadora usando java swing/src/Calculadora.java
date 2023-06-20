import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora extends JFrame{
    public Calculadora(){
        super("Calculadora"); // Titulo da painel principal

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,350); //Setando o tamanho do painel principal
        setLocation(400,200); //setando a localização do painel dentro da tela do usuario

        setLayout(new BorderLayout());
        TextPanel textPanel = new TextPanel(); //implementando o painel de texto no painel princiaal
        add(BorderLayout.NORTH, textPanel);

        JPanel digitsPanel = new JPanel(); //deixando a caixa de texto digitavel
        digitsPanel.setLayout(new BorderLayout());
        digitsPanel.add(BorderLayout.CENTER, new NumberPanel(textPanel.getTxtNumber()));
        digitsPanel.add(BorderLayout.EAST, new OperationsPanel(textPanel.getTxtNumber()));
        add(BorderLayout.CENTER, digitsPanel); 
        
        setVisible(true); //deixando o texto visivel
    }
    public static void main(String[] args) throws Exception{
        new Calculadora(); //implementando a main pra rodar o codigo
    }
}
