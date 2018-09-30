package tableau;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ComboRenderer extends JComboBox implements TableCellRenderer {
	 
	   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
	       
	      this.addItem("Très bien");
	      this.addItem("Bien");
	      this.addItem("Mal");
	      return this;
	   }
}