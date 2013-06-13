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

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class GameView extends javax.swing.JFrame implements Observer  {

	private GameController controller;
	private String displayInfo;
;

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
        if(message == Message.Play)
        {
            backGround();
        }
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
		System.out.println(message + " LABEl " + prop + ">>>> " + displayInfo);
	}

	// Handle Button start, play and end messages to add it to display or remove from the display
	private void HandleButton(Prop prop, Message message) throws InterruptedException {
		System.out.println("came here "+message + " " + prop);

		if(message == Message.Play) { // wait for user input
			// Can be a mouse click for GUI but on console it is simulated using keyboard input
            init();
            addButton(prop.getText());

			controller.gameControllerPlay(MessageType.External,prop.getBehavior());
            Thread.sleep(10000);
		}
	}

	public void showStartView() throws IOException, InterruptedException {
		System.out.println("Please enter a key to start the game:");
		System.in.read();
		controller.gameControllerPlay(MessageType.External, "start");

	}

public JButton UserButton;
public JButton game3UserButton;
public JLabel jLabel1;
public JLabel jLabel2;
public JTextField jLabel3;
public JButton Exit;
public int Qucki = 100;
public int moderate = 1000;
public int longer = 10000;

    public void init()
    {
        UserButton = new javax.swing.JButton();
        Exit = new javax.swing.JButton();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-293)/2, (screenSize.height-160)/2, 293, 160);
        setVisible(true);
    }

    public void addButton(String str)
    {
        UserButton.setText(str);
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UserButton);

        UserButton.setBounds(70, 50, 150, 23);
        UserButton.setBackground(new java.awt.Color(255, 255, 0));
    }

    private void UserButtonActionPerformed(ActionEvent evt) {
        System.out.println("AFTER CLICK");
        addLabel("You Won !! Your Current " +
                "" +
                "Points are 6000");
           //To change body of created methods use File | Settings | File Templates.


    }


    // controller.gcPlay(MessageType.External,prop.getBehavior());
    public void addLabel(String Str)
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().removeAll();
        getContentPane().repaint();


       jLabel3.setBackground(new java.awt.Color(255, 255, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jLabel3.setText(Str);
        jLabel3.setBorder(new RoundedBorder(10));

        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 10, 250, 40);

        Exit.setText("EXIT");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Exit.setBounds(160, 70, 100, 30);
        Exit.setBackground(new java.awt.Color(255, 255, 0));
        getContentPane().add(Exit);
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {


        getContentPane().removeAll();
        getContentPane().repaint();
        backGround();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //System.exit(1);
    }

    public void backGround()
    {

        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\background1.png")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -40, 280, 200);

    }

    class RoundedBorder implements Border {
        int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }
}
