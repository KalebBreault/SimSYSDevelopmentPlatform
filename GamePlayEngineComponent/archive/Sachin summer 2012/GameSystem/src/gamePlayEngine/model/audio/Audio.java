/*
 * Derived Model class for Audio deriving from GameElement
 */
package gamePlayEngine.model.audio;

import gamePlayEngine.model.gameElement.GameElement;

public class Audio extends GameElement {
	public void end() {
		// State modification if any
		setChanged();
		notifyObservers(this);
	}

	public void start() {
		// State modification if any
		setChanged();
		notifyObservers(this);
	}

	public void update() {
		// State modification
		setChanged();
		notifyObservers(this);
	}

}
