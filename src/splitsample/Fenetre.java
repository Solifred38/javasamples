package splitsample;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Fenetre extends JFrame {

  private JSplitPane split, split2, split3;

  public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneur");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(200, 200);

    //On crée deux conteneurs de couleurs différentes
    JPanel pan = new JPanel();
    pan.setBackground(Color.blue);      
    JPanel pan2 = new JPanel();
    pan2.setBackground(Color.red);
    JPanel pan3 = new JPanel();
    pan3.setBackground(Color.orange);
    JPanel pan4 = new JPanel();
    pan4.setBackground(Color.YELLOW);
    //On construit enfin notre séparateur
    split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan, pan4);
    //On place le premier séparateur
    split.setDividerLocation(80);
    split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan3, pan2);
    //On place le deuxième séparateur
    split2.setDividerLocation(100);
    //On passe les deux précédents JSplitPane à celui-ci
    split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, split, split2);
    //On place le troisième séparateur
    split3.setDividerLocation(80);

    //On le passe ensuite au content pane de notre objet Fenetre
    //placé au centre pour qu'il utilise tout l'espace disponible
    this.getContentPane().add(split3, BorderLayout.CENTER);
    this.setVisible(true);
  }
   
  public static void main(String[] args){
    Fenetre fen = new Fenetre();
  }   
}