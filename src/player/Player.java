package player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import player.observer.*;

public class Player {
	
	public static Player shared = new Player();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private HashMap<String, Object> data = new HashMap<String, Object>();
	public ArrayList<Pericia> pericias;
	
	
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
		
		data.put("nome", "");
		data.put("exp", "");
		data.put("classe", 0);
		data.put("nivel", 0);
		data.put("raca", 0);
		data.put("tendencia", "");
		data.put("bonus_base_ataque", 0);
		data.put("ataque1", "");
		data.put("ataque2", "");
		data.put("ataque3", "");
		data.put("ataque4", "");
		data.put("ca", 0);
		data.put("pv_atual", 3);
		data.put("pv_total", 0);
		
		data.put("equipamentos", new ArrayList<String>() );
		data.put("talentos", new ArrayList<String>() );
		data.put("magias", new ArrayList<String>() );
		
		pericias = Pericia.readDefaultFile();
		
		for(Pericia p : pericias){
			data.put(p.nome, 0);
			//System.out.println(p.nome + " valor: " + data.get(p.nome) + data.get(p.nome).getClass() );
		}
		
		// Load stored information
		try {
			this.readState();
		} catch (Exception e) {
			System.out.println("No data found to load");
			//e.printStackTrace();
		}
		
		System.out.println("nome: " + data.get("nome"));
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
				
			} else if (obj instanceof Integer ){ //Updating others
				System.out.println("Integer: " + obj.getClass());
				data.put(name, value);
				
			} else if (obj instanceof String ){ //Updating others
				data.put(name, value);
				
				Object updated = data.get(name);
				if (updated instanceof String && value instanceof String){
					String str = (String) updated;
					String otherStr = (String) value;
					if (str == otherStr){
						System.out.println( obj.getClass().getSimpleName() + " " + name + "updated");
					}
				}
				
			} else {
				System.out.println(obj.getClass());
			}
		}else{
			System.out.println("Could not found data with name: " + name);
		}
		
		try {
			this.saveState();
		} catch (Exception e) {
			e.printStackTrace();
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
		
		for(int i = 0; i < observers.size(); i++){
			observers.get(i).update(this);
		}
	}
	
	
	private void saveState() throws Exception{
		FileOutputStream fout = new FileOutputStream("player_data.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(data);
		
		//System.out.println(data);
	}
	
	private void readState() throws Exception {
		FileInputStream streamIn = new FileInputStream("player_data.dat");
		ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
		HashMap<String, Object> readData = (HashMap<String, Object>) objectinputstream.readObject();
		
		this.data = readData;
		
		//System.out.println(readData);
		//System.out.println(data);
	}
	
	
	private void writeFile(){

		BufferedWriter bw = null;
		FileWriter fw = null;
		String FILENAME = "E:\\test\\filename.txt";


		try {

			String content = "This is the content to write into file\n";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}
