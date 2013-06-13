/**
 * Generic GameElement class servers as a base class for other derived classes - GameCharacer, Graphic and Audio 
 * This file contains the definition of this class.
 */
package gamePlayEngine.model.gameElement;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.audio.Audio;
import gamePlayEngine.model.gameElement.character.GameCharacter;
import gamePlayEngine.model.gameElement.graphic.Graphic;

import java.util.Observable;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Base class for GameCharacter, Graphic and Audio provides default implementation of start, play and end
 * Derived classes can override these methods to provide suitable implementation.
 */
@XmlSeeAlso({ GameCharacter.class, Graphic.class, Audio.class })
public class GameElement extends Observable {

	/**
	 * Default Implementation for classes that do not override this method
	 */
	public void gameElementStart() {
		setChanged();
		notifyObservers(Message.Start);
	}

	/**
	 * Default Implementation for classes that do not override this method
	 */
	public void gameElementPlay() {
		setChanged();
		notifyObservers(Message.Play);
	}
	
	/**
	 * Default Implementation for classes that do not override this method
	 */
	public void gameElementEnd() {		
		setChanged();
		notifyObservers(Message.End);
	}
	
	public void gameElementPause() {
		throw new UnsupportedOperationException();
	}

	public void gameElementResume() {
		throw new UnsupportedOperationException();
	}

	public void gameElementSave() {
		throw new UnsupportedOperationException();
	}
}
