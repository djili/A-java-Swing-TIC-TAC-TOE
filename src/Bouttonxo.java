import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Bouttonxo extends JButton implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static byte valeur=0;
	private boolean touch=false;
	private  static boolean fin=false;
	private int posx=0,posy=0;
	private static byte tour=0;
	private Graphics paintContour;
	ImageIcon x,o;
	private static int[][] mat=new int[3][3];
	public static byte getTour(){
		return tour;
	}
	public Bouttonxo(int i,int j){
		x=new ImageIcon(this.getClass().getResource("x.png"));
		o=new ImageIcon(this.getClass().getResource("o.png"));
		posx=i;posy=j;
		this.setOpaque(false);
		this.addActionListener(this);
		this.setVisible(true);
		switch(i){
		case 0:
			switch(j){
			case 1:
				this.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
				break;
			default:
				this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
				break;
			}
			break;
		case 2:
			switch(j){
			case 1:
				this.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
				break;
			default:
				this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
				break;
			}
			break;	
		case 1:
			switch(j){
			case 1:
				this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
				break;
			default:
				this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
				break;
			}
			break;	
		}	
        this.setContentAreaFilled(false);
        this.setOpaque(false);
	}	
	private void jeu(int choix){
	   mat[posx][posy]=choix;
	}
	private void check(){
		for(int i=0;i<3;i++){
			if(mat[i][0]==1 && mat[i][1]==1 && mat[i][2]==1 || mat[0][i]==1 && mat[1][i]==1 && mat[2][i]==1 ){
				Fin win=new Fin("O a gagné");
				fin=true;
				break;
			}else if(mat[i][0]==2 && mat[i][1]==2 && mat[i][2]==2 || mat[0][i]==2 && mat[1][i]==2 && mat[2][i]==2 ){
				Fin win=new Fin("X a gagné");
				fin=true;
				break;
			}
		}
		if(mat[0][0]==2 && mat[2][2]==2 && mat[1][1]==2 || mat[0][2]==2 && mat[1][1]==2 && mat[2][0]==2 ){
			Fin win=new Fin("X a gagné");
			fin=true;
		}else if(mat[0][0]==1 && mat[2][2]==1 && mat[1][1]==1 || mat[0][2]==1 && mat[1][1]==1 && mat[2][0]==1 ){
			Fin win=new Fin("O a gagné");
			fin=true;
		}
		if(tour==9 && !fin){
			Fin win=new Fin("Match null");
			fin=true;
		}
	}
	public void actionPerformed(ActionEvent e){
		if(!touch && !fin){
		valeur++;
		tour++;
		if(valeur==3)
			valeur=1;
			switch(valeur){
			case 1:
				this.setIcon(x);
				jeu(2);
				break;
			case 2:
				this.setIcon(o);
				jeu(1);
				break;	
			}
			check();
		}
		touch=true;
	}
}
