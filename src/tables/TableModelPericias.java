package tables;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import player.Pericia;
import player.Player;
import player.observer.Observer;


public class TableModelPericias extends AbstractTableModel implements Observer{
	private static final long serialVersionUID = 1L;
	
	private String[] col = {"Nome", "Valor", "Mod", "Grad"};
	
	public TableModelPericias(){}
	
	@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		if(columnIndex < 3 || rowIndex >= Player.shared.pericias.size()){
			return false;
		}
		
        return true;
    }

	@Override
	public int getRowCount() {
		return Player.shared.pericias.size() + 1;
	}

	@Override
	public int getColumnCount() {
		return col.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object returnValue = null;
		
		if (rowIndex >= Player.shared.pericias.size()){
			switch (columnIndex) {
			case 2:
				return "TOTAL";
			
			case 3:
				int sum = 0;
				
				for (int i = 0; i < Player.shared.pericias.size(); i++){
					sum += Player.shared.pericias.get(i).getGraduacao();
				}
				
				return sum;

			default:
				return ""; 
			}
		}
		
		Pericia p = Player.shared.pericias.get(rowIndex);
		

		switch (columnIndex) {
		case 0:
			returnValue = p.nome + " (" + p.atribute + ")";
			break;
		case 1:
			returnValue = p.getValue();
			break;
		case 2:
			if (p.modificador() >= 0){
				returnValue = "+" + String.valueOf(p.modificador());
			}else{
				returnValue = String.valueOf(p.modificador());
			}
			break;
		case 3:
			returnValue = String.valueOf(p.getGraduacao());
			break;
		}
		
		
		return returnValue;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pericia p = Player.shared.pericias.get(rowIndex);
		
		if (columnIndex == 3 && aValue instanceof String){
			String g = (String) aValue;
			int val = Integer.parseInt(g);
			if (val >= 0){
				p.setGraduacao(val);
			}
		}
		
		this.fireTableDataChanged();
    }

	@Override
	public void update(Player player) {
		//System.out.println("Updating table!");
		this.fireTableDataChanged();
	}
	
	

}
