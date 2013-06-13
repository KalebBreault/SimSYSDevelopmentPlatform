/**
 * Game model class - Game contains acts and character
 * This file defines Game model class
 */
package gamePlayEngine.model.gamemodel;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.act.Act;
import gamePlayEngine.model.gameElement.character.GameCharacter;

import java.io.File;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Game model class is being observed by view
 *
 */
@XmlRootElement(name = "game")

    

public class GameModel extends Observable {

	private List<Act> acts;
	private int currentAct = 0; // keeps track of current Act that is being processed.
	private GameCharacter character;	

	/**
	 * Private Constructor prohibits Game object construction. It must be unmarshalled from Game XML.
	 */
	private GameModel() {
	}

	/**
	 * Unmarshalls Game XML to create Game object
	 * @param xmlFilePath
	 * @return
	 * @throws Exception
	 */
	public static GameModel load(String xmlFilePath) throws Exception {
		try {
			// Load Game from XML
			JAXBContext context = JAXBContext.newInstance(GameModel.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (GameModel) unmarshaller.unmarshal(new File(xmlFilePath));
		} catch (Exception ex) {
			// log the exception, show the error message on UI
			System.out.println(ex.getMessage());
			throw ex;
		}
	}

	 @XmlElement(name = "actStructure")
	public List<Act> getActs() {
		return acts;
	}

	public void setActs(List<Act> acts) {
		this.acts = acts;
	}

	@XmlElement(name = "gameElement")
	public GameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(GameCharacter character) {
		this.character = character;
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		for (Act act : acts) {
			act.addObserver(o);
		}
		character.addObserver(o);
	}

	public void gameModelStart() {
		// Handle Game specific initializations if any for complex games
		setChanged();
		notifyObservers(Message.Start);
	}

	/**
	 * Game Play method goes through each of the contained acts and plays those.
	 * @throws InterruptedException 
	 */
	public void gameModelPlay() throws InterruptedException {
		setChanged();
		notifyObservers(Message.Play);
		// Go through each Act
		while (currentAct < acts.size()) {
			Act actToPlay = acts.get(currentAct);
			actToPlay.actStart();
			actToPlay.actPlay();
			actToPlay.actEnd();
			currentAct += 1;
		}
	}

	public void gameModelEnd() {
		// Handle Game specific clean up if any for complex games
		setChanged();
		notifyObservers(Message.End);
	}

	public void gameModelPause() {
		throw new UnsupportedOperationException();
	}

	public void gameModelResume() {
		throw new UnsupportedOperationException();
	}

	public void gameModelSave() {
		throw new UnsupportedOperationException();
	}
}
