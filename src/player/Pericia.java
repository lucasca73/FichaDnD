package player;


public class Pericia {

	public String nome;
	public String atribute;
	
	private int graduacao = 0;
	public int training = 0;
	public int armorPenalty = 0;
	
	public Pericia(String n, String atr){
		nome = n;
		atribute = atr;
	}
	
	public void setGraduacao(int grad){
		graduacao = grad;
		Player.shared.warnObservers();
	}
	
	public int getGraduacao(){
		return this.graduacao;
	}
	
	public int getValue(){
		return this.graduacao + this.modificador();
	}
	
	public Pericia(String n, String atr, int tr, int apen){
		nome = n;
		atribute = atr;
		training = tr;
		armorPenalty = apen;
	}
	
	public int modificador(){
		
		Object d = Player.shared.getData(this.atribute);
		
		int mod = 0;

		if (d != null){
			
			if (d instanceof PlayerAtribute){
				PlayerAtribute atr = (PlayerAtribute) d;
				mod = atr.mod();
			}
		}
		
		return mod;
	}
	
}
