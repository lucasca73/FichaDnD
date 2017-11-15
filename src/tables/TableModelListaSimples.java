package tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import player.Pericia;
import player.Player;
import player.observer.Observer;

public class TableModelListaSimples extends AbstractTableModel implements Observer{
	private static final long serialVersionUID = 1L;
	
	private String[] col = {"Nome"};
	private String obs_key = "";
	
	public TableModelListaSimples(String key){
		Player.shared.addObserver(this);
		this.obs_key = key;
	}
	
	@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

	@Override
	public int getRowCount() {
		
		Object obj = Player.shared.getData(obs_key);
		
		if (obj instanceof ArrayList<?>){
			ArrayList<String> list = (ArrayList<String>) obj;
			return list.size() + 1;
		}
		
		return 0;
	}

	@Override
	public int getColumnCount() {
		return col.length;
	}
	
	@Override
	public String getColumnName(int column) {
        return col[column];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Object returnValue = null;
		Object obj = Player.shared.getData(obs_key);
		
		if (obj instanceof ArrayList<?>){
			ArrayList<String> list = (ArrayList<String>) obj;
			if (rowIndex < list.size()){
				return list.get(rowIndex);
			}else{
				return "...";
			}
		}
		
		return returnValue;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Object obj = Player.shared.getData(obs_key);
		
		if (obj instanceof ArrayList<?> && aValue instanceof String){
			ArrayList<String> list = (ArrayList<String>) obj;
			String val = (String) aValue;
			
			if(rowIndex < list.size()){
				list.set(rowIndex, val);
			}else{
				list.add(val);
			}
			
			Player.shared.updateData(this.obs_key, list);
			
			System.out.println("Updating list " + this.obs_key );
			
			
		}
		
		this.fireTableDataChanged();
    }

	@Override
	public void update(Player player) {
		//System.out.println("Updating table!");
		this.fireTableDataChanged();
	}
	
	

}
