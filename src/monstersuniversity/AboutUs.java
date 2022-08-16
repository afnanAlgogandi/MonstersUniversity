/*
Name: Layal Soud Halwani
ID: 2007896 
Section: I1 
Email: 2007896@uj.edu.sa
----
Name: Afnan Tarig Algogandi
ID: 2007926 
Section: I2 
Email: 2007926@uj.edu.sa
*/

package monstersuniversity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 /*
  * About us Frame , have game information , How to Play , Our Information
  */
public class AboutUs extends JFrame {
    
    //frame componants
    private JLabel AboutUsLabel;
    private ImageIcon AboutUsIcon;
    
    private JButton HomeButton;
    private ImageIcon HomeIcon;
    
    //--------------------------------------------------------------------------
    
    /*
     * Constructr
     */
    public AboutUs(){
        
        //Frame character
        setTitle(" About Us ");
        setSize(650,500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
       
        //Background Frame
        AboutUsIcon = new ImageIcon ("aboutUsBackGround.png");
        AboutUsLabel = new JLabel(AboutUsIcon);
        AboutUsLabel.setBounds(0,0,645,475);
        
        //HomeButton
        HomeIcon = new ImageIcon("HomePage.JPG");
        HomeButton = new JButton(HomeIcon);
        HomeButton.setBackground(Color.WHITE);
        HomeButton.setBounds(10,10,25,47);
        HomeButton.setToolTipText("Home Page");
        HomeButton.addActionListener(new HomeListener());
       
        //-----------
        
        //add compounants to the frame
        add(HomeButton);
        add(AboutUsLabel);
        
        //Visible the Frame
        setVisible(true);
    }
    //----------------------------------------------------------------- Action: 
    
    private class HomeListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          HomePage Home = new HomePage();
          dispose();
      }
    }
}
    
    
