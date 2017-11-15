package labels;


import javax.swing.JTextField;
import player.Player;
import player.PlayerAtribute;
import player.Resistencia;



public class TFObserver extends JTextField implements player.observer.Observer {

	private static final long serialVersionUID = 1L;
	public String obs_key = "";

	@Override
	public void update(Player player) {
		
		Object d = player.getData(obs_key);
		
		if (d != null){
		
			if (d instanceof Resistencia){
				Resistencia res = (Resistencia) d;
				this.setText(String.valueOf( res.getClassValue() ));
			}
			
			if (d instanceof PlayerAtribute){
				PlayerAtribute atr = (PlayerAtribute) d;
				this.setText(String.valueOf( atr.getValue() ));
			}
		}
	}
}
