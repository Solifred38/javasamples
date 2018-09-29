package tableau;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//CTRL + SHIFT + O pour générer les imports
public class Fenetre extends JFrame {

private JTable tableau;
private JButton change = new JButton("Changer la taille");

public Fenetre(){
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("JTable");
  this.setSize(600, 140);

  Object[][] data = {   
    {"Cysboy", new JButton("6boy"), new Double(1.80), new Boolean(true)},
    {"BZHHydde", new JButton("BZH"), new Double(1.78), new Boolean(false)},
    {"IamBow", new JButton("BoW"), new Double(1.90), new Boolean(false)},
    {"FunMan", new JButton("Year"), new Double(1.85), new Boolean(true)}
  };

  String  title[] = {"Pseudo", "Age", "Taille", "OK ?"};

  ZModel model = new ZModel(data, title);
  System.out.println("Nombre de colonne : " + model.getColumnCount());
  System.out.println("Nombre de ligne : " + model.getRowCount());
  this.tableau = new JTable(model);
  this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);      
}

//Classe modèle personnalisée
class ZModel extends AbstractTableModel{
  private Object[][] data;
  private String[] title;

  //Constructeur
  public ZModel(Object[][] data, String[] title){
    this.data = data;
    this.title = title;
  }

  //Retourne le nombre de colonnes
  public int getColumnCount() {
    return this.title.length;
  }

  //Retourne le nombre de lignes
  public int getRowCount() {
    return this.data.length;
  }

  //Retourne la valeur à l'emplacement spécifié
  public Object getValueAt(int row, int col) {
    return this.data[row][col];
  }            
}

public static void main(String[] args){
  Fenetre fen = new Fenetre();
  fen.setVisible(true);
}
}