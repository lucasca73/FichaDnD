package player.observer;

import java.util.EventListener;

public interface CellListener extends EventListener {
	public void cellTextChanged(int row, int col, String text);
}
