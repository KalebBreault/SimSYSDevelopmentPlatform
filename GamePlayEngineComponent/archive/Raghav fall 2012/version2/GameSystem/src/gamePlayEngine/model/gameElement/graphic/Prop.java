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
	private Location location;
	private Color color;
	private Type type;
	private String text;
	private String behavior;
	//private String typeName;
	private Size size;
	private String time;
	private String next;
	
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	@XmlElement(name = "type")
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
	
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);		
		type.addObserver(o);
	}
	
	public void gameElementPlay() {
		setChanged();
		notifyObservers(Message.Play);
		type.typeStart();
		type.typePlay();
		type.typeEnd();
	}
	
}
