/**
 * Specialized class from Graphic presenting a Prop Model
 */
package gamePlayEngine.model.gameElement.graphic;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.gameElement.GameElement;
import gamePlayEngine.model.gameElement.player.Size;

import java.util.List;
import java.util.Observer;

import javax.xml.bind.annotation.XmlElement;

//@XmlSeeAlso({Button.class, Label.class})
public class Prop<T> extends Graphic {


	private GameElement identifier;
	private List<Type> types;
	private String behavior;
	//private String typeName;
	private String time;
	private String next;
	private int currentType = 0;
	
	/* Templated type on unmarshalling from XML is lost. Once this issue is fixed following can be used */
	//private T type;

	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time= time;
	}
	
	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}


	/*public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}*/
	
	public GameElement getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Graphic identifier) {
		this.identifier = identifier;
	}

/*	@XmlElement(name = "type")
	public List<Type> getTypes() {
		return types;
	}

	public void setType(List<Type> types) {
		this.types = types;
	}*/

	@XmlElement(name = "type")
	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}


	public String getNext() {
		return next;
	}
	
	public void setNext(String next) {
		this.next = next;
	}
	
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		for (Type type : types) {
			type.addObserver(o);
		}
	}
	
	public void propStart(){
		setChanged();
		notifyObservers(Message.Start);
		
	}
	
	public void propPlay() {
		setChanged();
		notifyObservers(Message.Play);
		while (currentType < types.size()) {
			Type type = types.get(currentType);
			type.typeStart();
			type.typePlay();
			type.typeEnd();
			currentType += 1;
		}
	}
	
	public void propEnd(){
		setChanged();
		notifyObservers(Message.End);
	}
	
}
