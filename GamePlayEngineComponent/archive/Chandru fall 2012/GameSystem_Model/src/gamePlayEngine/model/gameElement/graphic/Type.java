package gamePlayEngine.model.gameElement.graphic;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.gameElement.GameElement;
import gamePlayEngine.model.gameElement.player.Size;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.bind.annotation.XmlElement;

public class Type extends Observable{

	private String typeName;
	private List<Event> events;
	private Location location;
	private Color color;
	private String text;
	private Size size;
	private int currentEvent = 0;
	
	@XmlElement(name = "typeName")
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@XmlElement(name = "event")
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);		
		for (Event event : events) {
			event.addObserver(o);
		}
	}
	
	public void typeStart(){
		setChanged();
		notifyObservers(Message.Start);
	}

	public void typePlay(){
		setChanged();
		notifyObservers(Message.Play);
		while (currentEvent < events.size()) {
			Event event = events.get(currentEvent);
			event.eventStart();
			event.eventPlay();
			event.eventEnd();			
			currentEvent += 1;
		}
		
	}
	
	public void typeEnd(){
		setChanged();
		notifyObservers(Message.End);
	}
	
}
