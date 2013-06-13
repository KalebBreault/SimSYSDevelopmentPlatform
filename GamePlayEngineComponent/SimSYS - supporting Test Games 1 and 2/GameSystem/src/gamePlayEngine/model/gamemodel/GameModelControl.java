/**
 * Controller class for Game Model - defines process on Game model
 * This file contains the Control class for Game Model
 */
package gamePlayEngine.model.gamemodel;

import gamePlayEngine.view.GameView;

/**
 * GameControl class - mainly defines play process for Game
 */
public class GameModelControl {

	private GameModel gameModel;

	public GameModelControl(GameModel gameModel) {
		this.gameModel = gameModel;
	}
	
	public void gmcAddObserver(GameView view) {
		gameModel.addObserver(view);
	}

	public void load(String xmlFilePath) throws Exception {
		gameModel = GameModel.load(xmlFilePath);
	}

	public void gmcStart() {
		gameModel.gameModelStart();
	}
	
	/**
	 * Game Play process consists of start, play and end 
	 * @throws InterruptedException 
	 */
	public void gmcPlay() throws InterruptedException {
		gameModel.gameModelPlay();
	}

	public void gmcEnd() {
		gameModel.gameModelEnd();
	}

	public void gmcPause() {
		throw new UnsupportedOperationException();
	}

	public void gmcResume() {
		throw new UnsupportedOperationException();
	}

	public void gmcSave() {
		throw new UnsupportedOperationException();
	}
}
