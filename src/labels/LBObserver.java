package labels;

import javax.swing.JLabel;

import player.Player;
import player.PlayerAtribute;
import player.Resistencia;
import player.observer.Observer;

public class LBObserver extends JLabel implements Observer{
	
	private static final long serialVersionUID = 1L;
	public String obs_key = "";

	public LBObserver(String text){
		super(text);
	}
	
	@Override
	public void update(Player player) {
		
		Object d = player.getData(obs_key);
		
		if (d != null){
		
			if (d instanceof Resistencia){
				
				Resistencia res = (Resistencia) d;
				this.setText(String.valueOf( res.getValue() ));
			}
			
			if (d instanceof PlayerAtribute){
				PlayerAtribute atr = (PlayerAtribute) d;

				if (atr.mod() >= 0){
					this.setText(String.valueOf("+" + atr.mod() ));
				}else{
					this.setText(String.valueOf( atr.mod() ));
				}
			}
		}
	}


}
