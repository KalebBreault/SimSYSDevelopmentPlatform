package gamePlayEngine.view;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: rchellappa
 * Date: 12/4/12
 * Time: 1:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class GUI extends javax.swing.JFrame {

    public JButton game3UserButton;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JButton UserButton;
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
        //To change body of created methods use File | Settings | File Templates.
    }


}

