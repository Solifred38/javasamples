package tableau;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

//CTRL + SHIFT + O pour générer les imports
public class Fenetre extends JFrame {

private JTable tableau;
private JButton change = new JButton("Changer la taille");
//Contenu de notre combo
private String[] comboData = {"Très bien", "Bien", "Mal"};

public Fenetre(){
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("JTable");
  this.setSize(600, 180);
  //Données de notre tableau
  Object[][] data = {   
    {"Cysboy", "6boy", comboData[0], new Boolean(true)},
    {"BZHHydde", "BZH", comboData[0], new Boolean(false)},
    {"IamBow", "BoW", comboData[0], new Boolean(false)},
    {"FunMan", "Year", comboData[0], new Boolean(true)}
  };
  //Titre du tableau
  String  title[] = {"Pseudo", "Age", "Taille", "OK ?"};
  //Combo à utiliser
  JComboBox combo = new JComboBox(comboData);

  this.tableau = new JTable(data, title);      
  this.tableau.setRowHeight(30);
  this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
  this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
  //On définit l'éditeur par défaut pour la cellule en lui spécifiant quel type d'affichage prendre en compte
  this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
  this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
}
public class ButtonRenderer extends JButton implements TableCellRenderer{

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
	    //On écrit dans le bouton ce que contient la cellule
	    setText((value != null) ? value.toString() : "");
	    //On retourne notre bouton
	    return this;
	  }
	}
public class ButtonEditor extends DefaultCellEditor {

	  protected JButton button;
	  private boolean   isPushed;
	  private ButtonListener bListener = new ButtonListener();
	   
	  //Constructeur avec une CheckBox
	  public ButtonEditor(JCheckBox checkBox) {
	    //Par défaut, ce type d'objet travaille avec un JCheckBox
	    super(checkBox);
	    //On crée à nouveau un bouton
	    button = new JButton();
	    button.setOpaque(true);
	    //On lui attribue un listener
	    button.addActionListener(bListener);
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) { 
	    //On précise le numéro de ligne à notre listener
	    bListener.setRow(row);
	    //Idem pour le numéro de colonne
	    bListener.setColumn(column);
	    //On passe aussi le tableau en paramètre pour des actions potentielles
	    bListener.setTable(table);
	      
	    //On réaffecte le libellé au bouton
	    button.setText( (value == null) ? "" : value.toString() );
	    //On renvoie le bouton
	    return button;
	  }
	   
	  //Notre listener pour le bouton
	  class ButtonListener implements ActionListener{        
	    private int column, row;
	    private JTable table;
	    private int nbre = 0;
	        
	    public void setColumn(int col){this.column = col;}
	    public void setRow(int row){this.row = row;}
	    public void setTable(JTable table){this.table = table;}
	        
	    public void actionPerformed(ActionEvent event) {
	      //On affiche un message, mais vous pourriez effectuer les traitements que vous voulez
	      System.out.println("coucou du bouton : " + ((JButton)event.getSource()).getText());
	      //On affecte un nouveau libellé à une autre cellule de la ligne
	      table.setValueAt("New Value " + (++nbre), this.row, (this.column -1));
	    }
	  }     
	}
public static void main(String[] args){
  Fenetre fen = new Fenetre();
  fen.setVisible(true);
}
}