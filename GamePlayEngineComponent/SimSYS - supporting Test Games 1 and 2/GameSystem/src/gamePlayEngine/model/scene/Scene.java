/**
 * Scene model class. Scene contains one or more screens and Backdrop and is contained in Act
 * This file defines Scene Model class
 */
package gamePlayEngine.model.scene;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.gameElement.GameElement;
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
	private GameElement identifier;
	private GameElement backdrop;
	private int currentScreen = 0;

	@XmlElement(name = "screenStructure")
	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	@XmlElement(name = "gameElement")
	public GameElement getBackdrop() {
		return backdrop;
	}

	public void setBackdrop(GameElement backdrop) {
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
	
	public void sceneStart() throws InterruptedException {
		setChanged();
		notifyObservers(Message.Start);
		backdrop.gameElementStart();
		//Thread.sleep(5000);
	}

	/**
	 * Go through each Screen and start, play and end it
	 * If the process was to become any complex it can be moved to SceneControl similar to GameControl
	 */
	public void scenePlay() {
		setChanged();
		notifyObservers(Message.Play);
		backdrop.gameElementPlay();
		System.out.println("screens-size"+screens.size());
		while (currentScreen < screens.size()) {
			Screen screenToPlay = screens.get(currentScreen);
			screenToPlay.screenStart();
			screenToPlay.screenPlay();
			screenToPlay.screenEnd();			
			currentScreen += 1;
		}
	}
	
	public void sceneEnd() {
		backdrop.gameElementEnd();
		setChanged();
		notifyObservers(Message.End);
	}
	
	public void scenePause() {
		throw new UnsupportedOperationException();
	}

	public void sceneResume() {
		throw new UnsupportedOperationException();
	}

	public void sceneSave() {
		throw new UnsupportedOperationException();
	}
}
