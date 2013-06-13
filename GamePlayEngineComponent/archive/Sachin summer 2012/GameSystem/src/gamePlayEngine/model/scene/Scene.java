/**
 * Scene model class. Scene contains one or more screens and Backdrop and is contained in Act
 * This file defines Scene Model class
 */
package gamePlayEngine.model.scene;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.gameElement.graphic.Graphic;
import gamePlayEngine.model.screen.Screen;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.bind.annotation.XmlElement;

/**
 * Scene Model class. This class is observed by the view for any updates.
 *
 */
public class Scene extends Observable {
	private List<Screen> screens;
	private Graphic backdrop;
	private int currentScreen = 0;

	@XmlElement(name = "screen")
	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	@XmlElement(name = "gameElement")
	public Graphic getBackdrop() {
		return backdrop;
	}

	public void setBackdrop(Graphic backdrop) {
		this.backdrop = backdrop;
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		for (Screen screen : screens) {
			screen.addObserver(o);
		}
		backdrop.addObserver(o);
	}
	
	public void start() {
		setChanged();
		notifyObservers(Message.Start);
		backdrop.start();
	}

	/**
	 * Go through each Screen and start, play and end it
	 * If the process was to become any complex it can be moved to SceneControl similar to GameControl
	 */
	public void play() {
		setChanged();
		notifyObservers(Message.Play);
		backdrop.play();
		while (currentScreen < screens.size()) {
			Screen screenToPlay = screens.get(currentScreen);
			screenToPlay.start();
			screenToPlay.play();
			screenToPlay.end();			
			currentScreen += 1;
		}
	}
	
	public void end() {
		backdrop.end();
		setChanged();
		notifyObservers(Message.End);
	}
	
	public void pause() {
		throw new UnsupportedOperationException();
	}

	public void resume() {
		throw new UnsupportedOperationException();
	}

	public void save() {
		throw new UnsupportedOperationException();
	}
}
