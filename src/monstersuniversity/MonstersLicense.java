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
import java.io.*;
import java.util.Random;
import javax.swing.*;

/*
 * Monsters License frame , this frame will 
 * take the user name from the file and choice a random License
 * and display the user Monsters License  
 */
public class MonstersLicense extends JFrame{
    
    //frame componants
    private JLabel Background , MonstersLicenseLabel , UserNameLabel;
    private ImageIcon MonstersLicenseIcon , BackgroundIcon;
    private String UserName;
    private Color Blue;
    private JButton HomeButton;
    private ImageIcon HomeIcon;
    
    //--------------------------------------------------------------------------
      
    /*
     * Constructr
     */
    public MonstersLicense(){
    
        //Frame character
        setTitle(" Monsters License ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(650,500); 
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        Blue = new Color(0,0,139);
        
        BackgroundIcon = new ImageIcon("backGroundML.png");
        Background = new JLabel(BackgroundIcon);
        Background.setBounds(0,0,645,475);
        
        //-------------------------------------------------
        
        //array have the License
        String License[] = {"MonstersLicense1.jpg","MonstersLicense2.jpg","MonstersLicense3.jpg",
            "MonstersLicense4.jpg","MonstersLicense5.jpg","MonstersLicense6.jpg"};
        
        //take random License
        Random rand = new Random();
        int RandLicense = rand.nextInt(License.length);
        MonstersLicenseIcon = new ImageIcon (License[RandLicense]);
        
        //display the License
        MonstersLicenseLabel = new JLabel(MonstersLicenseIcon);
        MonstersLicenseLabel.setBackground(Color.WHITE);
        MonstersLicenseLabel.setBounds(20,100,600,365);
        
        //-------------------------------------------------
        
        //Take the name from the file add printit in the License
        UserName = FromTheFile();
                
        UserNameLabel = new JLabel(UserName,SwingConstants.CENTER);
        UserNameLabel.setFont(new Font("Georgia",Font.BOLD,30));
        UserNameLabel.setBounds(70,200,300,300);
        
        
        //HomeButton
        HomeIcon = new ImageIcon("HomePage.JPG");
        HomeButton = new JButton(HomeIcon);
        HomeButton.setBackground(Color.WHITE);
        HomeButton.setBounds(20,20,25,47);
        HomeButton.setToolTipText("Home Page");
        HomeButton.addActionListener(new HomeListener());
       
        //-----------
        
        //add compounants to the frame
        add(HomeButton);
        add(UserNameLabel);
        add(MonstersLicenseLabel);
        add(Background);
        
        //Visible the frame
        setVisible(true);
    }
    
     private String FromTheFile() {
          
         // Create the file.
        BufferedReader PlayerInfoFile;
        
        String PlayerName = null;
        
        try {
            PlayerInfoFile = new BufferedReader(new FileReader("PlayerInformation.txt"));
            
            // Read the name from the file.
            PlayerName = PlayerInfoFile.readLine();
            
            //show confirmation message
            System.out.println("Player information is read successfully");
            PlayerInfoFile.close();
            
        } catch (IOException ex) {
             System.out.println(ex);
        }
        return PlayerName;
    }
    
    //--------------------------------------------------------------------------
    private class HomeListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          HomePage Home = new HomePage();
          dispose();
      }
    }
}
    

