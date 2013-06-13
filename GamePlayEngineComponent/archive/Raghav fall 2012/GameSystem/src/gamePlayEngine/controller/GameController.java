/**
 *  Controller for Game Play Engine. Receives messages from View and sends to appropriate model boundary for update.
 *  This file contains the Controller class for the Game Play Engine
 */
package gamePlayEngine.controller;

import gamePlayEngine.model.gameElement.player.reward.RewardBoundary;
import gamePlayEngine.model.gamemodel.GameModel;
import gamePlayEngine.model.gamemodel.GameModelBoundary;
import gamePlayEngine.view.GameView;

/**
 * Controller class for Game Play Engine
 */
public class GameController {

	/* Additional Boundary class members are to be added as needed */
	private GameModelBoundary gameBoundary;
	private RewardBoundary rewardBoundary;

	/**
	 * Initializes GameBoundary and RewardBoundary
	 * @param game
	 */
	public GameController(GameModel gameModel, GameView gameView) {
		this.gameBoundary = new GameModelBoundary(gameModel);
		rewardBoundary = new RewardBoundary(gameModel.getCharacter().getReward());		
		this.gameBoundary.addObserver(gameView);
	}

	/**
	 * Core method that processes both internally generated and externally generated messages
	 * Parses the message and then calls appropriate control and action. This method is to be updated to support more games 
	 * with new messages. 
	 * @param messageType
	 * @param message
	 * @throws InterruptedException 
	 */
	public void gcPlay(MessageType messageType, String message) throws InterruptedException {
		if(messageType == MessageType.Internal) {
			// In future add processing for Timer generated internal messages
			// Then parse message parameter to get Control and Action to be called.
			gameBoundary.gmbPlay();
		}
		else if(messageType == MessageType.External) {
			if(message.equals("start")) {
				start();
				gameBoundary.gmbPlay();
				end();
			}
			else if (message.equals("exit")) {
				// Writing following line to console is for demo purpose and should be removed when view is built
				System.out.println("Controller: Received user input to end the game");
				System.exit(0);
			} else {
				// Writing following line to console is for demo purpose and should be removed when view is built
				System.out.println("Controller : Received user input from view " + message);
				String[] input = message.split("[.]");
				if (input[0].equals("Reward") && input[1].equals("AddPoints")) {
					rewardBoundary.adddPoints(Integer.parseInt(input[2]));
				}
			}	
		}
	}

	public void start() {
		gameBoundary.gmbStart();
	}
	
	public void end() {
		gameBoundary.gmbEnd();
	}
}