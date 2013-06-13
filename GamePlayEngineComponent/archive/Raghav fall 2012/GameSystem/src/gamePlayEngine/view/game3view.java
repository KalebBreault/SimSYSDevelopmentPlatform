package gamePlayEngine.view;

import gamePlayEngine.controller.GameController;
import gamePlayEngine.controller.Message;
import gamePlayEngine.controller.MessageType;
import gamePlayEngine.model.gameElement.graphic.Backdrop;
import gamePlayEngine.model.gameElement.graphic.Prop;
import gamePlayEngine.model.gameElement.player.reward.Reward;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class game3view extends javax.swing.JFrame  {

    public GameController controller;
    public JButton UserButton;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3ForImages;
    public JButton Exit;
    private JLabel game3jLabel1;
    private JLabel game3jLabel2;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel game3jLabel3;
    private JLabel jLoad3Image2;
    private JTextArea jTextArea1;
    private JScrollPane jScrollPane2;
    private JTextPane jTextPane1;
    private JScrollPane jScrollPane1;

    public void init()
    {
        UserButton = new javax.swing.JButton();
        Exit = new javax.swing.JButton();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3ForImages = new javax.swing.JLabel();
        game3jLabel1 = new javax.swing.JLabel();
        game3jLabel2 = new javax.swing.JLabel();
        game3jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-293)/2, (screenSize.height-160)/2, 240, 160);
    }

    public void backGround()
    {
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.BLUE);


    }

    public void addImage(String s) throws InterruptedException {

        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().setLayout(null);

        jLabel3ForImages = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.black);

        jLabel3ForImages.setIcon(new javax.swing.ImageIcon("C:\\game3Image1.png")); // NOI18N
        jLabel3ForImages.setText("jLabel2");
        jLabel3ForImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadSecondImage(evt);
            }
        });
        getContentPane().add(jLabel3ForImages);
        getContentPane().setBounds(0,0,1200,257);

        jLabel3ForImages.setBounds(0, 0, 600, 257);


    }

    private void loadSecondImage(MouseEvent evt) {


       jLoad3Image2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLoad3Image2.setIcon(new javax.swing.ImageIcon("C:\\StandClosed.png")); // NOI18N
        jLoad3Image2.setText("jLabel2");
        jLabel3ForImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadThirdImage(evt);
            }
        });
        getContentPane().add(jLoad3Image2);
        jLoad3Image2.setBounds(0, 50, 100, 180);

        jLabel3ForImages.setBounds(0, 0, 495, 247);
        getContentPane().add(jLabel3ForImages);

    }

    private void loadThirdImage(MouseEvent evt) {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

       // jTextArea1.setColumns(20);
        //jTextArea1.setRows(5);
        jTextArea1.setForeground(new java.awt.Color(51, 51, 255));

        jTextArea1.setText("Name : Raghav\nTitle : Student\nDegree : MS/CS\nWork : Intern Juniper\nCollege : UTD\n"); // NOI18N
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(100, 10, 190, 140);

        getContentPane().add(jLoad3Image2);
        jLoad3Image2.setBounds(0, 50, 100, 180);

        jLabel3ForImages.setBounds(0, 0, 495, 247);
        getContentPane().add(jLabel3ForImages);


        jLabel3ForImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitEvent(evt);
            }
        });

    }

    private void ExitEvent(MouseEvent evt) {

        getContentPane().setLayout(null);

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jTextPane1.setText("Hello, my name is Dr. Ima Coder,\n I teach here at Steven B. \nAllmer School of Software Engineering. \n Over the course of this game,\n you will practice a variety of software \n engineering skills that are commonly\n used in industry.");
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().repaint();
        getContentPane().removeAll();


        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 10, 190, 140);

        getContentPane().add(jLoad3Image2);
        jLoad3Image2.setBounds(0, 50, 100, 180);

        jLabel3ForImages.setBounds(0, 0, 495, 247);
        getContentPane().add(jLabel3ForImages);

        jLabel3ForImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LastExitEvent(evt);
            }
        });

    }

    private void LastExitEvent(MouseEvent evt) {

        addExitButton("EXIT");
        addExitLable("Thank you for playing \n" +
                "Toy Game 2!\n");


    }

    private void addLabel(String s) {

        getContentPane().removeAll();
        getContentPane().repaint();
        game3jLabel1.setText("                "+s);
        game3jLabel1.setForeground(Color.YELLOW);
        getContentPane().add(game3jLabel1);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(game3jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(game3jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

        pack();


    }

    private void addButton(String aContinue) {


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.black);

        jButton1.setText(aContinue);
        getContentPane().add(jButton1) ;
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screen1ActionPerformed(evt);
            }
        });

    }

    private void addNextButton(String aContinue) {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.black);
        getContentPane().repaint();
        getContentPane().removeAll();

        jButton2.setText(aContinue);
        getContentPane().add(jButton2);
        setVisible(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    screen2ActionPerformed(evt);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

    }
    private void addExitButton(String aContinue) {


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.black);

        jButton3.setText(aContinue);
        getContentPane().add(jButton3);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
    }

    private void ExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void screen2ActionPerformed(ActionEvent evt) throws InterruptedException {
        addImage("c:\\game3Image1.png");

    }

    private void loadinfImages() throws InterruptedException {

        getContentPane().removeAll();
        getContentPane().repaint();
        init();
          addImage("c:\\game3Image1.png");
          addImage("c:\\game3Image2.png");
          addImage("c:\\game3Image3.png");

       addExitButton("EXIT");
       addExitLable("Thank you for playing \n" +
               "Toy Game 2!\n");
    }



    private void addExitLable(String s) {

        getContentPane().removeAll();
        getContentPane().repaint();
        game3jLabel3.setText("    "+s);
        game3jLabel3.setForeground(Color.YELLOW);
        getContentPane().add(game3jLabel3);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(game3jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(game3jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

        pack();

    }


    private void screen1ActionPerformed(ActionEvent evt) {
     //   getContentPane().removeAll();
       // getContentPane().repaint();
                addNextButton("Continue to scene 2");
                addNextLable("A SoftiCorp Company");
               //ddNewLabel("A SoftiCorp Game");
    }

    private void addNextLable(String s) {

        getContentPane().removeAll();
        getContentPane().repaint();
        game3jLabel2.setText("                "+s);
        game3jLabel2.setForeground(Color.YELLOW);
        getContentPane().add(game3jLabel2);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(game3jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(game3jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

        pack();
    }


    public void game3()
    {
        init();
        backGround();

        addButton("CONTINUE");
        addLabel("Welcome! \n" +
                "Toy Game 2\n");
        setVisible(true);
    }
    public void main(String[] args) {
        game3();

    }

    private javax.swing.JButton jButton1;

}

