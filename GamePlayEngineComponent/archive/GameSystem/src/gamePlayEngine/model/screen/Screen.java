/**
 * Screen model class. Screen contains one or more Game Elements and is contained in Scene
 */
package gamePlayEngine.model.screen;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.gameElement.GameElement;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.bind.annotation.XmlElement;

public class Screen extends Observable {

	private List<GameElement> gameElements;
	private int currentGameElement = 0;

	@XmlElement(name = "gameElement")
	public List<GameElement> getGameElements() {
		return gameElements;
	}

	public void setGameElements(List<GameElement> gameElements) {
		this.gameElements = gameElements;
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);		
		for (GameElement gameElement : gameElements) {
			gameElement.addObserver(o);
		}
	}

	public void screenStart() {
		// Handle Screen specific activities in complex games
		setChanged();
		notifyObservers(Message.Start);
	}

	/**
	 * Go through each GameElement and start, play and end it
	 * If the process was to become any complex it can be moved to ScreenControl similar to GameControl
	 */
	public void screenPlay() {
		setChanged();
		notifyObservers(Message.Play);
		while (currentGameElement < gameElements.size()) {
			GameElement gameElementToPlay = gameElements.get(currentGameElement);
			gameElementToPlay.gameElementStart();
			gameElementToPlay.gameElementPlay();
			gameElementToPlay.gameElementEnd();			
			currentGameElement += 1;
		}
	}
	
	public void screenEnd() {
		// Handle Screen specific cleanups in complex games
		setChanged();
		notifyObservers(Message.End);
	}
	
	public void screenPause() {
		throw new UnsupportedOperationException();
	}

	public void screenResume() {
		throw new UnsupportedOperationException();
	}

	public void screenSave() {
		throw new UnsupportedOperationException();
	}


}
