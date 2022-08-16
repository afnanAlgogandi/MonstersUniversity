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
import java.util.Random;
import javax.swing.*;

/*
 * Chosse Picture Frame , this frame to let the user choice 
 * a picture to start the game
 */
public class ChossePicture extends JFrame{
    
     //creat frame componants
    private JLabel BackgroundLabel , ChooseLabel;
    private ImageIcon Picture1Icon , Picture2Icon , BackgroundIcon;
    private JButton Pic1Button , Pic2Button;
            
    //Home Button
    private JButton HomeButton;
    private ImageIcon HomeIcon;
    
    private Color Purple = new Color(106,90,205);//new Color
    
    //--------------------------------------------------------------------------
    
    /*
     * Constructr
     */
    public ChossePicture(){
        
        //Frame character
        setTitle(" Monsters University ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(650,500); 
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //-------------------------------------------------
        
        //creat Background
        BackgroundIcon = new ImageIcon("BackGround.png");
        BackgroundLabel = new JLabel (BackgroundIcon);
        BackgroundLabel.setBounds(0,0,645,475);
        
        //----------------
        
        //creat Chosse label
        ChooseLabel = new JLabel ("Chosse a Picture" , SwingConstants.CENTER);
        ChooseLabel.setFont(new Font("MV Boli",Font.BOLD,30));
        ChooseLabel.setForeground(Purple);
        ChooseLabel.setBounds(20,70,600,100);
        
        //----------------
        
        //button pic1
        Picture1Icon = new ImageIcon("Picture1.jpg");
        Pic1Button = new JButton(Picture1Icon);
        Pic1Button.setBackground(Color.WHITE);
        Pic1Button.setBounds(110,160,200,200);
        Pic1Button.addActionListener(new PicButtonListener());
        
        //button pic2
        Picture2Icon = new ImageIcon("Picture2.jpg");
        Pic2Button = new JButton(Picture2Icon);
        Pic2Button.setBackground(Color.WHITE);
        Pic2Button.setBounds(320,160,200,200);
        Pic2Button.addActionListener(new PicButtonListener());
        
        //----------------
        
        //HomeButton
        HomeIcon = new ImageIcon("HomePage.JPG");
        HomeButton = new JButton(HomeIcon);
        HomeButton.setBackground(Color.WHITE);
        HomeButton.setBounds(10,10,25,47);
        HomeButton.setToolTipText("Home Page");
        HomeButton.addActionListener(new HomeListener());
       
        //----------------
        
        //add compounants to the frame
        add(HomeButton);
        add(Pic1Button);
        add(Pic2Button);
        add(ChooseLabel);
        add(BackgroundLabel);
    
        //Visible the frame
        setVisible(true);
    }
    
    //----------------------------------------------------------------- Action: 
    
    private class PicButtonListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
          
          if (e.getSource() == Pic1Button){
             Picture1 Game = new Picture1();  
             dispose();
          }
          else if (e.getSource() == Pic2Button){
             Picture2 Game = new Picture2();  
             dispose();
          }
      }
    }
      
    private class HomeListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
          HomePage Home = new HomePage();
          dispose();
      }
    }
}
