package player;



public class Pericia {

	public String nome;
	public PlayerAtribute atribute;
	
	public int graduacao = 0;
	public int training = 0;
	public int armorPenalty = 0;
	
	public int modificador(){
		return atribute.mod() + this.graduacao;
	}
	
}
