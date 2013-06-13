/**
 * Dummy View class implementation - Will be replaced by actual view classes 
 */
package gamePlayEngine.view;

import gamePlayEngine.controller.GameController;
import gamePlayEngine.controller.Message;
import gamePlayEngine.controller.MessageType;
import gamePlayEngine.model.gameElement.graphic.Backdrop;
import gamePlayEngine.model.gameElement.graphic.Prop;
import gamePlayEngine.model.gameElement.player.reward.Reward;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class GameView implements Observer {

	private GameController controller;
	private String displayInfo;

	public GameController getController() {
		return controller;
	}

	public void setController(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("View: Message " + ((Message)arg1) + " received from " + arg0.getClass());
		if (Prop.class.isInstance(arg0)) {
			HandleProp((Prop) arg0, (Message) arg1);
		} else if (Backdrop.class.isInstance(arg0)) {
			HandleBackdrop((Backdrop) arg0, (Message) arg1);
		} else if (Reward.class.isInstance(arg0)) {
			displayInfo = Integer.toString(((Reward) arg0).getPoints());
		}
	}

	// Handle Backdrop start, play and end messages to add it to display or remove from the display
	private void HandleBackdrop(Backdrop backdrop, Message message) {
		System.out.println(message + " " + backdrop.getClass());
	}

	// Handle Prop start, play and end messages to add it to display or remove from the display
	private void HandleProp(Prop prop, Message message) {
		if (prop.getTypeName().equals("Button")) {
			HandleButton(prop, message);
		} else if (prop.getTypeName().equals("Information Bubble")) {
			HandleLabel(prop, message);
		}

	}

	// Handle Label start, play and end messages to add it to display or remove from the display
	private void HandleLabel(Prop prop, Message message) {
		System.out.println(message + " " + prop + " " + displayInfo);
	}

	// Handle Button start, play and end messages to add it to display or remove from the display
	private void HandleButton(Prop prop, Message message) {
		System.out.println(message + " " + prop);
		if(message == Message.Play) { // wait for user input
			// Can be a mouse click for GUI but on console it is simulated using keyboard input
			System.out.println("View: Please enter user input: ");
			try {
				String line;
				BufferedReader is = new BufferedReader(new InputStreamReader(
						System.in));
				line = is.readLine();
				controller.play(MessageType.External,prop.getBehavior());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
