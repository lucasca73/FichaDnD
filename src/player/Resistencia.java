package player;

import java.io.IOException;

public class Resistencia implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	public int getClassValue(){
		return this.classPoints;
	}
	
	public int getMod(){
		
		Object d = Player.shared.getData(atribute);
		if ( d instanceof PlayerAtribute){
			PlayerAtribute atr = (PlayerAtribute) d;
			return atr.mod();
		}
		
		return 0;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.name);
        stream.writeObject(this.atribute);
        stream.writeInt(this.classPoints);
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        this.name = (String) stream.readObject();
        this.atribute = (String) stream.readObject();
        this.classPoints = stream.readInt();
    }

    public String toString() {
        return name + "\t" + atribute + "\t" + classPoints + "\n";
    }
	
}
