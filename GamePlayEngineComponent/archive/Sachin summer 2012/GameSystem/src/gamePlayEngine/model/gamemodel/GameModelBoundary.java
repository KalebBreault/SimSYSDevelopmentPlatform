/**
 * This file contains the Boundary class for Game Model. All messages flow through this boundary
 */
package gamePlayEngine.model.gamemodel;

import gamePlayEngine.view.GameView;

/**
 * Boundary class for the Game
 */
public class GameModelBoundary {

	private GameModelControl gameModelControl;

	public GameModelBoundary(GameModel gameModel) {
		gameModelControl = new GameModelControl(gameModel);
	}

	public void addObserver(GameView view) {
		gameModelControl.addObserver(view);

	}

	public void load(String xmlFilePath) throws Exception {
		gameModelControl.load(xmlFilePath);
	}

	public void start() {
		gameModelControl.start();
	}

	public void play() {
		gameModelControl.play();
	}

	public void end() {
		gameModelControl.end();
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
