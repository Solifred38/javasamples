package scrollsample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fenetre extends JFrame {

  private JTextArea textPane = new JTextArea();
  private JScrollPane scroll = new JScrollPane(textPane);  
  public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneur");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(200, 200);
      
    JButton bouton =  new JButton("Bouton");
    bouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.out.println("Texte écrit dans le JTextArea : ");
        System.out.println("--------------------------------");
        System.out.println(textPane.getText());            
      }
    });
    //On ajoute l'objet au content pane de notre fenêtre
    this.getContentPane().add(scroll, BorderLayout.CENTER);
    this.getContentPane().add(bouton, BorderLayout.SOUTH);
    this.setVisible(true);
  }
   
  public static void main(String[] args){
    Fenetre fen = new Fenetre();
  }   
}