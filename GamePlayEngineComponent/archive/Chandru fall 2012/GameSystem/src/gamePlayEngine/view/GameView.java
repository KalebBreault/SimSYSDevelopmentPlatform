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
			try {
				HandleProp((Prop) arg0, (Message) arg1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (Backdrop.class.isInstance(arg0)) {
			HandleBackdrop((Backdrop) arg0, (Message) arg1);
		} else if (Reward.class.isInstance(arg0)) {
			displayInfo = Integer.toString(((Reward) arg0).getPoints());
		}
	}

	// Handle Backdrop start, play and end messages to add it to display or remove from the display
	private void HandleBackdrop(Backdrop backdrop, Message message) {
        System.out.println(">>>>>> backdrop given ");
        System.out.println(message + " " + backdrop.getClass());
	}

	// Handle Prop start, play and end messages to add it to display or remove from the display
	private void HandleProp(Prop prop, Message message) throws InterruptedException {
        System.out.println("got the prop as "+prop.getType().getTypeName()+" message is "+message);
		if (prop.getType().getTypeName().equals("Button1")) {
			HandleButton(prop, message);
		} else if (prop.getType().getTypeName().equals("InformationBox1")) {
			HandleLabel(prop, message);
		}
		
		
		  /*if(prop.getTime().equals("QUICK")){
			  System.out.println("?????????");
			  HandleTime(prop, message);
		  }*/
	}

	// Handle Label start, play and end messages to add it to display or remove from the display
	
	private void HandleTime(Prop prop, Message message) {
		System.out.println(message + " chandru" + prop + " " + displayInfo);
	}
	
	private void HandleLabel(Prop prop, Message message) {
		System.out.println(message + " " + prop + ">>>> " + displayInfo);
	}

	// Handle Button start, play and end messages to add it to display or remove from the display
	private void HandleButton(Prop prop, Message message) throws InterruptedException {
		System.out.println(message + " " + prop);
		if(message == Message.Play) { // wait for user input
			// Can be a mouse click for GUI but on console it is simulated using keyboard input
			System.out.println("View: Please enter user input: ");
			try {
				String line;
				BufferedReader is = new BufferedReader(new InputStreamReader(
						System.in));
				line = is.readLine();
				controller.gameControllerPlay(MessageType.External,prop.getBehavior());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void showStartView() throws IOException, InterruptedException {
		System.out.println("Please enter a key to start the game:");
		System.in.read();
		controller.gameControllerPlay(MessageType.External, "start");
		
	}

}
