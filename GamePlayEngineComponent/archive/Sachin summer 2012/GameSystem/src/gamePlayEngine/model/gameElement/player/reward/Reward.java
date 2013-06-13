/**
 * Reward model for GameCharacter
 */
package gamePlayEngine.model.gameElement.player.reward;

import gamePlayEngine.controller.Message;

import java.util.Observable;

public class Reward extends Observable {
	private int certificates;
	private int hint;
	private String modifier;
	private int points;
	private int promotions;
	private int trophies;

	public int getCertificates() {
		return certificates;
	}

	public int getHint() {
		return hint;
	}

	public String getModifier() {
		return modifier;
	}

	public int getPoints() {
		return points;
	}

	public int getPromotions() {
		return promotions;
	}

	public int getTrophies() {
		return trophies;
	}

	public void load() {
		points = 1000;
	}

	public void setCertificates(int certificates) {
		this.certificates = certificates;
	}

	public void setHint(int hint) {
		this.hint = hint;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setPromotions(int promotions) {
		this.promotions = promotions;
	}

	public void setTrophies(int trophies) {
		this.trophies = trophies;
	}

	public void addPoints(int points) {
		this.points += points;
		System.out.println("Model Reward Updated");
		setChanged();
		notifyObservers(Message.Play);
	}
}
