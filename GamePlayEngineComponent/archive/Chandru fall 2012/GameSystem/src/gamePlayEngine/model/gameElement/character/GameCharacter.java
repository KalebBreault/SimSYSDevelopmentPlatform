/**
 * GameCharacter model - Contains Reward and is contained in Game. Servers as a base class to Player and NonPlayer
 * This file contains an implementation of it.
 */
package gamePlayEngine.model.gameElement.character;

import gamePlayEngine.model.gameElement.GameElement;
import gamePlayEngine.model.gameElement.player.Player;
import gamePlayEngine.model.gameElement.player.reward.Reward;

import java.util.Observer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ Player.class, NonPlayer.class })
public class GameCharacter extends GameElement {

	private Reward reward;

	@XmlElement(name = "reward")
	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}
	
	@Override
	public synchronized void addObserver(Observer observer) {
		super.addObserver(observer);
		reward.addObserver(observer);
	}

	/**
	 * Default Implementation for classes that do not override this method
	 */
	public void start() {		
	}

	/**
	 * Default Implementation for classes that do not override this method
	 */
	public void play() {
	}

	/**
	 * Default Implementation for classes that do not override this method
	 */
	public void end() {		
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
