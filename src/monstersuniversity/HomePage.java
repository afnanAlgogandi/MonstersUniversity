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
 * Home Page Frame , you will start the game from here
 */
public class HomePage extends JFrame {
    
    //creat frame componants
    private JLabel WelcomeLabel , StartGameLabel , BackGroundLabel;
    private JButton StartGameButton , AboutUsButton;
    private ImageIcon StartGameIcon , AboutUsIcon , BackGroundIcon;
    private JPanel Panel ;
    
    //creat menu componants
    private JMenuBar MenuBar;
    private JMenu FileMenu , EditMenu , HelpMenu;
    private JMenuItem CloseItem , AboutItem;
    private JCheckBoxMenuItem DarkModeItem ;
    
    private Color Purple = new Color(106,90,205); //new Color
    
    //--------------------------------------------------------------------------
    
    /*
     * Constructr
     */
    public HomePage(){
        
        Panel = new JPanel();
        
        //Frame character
        setTitle(" Monsters University ");
        setSize(650,500);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
      
        //Bilid a menu
        bulidMenu();
        
        //craet the background of the frame
        BackGroundIcon = new ImageIcon("HomeBackground.png");
        BackGroundLabel = new JLabel (BackGroundIcon);
        BackGroundLabel.setBounds(0,0,646,450);
        
        //----------------
        
        //creat Walcome Label
        WelcomeLabel = new JLabel ("Welcome to the Monsters University!" , SwingConstants.CENTER);
        WelcomeLabel.setFont(new Font("MV Boli",Font.BOLD,22));
        WelcomeLabel.setForeground(Purple);
        WelcomeLabel.setBounds(15,60,600,100);
        
        //creat play game label
        StartGameLabel = new JLabel ("Open the door to start the game" , SwingConstants.CENTER);
        StartGameLabel.setFont(new Font("Ink Free",Font.CENTER_BASELINE,14));
        StartGameLabel.setForeground(Purple);
        StartGameLabel.setBounds(190,260,240,174);
        
        //craet Start game button
        StartGameIcon = new ImageIcon("StarsGameImage.jpg");
        StartGameButton = new JButton(StartGameIcon);
        StartGameButton.addActionListener(new PlayGameListener());
        StartGameButton.setBackground(Color.WHITE);
        StartGameButton.setBounds(200,150,229,174);
        
        //creat about us button
        AboutUsIcon = new ImageIcon("AboutUsImage.JPG");
        AboutUsButton = new JButton(AboutUsIcon);
        AboutUsButton.addActionListener(new AboutUsListener());
        AboutUsButton.setBackground(Color.WHITE);
        AboutUsButton.setToolTipText("Click here to know About Us");
        AboutUsButton.setBounds(500,330,45,30);
                
        //add compounants to the frame 
        setJMenuBar(MenuBar);
        add(StartGameLabel);
        add(StartGameButton);
        add(AboutUsButton);
        add(WelcomeLabel);
        add(BackGroundLabel);
        
        //Visible the frame
        setVisible(true);
    }
    
    //--------------------------------------------------------------------------
    
    /*
     * bulid the menu 
     */
     private void bulidMenu(){
        
        MenuBar = new JMenuBar();
        
        //----------------
        
        FileMenu = new JMenu("File");
        
        CloseItem = new JMenuItem("Close");
        CloseItem.addActionListener(new CloseMItemnListener());
        
        FileMenu.add(CloseItem);
        
        //----------------
        
        EditMenu = new JMenu("Edit");
        
        DarkModeItem = new JCheckBoxMenuItem("Dark Mode");
        DarkModeItem.addItemListener(new DarkModeMItemnListener());
        
        EditMenu.add(DarkModeItem);
        
        //----------------
        
        HelpMenu = new JMenu("Help");
        
        AboutItem = new JMenuItem("About us");
        AboutItem.addActionListener(new AboutUsListener());
        
        HelpMenu.add(AboutItem);
        
        //----------------
        
        MenuBar.add(FileMenu);
        MenuBar.add(EditMenu);
        MenuBar.add(HelpMenu);
     }
     
     //--------------------------------------------------------------- Actions:
   
     private class CloseMItemnListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
           System.exit(0); // close the program
      }
    }
     
     //action to display AboutUs frame
     private class AboutUsListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
          if(e.getSource() == AboutUsButton || e.getSource() == AboutItem){
              AboutUs aboutUs = new AboutUs();
              dispose();
          }
      }
    }
     
     //Action to Dark Mode
     private class DarkModeMItemnListener implements ItemListener{
      public void itemStateChanged(ItemEvent e){
          
          //Dark Mode
          if(DarkModeItem.isSelected()){
          ImageIcon DarkBackGroundIcon;
          DarkBackGroundIcon = new ImageIcon("DarkMode.jpg");
          BackGroundLabel.setIcon(DarkBackGroundIcon);
          StartGameButton.setBackground(Color.BLACK);
          AboutUsButton.setBackground(Color.BLACK);
          }
          else {
              BackGroundLabel.setIcon(BackGroundIcon);
              StartGameButton.setBackground(Color.WHITE);
              AboutUsButton.setBackground(Color.WHITE);
          }
      }
    }
     
     private class PlayGameListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          UserInformation player = new UserInformation();
           dispose();
      }
    }
     
    //------------------------------------------------------------------- main:
     
    public static void main(String[] args){
      HomePage PlayGame = new HomePage();
    }
}