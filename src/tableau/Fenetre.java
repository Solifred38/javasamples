package tableau;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//CTRL + SHIFT + O pour g�n�rer les imports
public class Fenetre extends JFrame {

	private JTable tableau;
	private JButton change = new JButton("Changer la taille");

	public Fenetre() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable");
		this.setSize(600, 140);

		Object[][] data = { { "Cysboy", new JButton("6boy"), new Double(1.80), new Boolean(true) },
				{ "BZHHydde", new JButton("BZH"), new Double(1.78), new Boolean(false) },
				{ "IamBow", new JButton("BoW"), new Double(1.90), new Boolean(false) },
				{ "FunMan", new JButton("Year"), new Double(1.85), new Boolean(true) } };

		String title[] = { "Pseudo", "Age", "Taille", "OK ?" };

		ZModel model = new ZModel(data, title);
		System.out.println("Nombre de colonne : " + model.getColumnCount());
		System.out.println("Nombre de ligne : " + model.getRowCount());
		this.tableau = new JTable(model);
		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	}

//Classe mod�le personnalis�e
	class ZModel extends AbstractTableModel {
		private Object[][] data;
		private String[] title;

		// Constructeur
		public ZModel(Object[][] data, String[] title) {
			this.data = data;
			this.title = title;
		}

		// Retourne le nombre de colonnes
		public int getColumnCount() {
			return this.title.length;
		}

		// Retourne le nombre de lignes
		public int getRowCount() {
			return this.data.length;
		}

		// Retourne la valeur � l'emplacement sp�cifi�
		public Object getValueAt(int row, int col) {
			return this.data[row][col];
		}

		public String getColumnName(int col) {

			return this.title[col];

		}

		// Retourne la classe de la donn�e de la colonne
		public Class getColumnClass(int col) {
			// On retourne le type de la cellule � la colonne demand�e
			// On se moque de la ligne puisque les types de donn�es sont les m�mes quelle
			// que soit la ligne
			// On choisit donc la premi�re ligne
			return this.data[0][col].getClass();
		}

		// Retourne vrai si la cellule est �ditable : celle-ci sera donc �ditable
		public boolean isCellEditable(int row, int col) {
			// On appelle la m�thode getValueAt qui retourne la valeur d'une cellule
			// Et on effectue un traitement sp�cifique si c'est un JButton
			if (getValueAt(row, col) instanceof JButton)
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
	}
}