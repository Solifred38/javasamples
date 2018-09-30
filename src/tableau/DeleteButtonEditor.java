package tableau;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

//CTRL + SHIFT + O pour g�n�rer les imports
public class DeleteButtonEditor extends DefaultCellEditor {
    
 protected JButton button;
 private DeleteButtonListener bListener = new DeleteButtonListener();
  
 public DeleteButtonEditor(JCheckBox checkBox) {
    //Par d�faut, ce type d'objet travaille avec un JCheckBox
    super(checkBox);
     //On cr�e � nouveau notre bouton
    button = new JButton();
     button.setOpaque(true);
     //On lui attribue un listener
     button.addActionListener((ActionListener) bListener);
 }

 public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    //On d�finit le num�ro de ligne � notre listener
    bListener.setRow(row);
    //On passe aussi en param�tre le tableau pour des actions potentielles
    bListener.setTable(table);
    //On r�affecte le libell� au bouton
    button.setText( (value ==null) ? "" : value.toString() );
    //On renvoie le bouton
     return button;
 }
  
 class DeleteButtonListener implements ActionListener {
       
      private int row;
      private JTable table;
       
      public void setRow(int row){this.row = row;}
      public void setTable(JTable table){this.table = table;}
       
      public void actionPerformed(ActionEvent event) {
       if(table.getRowCount() > 0){
          //On affiche un message mais vous pourriez faire ce que vous voulez
          System.out.println("coucou du bouton : "+ ((JButton)event.getSource()).getText() );
          //On affecte un nouveau libell� � une celulle de la ligne
          ((ZModel)table.getModel()).removeRow(this.row);
           
       }
    }
 }        
}