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
		gameModelControl.gmcAddObserver(view);

	}

	public void load(String xmlFilePath) throws Exception {
		gameModelControl.load(xmlFilePath);
	}

	public void gmbStart() {
		gameModelControl.gmcStart();
	}

	public void gmbPlay() throws InterruptedException {
		gameModelControl.gmcPlay();
	}

	public void gmbEnd() {
		gameModelControl.gmcEnd();
	}

	public void gmbPause() {
		throw new UnsupportedOperationException();
	}

	public void gmbResume() {
		throw new UnsupportedOperationException();
	}

	public void gmbSave() {
		throw new UnsupportedOperationException();
	}
}
