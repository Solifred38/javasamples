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

public class Fenetre extends JFrame {
	 
	   private JTable tableau;
	   private JButton change = new JButton("Changer la taille");
	   private String[] comboData = {"Très bien", "Bien", "Mal"};
	   private String supp = "Supprimer la ligne";
	   private JComboBox combo;
	    
	   public Fenetre(){
	      this.setLocationRelativeTo(null);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setTitle("JTable");
	      this.setSize(600, 250);
	      this.createContent();
	   }
	    
	   private void createContent(){
	      //Données de notre tableau
	      Object[][] data = {  
	         {"Cysboy", "6boy", comboData[0], new Boolean(true), supp},
	         {"BZHHydde", "BZH", comboData[0], new Boolean(false), supp},
	         {"IamBow", "BoW", comboData[0], new Boolean(false), supp},
	         {"FunMan", "Year", comboData[0], new Boolean(true), supp}
	      };
	 
	      String  title[] = {"Pseudo", "Age", "Taille", "OK ?", "Suppression"};
	      combo = new JComboBox(comboData);
	       
	      //Notre modèle d'affichage spécifique destiné à pallier
	      //les bugs d'affichage !
	      ZModel zModel = new ZModel(data, title);
	       
	      this.tableau = new JTable(zModel);     
	      this.tableau.setRowHeight(30);
	      this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
	      this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
	       
	      //On définit l'éditeur par défaut pour la cellule
	      //en lui spécifiant quel type d'affichage prendre en compte
	      this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
	      DefaultTableCellRenderer dcr = new DefaultTableCellRenderer();
	      this.tableau.getColumn("Taille").setCellRenderer(dcr);
	       
	      //On définit un éditeur pour la colonne "supprimer"
	      this.tableau.getColumn("Suppression").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
	       
	      //On ajoute le tableau
	      this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	       
	      JButton ajouter = new JButton("Ajouter une ligne");
	      ajouter.addActionListener(new MoreListener());
	      this.getContentPane().add(ajouter, BorderLayout.SOUTH);
	   }     
	    
	   class MoreListener implements ActionListener{
	      public void actionPerformed(ActionEvent event) {
	         Object[] donnee = new Object[]
	            {"Angelo", "Rennais", comboData[0], new Boolean(false), supp};
	         ((ZModel)tableau.getModel()).addRow(donnee);
	      }
	   }
	       
	   public static void main(String[] args){
	      Fenetre fen = new Fenetre();
	      fen.setVisible(true);
	   }
	}