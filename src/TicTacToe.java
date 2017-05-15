import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
public class TicTacToe extends JFrame{
	private JPanel pan;
	private Bouttonxo[][] bouton=new Bouttonxo[3][3];
	public TicTacToe(){
		pan=new JPanel(new GridLayout(3,3));
		this.setTitle("Le jeu du morpion");
		this.setSize(450,450);
		this.setResizable(false);
		for(int x=0;x<3;x++){
			for(int j=0;j<3;j++)
			pan.add(bouton[x][j]=new Bouttonxo(x,j));
		}
		pan.setBackground(Color.WHITE);
		this.add(pan,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
