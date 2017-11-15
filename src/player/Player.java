package player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import player.observer.*;

public class Player {
	
	public static Player shared = new Player();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private HashMap<String, Object> data = new HashMap<String, Object>();
	public ArrayList<Pericia> pericias = PlayerClass.forClassName("");
	
	
	public Player(){
		data.put("for", PlayerAtribute.padrao("for"));
		data.put("des", PlayerAtribute.padrao("des"));
		data.put("con", PlayerAtribute.padrao("con"));
		data.put("int", PlayerAtribute.padrao("int"));
		data.put("sab", PlayerAtribute.padrao("sab"));
		data.put("car", PlayerAtribute.padrao("car"));
		
		data.put("fortitude", new Resistencia("fortitude", "con"));
		data.put("reflexos", new Resistencia("reflexos", "des"));
		data.put("vontade", new Resistencia("vontade", "sab"));
		
		
		// Load stored information
		try {
			this.readState();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateData(String name, Object value){
		
		Object obj = data.get(name);
		
		if(obj != null){
			
			if( obj instanceof PlayerAtribute ){ //Updating atribute
				PlayerAtribute atr = (PlayerAtribute) obj;
				atr.setValue((int) value);
				
			
			} else if (obj instanceof Resistencia ){ //Updating resistence
				Resistencia res = (Resistencia) obj;
				res.setClassValue((int) value); 
			}
		}
	
	}
	
	public Object getData(String name){
		return data.get(name);
	}
	
	public void addObserver(Observer obs ){
		if (obs != null){
			this.observers.add(obs);
		}
	}
	
	public void addObserver(Observer obs, boolean justRead ){
		if(justRead){
			obs.update(this);
		}
	}
	
	public void warnObservers(){
		
		try {
			this.saveState();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < observers.size(); i++){
			observers.get(i).update(this);
		}
	}
	
	
	private void saveState() throws Exception{
		FileOutputStream fout = new FileOutputStream("player_data.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(data);
		
		System.out.println(data);
	}
	
	private void readState() throws Exception {
		FileInputStream streamIn = new FileInputStream("player_data.dat");
		ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
		HashMap<String, Object> readData = (HashMap<String, Object>) objectinputstream.readObject();
		
		this.data = readData;
		
		//System.out.println(readData);
		System.out.println(data);
	}
}
