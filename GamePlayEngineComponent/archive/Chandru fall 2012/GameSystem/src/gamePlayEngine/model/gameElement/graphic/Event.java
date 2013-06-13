package gamePlayEngine.model.gameElement.graphic;

import gamePlayEngine.controller.Message;

import java.util.Observable;

import javax.xml.bind.annotation.XmlElement;

public class Event extends Observable{

	private EventName eventName;
	private Animation animation ;
	private Time time;
	
	@XmlElement(name = "eventName")
	public EventName getEventName() {
		return eventName;
	}
	public void setEventName(EventName eventName) {
		this.eventName = eventName;
	}
	public Animation getAnimation() {
		return animation;
	}
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public void eventStart(){
		setChanged();
		notifyObservers(Message.Start);
		
	}

	public void eventPlay(){
		setChanged();
		notifyObservers(Message.Play);
		
	}
	
	public void eventEnd(){
		setChanged();
		notifyObservers(Message.End);
	}
	
}
