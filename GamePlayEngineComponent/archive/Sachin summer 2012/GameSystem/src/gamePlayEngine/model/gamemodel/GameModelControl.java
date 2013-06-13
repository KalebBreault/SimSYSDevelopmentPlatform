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
	
	public void addObserver(GameView view) {
		gameModel.addObserver(view);
	}

	public void load(String xmlFilePath) throws Exception {
		gameModel = GameModel.load(xmlFilePath);
	}

	public void start() {
		gameModel.start();
	}
	
	/**
	 * Game Play process consists of start, play and end 
	 */
	public void play() {
		gameModel.play();
	}

	public void end() {
		gameModel.end();
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

	public GameModel getGame() {
		return gameModel;
	}

}
