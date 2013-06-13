/**
 * Act model class - Contains one or more scenes and is contained in Game
 * This file defines the Act model class
 */
package gamePlayEngine.model.act;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.scene.Scene;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Act Model class. This class is observed by the view for any updates.
 *
 */
public class Act extends Observable {
	private List<Scene> scenes;
	private int currentScene = 0;

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		for (Scene scene : scenes) {
			scene.addObserver(o);
		}
	}

	public void setScenes(List<Scene> scenes) {
		this.scenes = scenes;
	}

	public List<Scene> getScenes() {
		return scenes;
	}

	public void start() {
		// Handle Act specific activities in complex games
		setChanged();
		notifyObservers(Message.Start);
	}

	/**
	 * Go through each Scene and start, play and end it
	 * If the process was to become any complex it can be moved to ActControl similar to GameControl
	 */
	public void play() {
		setChanged();
		notifyObservers(Message.Play);
		while (currentScene < scenes.size()) {
			Scene sceneToPlay = scenes.get(currentScene);
			sceneToPlay.start();
			sceneToPlay.play();
			sceneToPlay.end();			
			currentScene += 1;
		}
	}

	public void end() {
		// Handle Act specific cleanups in complex games
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
