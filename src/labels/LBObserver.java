package labels;

import javax.swing.JLabel;

import player.Player;
import player.PlayerAtribute;
import player.observer.Observer;

public class LBObserver extends JLabel implements Observer{
	
	private static final long serialVersionUID = 1L;
	public String obs_key = "";

	public LBObserver(String text){
		super(text);
	}
	
	@Override
	public void update(Player player) {
		PlayerAtribute atr = player.getAtribute(this.obs_key);
		if (atr != null){
			this.setText(String.valueOf( atr.mod() ));
		}
	}


}
