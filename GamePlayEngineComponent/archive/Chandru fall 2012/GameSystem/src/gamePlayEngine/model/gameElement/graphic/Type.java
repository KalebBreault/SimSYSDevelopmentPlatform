package gamePlayEngine.model.gameElement.graphic;

import gamePlayEngine.controller.Message;
import gamePlayEngine.model.gameElement.GameElement;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.xml.bind.annotation.XmlElement;

public class Type extends Observable{

	private String typeName;
	private List<Event> events;
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
