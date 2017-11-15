package player;

import java.io.IOException;

public class PlayerAtribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.nome);
        stream.writeInt(this.valor);
        stream.writeInt(this.temporary);
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.nome = (String) stream.readObject();
        this.valor = stream.readInt();
        this.temporary = stream.readInt();
    }

    public String toString() {
        return nome + "\t" + valor + "\t" + temporary + "\n";
    }
	
}
