package labels;

import javax.swing.JComboBox;

import player.Player;
import player.observer.Observer;

public class CBObserver extends JComboBox<String> implements Observer{
	
	private static final long serialVersionUID = 1L;
	public String obs_key = "";

	public CBObserver(){
	}
	
	@Override
	public void update(Player player) {
		
		Object d = player.getData(obs_key);
		
		if (d != null){
		
			if (d instanceof Integer){
				this.setSelectedIndex( (Integer) d);
			}
			
		}
	}
}
