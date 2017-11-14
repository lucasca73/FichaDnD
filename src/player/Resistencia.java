package player;

public class Resistencia {

	public String name;
	public String atribute;
	private int classPoints = 0;
	
	public Resistencia(String name, String atr){
		this.name = name;
		this.atribute = atr;
	}
	
	public void setClassValue(int value){
		this.classPoints = value;
		Player.shared.warnObservers();
	}
	
	public int getValue(){
		return this.getMod() + classPoints;
	}
	
	public int getMod(){
		
		Object d = Player.shared.getData(atribute);
		if ( d instanceof PlayerAtribute){
			PlayerAtribute atr = (PlayerAtribute) d;
			return atr.mod();
		}
		
		return 0;
	}
	
}
