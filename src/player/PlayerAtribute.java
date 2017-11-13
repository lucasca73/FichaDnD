package player;



public class PlayerAtribute {

	public String nome;
	public int valor = 0;
	public int temporary = 0;
	
	
	static PlayerAtribute padrao(String nome){
		
		PlayerAtribute atr = new PlayerAtribute();
		atr.nome = nome;
		atr.valor = 10;
		
		return atr;
	}
	
	public int mod(){
		
		double result = ((valor - 10.0)/2.0);
		
		result = Math.floor(result);
		
		return (int) result + temporary;
	}
	
}
