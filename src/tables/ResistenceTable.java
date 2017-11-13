package tables;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;




public class ResistenceTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 112423L;

	
	public void addDelegate(){
		
		// Listen for changes in the text
		textField.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
		    warn();
		  }
		  public void removeUpdate(DocumentEvent e) {
		    warn();
		  }
		  public void insertUpdate(DocumentEvent e) {
		    warn();
		  }

		  public void warn() {
		     if (Integer.parseInt(textField.getText())<=0){
		       JOptionPane.showMessageDialog(null,
		          "Error: Please enter number bigger than 0", "Error Massage",
		          JOptionPane.ERROR_MESSAGE);
		     }
		  }
		});
	}
}
