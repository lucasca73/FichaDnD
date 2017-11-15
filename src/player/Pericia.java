package player;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Pericia {

	public String nome;
	public String atribute;
	
	public int training = 0;
	public int armorPenalty = 0;
	
	public Pericia(String n, String atr){
		nome = n;
		atribute = atr;
	}
	
	public Pericia(String n, String atr, int tr, int apen){
		nome = n;
		atribute = atr;
		training = tr;
		armorPenalty = apen;
	}
	
	public void setGraduacao(int grad){
		//System.out.println("Updating graduation");
		Player.shared.updateData(this.nome, grad);
		Player.shared.warnObservers();
	}
	
	public int getGraduacao(){
		Integer grad = (Integer) Player.shared.getData(this.nome);
		
		//System.out.println(this.nome + grad);
		
		if (grad == null){
			return 0;
		}
		
		return grad;
	}
	
	public int getValue(){
		return this.getGraduacao() + this.modificador();
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
	
	public static java.util.ArrayList<Pericia> readDefaultFile(){
		
		ArrayList<Pericia> ps = new ArrayList<Pericia> ();
		
		Scanner in;
		try {
			in = new Scanner(new FileReader("Pericias.txt"));
			
			StringBuilder sb = new StringBuilder();
			while(in.hasNext()) {
			    sb.append(in.next());
			}
			in.close();
			String outString = sb.toString();
			
			String[] out = outString.split(",");
			
			for(int i = 0; i < out.length; i += 4){
				Pericia p = new Pericia(out[i], out[i+1],Integer.parseInt(out[i+2]), Integer.parseInt(out[i+3]) );
				//System.out.println(p.nome);
				ps.add(p);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
}
