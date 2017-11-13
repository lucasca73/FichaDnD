package player;

import java.util.ArrayList;
import player.observer.*;

public class Player {
	
	private ArrayList<Observer> observers = new ArrayList<Observer>(); 

	public PlayerData data;
	private PlayerAtribute[] atributes = {
			PlayerAtribute.padrao("for"),
			PlayerAtribute.padrao("des"),
			PlayerAtribute.padrao("con"),
			PlayerAtribute.padrao("int"),
			PlayerAtribute.padrao("sab"),
			PlayerAtribute.padrao("car")
			};
	
	public ArrayList<Pericia> pericias = PlayerClass.forClassName("");
	
	
	
	public void updateData(String name, int value){
		
		for(int i = 0; i < atributes.length; i++){
			PlayerAtribute atr = atributes[i];
			if(atr.nome == name){
				atr.valor = value;
				warnObservers();
				break;
			}
		}
	}
	
	public PlayerAtribute getAtribute(String name){
		
		for(int i = 0; i < atributes.length; i++){
			PlayerAtribute atr = atributes[i];
			if(atr.nome == name){
				return atr;
			}
		}
		
		return null;
	}
	
	public void addObserver(Observer obs ){
		if (obs != null){
			this.observers.add(obs);
		}
	}
	
	private void warnObservers(){
		for(int i = 0; i < observers.size(); i++){
			observers.get(i).update(this);
		}
	}
	
}
