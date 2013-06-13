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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class GameView extends javax.swing.JFrame implements Observer  {

	public GameController controller;
    public JButton UserButton;
    public JButton game3UserButton;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JTextField jLabel3;
    public JButton Exit;
	private String displayInfo;
    public int Qucki = 10;
    public int moderate = 100;
    public int longer = 1000;
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
		System.out.println(message + " " + backdrop.getClass());
        init();
        backGround();   // starting backdrop
    }

	// Handle Prop start, play and end messages to add it to display or remove from the display
	private void HandleProp(Prop prop, Message message) throws InterruptedException {
		if (prop.getTypeName().equals("Button")) {
			HandleButton(prop, message);
		} else if (prop.getTypeName().equals("Information Bubble")) {
			HandleLabel(prop, message);
		}
		
	}

	// Handle Label start, play and end messages to add it to display or remove from the display
	private void HandleLabel(Prop prop, Message message) throws InterruptedException {
		System.out.println(message + "  " + prop + " " + displayInfo);
        // i am not adding handle label here because the model is sending multiple times start ,play and stop <raghav>
    }



	// Handle Button start, play and end messages to add it to display or remove from the display
	private void HandleButton(Prop prop, Message message) throws InterruptedException {
		System.out.println(message + " " + prop);
		if(message == Message.Play) { // wait for user input
			// Can be a mouse click for GUI but on console it is simulated using keyboard input
             //addButton("PLAY TO WIN");
             System.out.println("View: Please enter user input: " + prop.getBehavior());
             init();
             getContentPane().removeAll();
             getContentPane().repaint();
             addButton("PLAY TO WIN");  // starting button
             backGround();
             setVisible(true);

        }
    }
               // controller.gcPlay(MessageType.External,prop.getBehavior());

    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            RewardPay();
            getContentPane().removeAll();
            getContentPane().repaint();
            addLabel("You Won !!!" +
                    "Your Current Points are 6000");  // starting label
            backGround();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public void addLabel(String Str)
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setBackground(new java.awt.Color(255, 255, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jLabel3.setText(Str);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 10, 230, 30);

        Exit.setText("EXIT");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(160, 70, 100, 30);
        Exit.setBackground(new java.awt.Color(255, 255, 0));

    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {

       System.exit(1);
    }

    public void backGround()
    {
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\background1.png")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -40, 280, 200);

    }

    public void Act2scene1(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(253, 255, 248));
        setVisible(true);
        Thread.sleep(Quick);

       getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 146, 141));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 105, 93));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 38, 33));
        setVisible(true);

    }
    public void Act2scene2(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(247, 230, 255));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 175, 235));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 90, 210));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 30, 220));
        setVisible(true);

    }

    public void Act2scene3(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(3, 3, 4));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 163, 146));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 134, 69));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 96, 17));
        setVisible(true);

    }

    public void scene1(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(253, 255, 248));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(18, 152, 255));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(25, 81, 255));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(64, 14, 255));
        setVisible(true);

    }
    public void scene2(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(247, 230, 255));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(202, 253, 255));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(107, 255, 250));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(0, 255, 247));
        setVisible(true);

    }

    public void scene3(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(3, 3, 4));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 202, 255));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(250, 124, 255));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 28, 232));
        setVisible(true);

    }

    public void Act3scene1(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(253, 255, 248));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(242, 255, 178));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(249, 255, 117));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 253, 33));
        setVisible(true);

    }
    public void Act3scene2(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(247, 230, 255));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 220, 165));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 168, 91));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 179, 31));
        setVisible(true);

    }

    public void Act3scene3(int Quick) throws InterruptedException {
        init();
        getContentPane().setLayout(null);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(3, 3, 4));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(241, 188, 159));
        setVisible(true);
        Thread.sleep(Quick);


        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 148, 76));
        setVisible(true);
        Thread.sleep(Quick);

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setBackground(new java.awt.Color(255, 129, 21));
        setVisible(true);

    }
    public void Act1() throws InterruptedException {
        scene1(Qucki);
        scene2(Qucki);
        scene3(Qucki);
    }
    public void Act2() throws InterruptedException {
        Act2scene1(moderate);
        Act2scene2(moderate);
        Act2scene3(moderate);
    }

    public void Act3() throws InterruptedException {
        Act3scene1(longer);
        Act3scene2(longer);
        Act3scene3(longer);
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


   	public void showStartView() throws IOException, InterruptedException {
		System.out.println("Please enter a key to start the game:");      // chandru --> i dont understand y  u have added this here
        InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        String str = bufRead.readLine();
        if(str.contains("game2"))
        {
            Act1();
            Act2();
            Act3();
            System.exit(0);
        }
        else if(str.contains("game3"))
        {
            game3view gm3 = new game3view();
            gm3.game3();
        }
           else
		   controller.gcPlay(MessageType.External, "start");


	}
    public void RewardPay() throws InterruptedException {
        Prop p = new Prop();
        p.setBehavior("Reward.AddPoints.5000");
      controller.gcPlay(MessageType.External, p.getBehavior());
    }
}
