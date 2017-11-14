package player;



public class PlayerAtribute {

	public String nome;
	private int valor = 0;
	public int temporary = 0;
	
	
	static PlayerAtribute padrao(String nome){
		
		PlayerAtribute atr = new PlayerAtribute();
		atr.nome = nome;
		atr.valor = 10;
		
		return atr;
	}
	
	public int getValue(){
		return valor;
	}
	
	public void setValue(int value){
		this.valor = value;
		Player.shared.warnObservers();
	}
	
	public int mod(){
		
		double result = ((valor - 10.0)/2.0);
		
		result = Math.floor(result);
		
		return (int) result + temporary;
	}
	
}
