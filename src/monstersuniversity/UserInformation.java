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
import javax.swing.*;

 /*
 * User Information Frame , this Frame will take the user information and 
 * Strorage the information in the file to print the name in the 
 * license in the end of the game
 */
public class UserInformation extends JFrame{
    
    //creat frame componants
    private JLabel ErrorLabel , player ,nameLabel ,emailLabel, numberLabel, backGroundLabel;
    
    private JTextField nameText = new JTextField(8);
    private JTextField emailText = new JTextField(8);
    private JTextField numberText = new JTextField(8);
    
    private Color purple = new Color(123,104,238);//new Color
    
    private JButton clear = new JButton("CLEAR");
    private JButton start = new JButton("START");
    
    private JButton HomeButton;
    private ImageIcon HomeIcon;
    
    private ImageIcon BackGround = new ImageIcon("UserInformationBackground.jpg");
    
    //--------------------------------------------------------------------------
    
    
    /*
     * Constructr
     */
    public UserInformation(){
        
        //Frame character
        setTitle(" Player information ");
        setSize(650,500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        //frame background
        backGroundLabel = new JLabel(BackGround);
        backGroundLabel.setBounds(0, 0, 650, 475);
        
        //-----------
        
        //Player information label
        player = new JLabel("Player Information");
        player.setForeground(purple);
        player.setFont(new Font("MV Boli",Font.BOLD,29));
        player.setBounds(168, 100, 600, 40);
        
        //-----------
         
        ////Player information Text Failds
        nameText.setFont(new Font("MV Boli",Font.BOLD,21));
        nameText.setBounds(350, 160, 200, 40);
        
        emailText.setFont(new Font("MV Boli",Font.BOLD,21));
        emailText.setBounds(350, 210, 200, 40);
        
        numberText.setFont(new Font("MV Boli",Font.BOLD,21));
        numberText.setBounds(350, 260, 200, 40);
        
        
        //-----------
        
        //Name Label
        nameLabel = new JLabel("your Name:");
        nameLabel.setForeground(purple);
        nameLabel.setFont(new Font("MV Boli",Font.BOLD,21));
        nameLabel.setBounds(170, 160, 600, 40);
        
        //-----------
        
        //Email Label
        emailLabel = new JLabel("your Email:");
        emailLabel.setForeground(purple);
        emailLabel.setFont(new Font("MV Boli",Font.BOLD,21));
        emailLabel.setBounds(170, 210, 600, 40);
        
        //-----------
        
        //Phone number Label
        numberLabel = new JLabel("PhoneNumber:");
        numberLabel.setForeground(purple);
        numberLabel.setFont(new Font("MV Boli",Font.BOLD,21));
        numberLabel.setBounds(170, 260, 600, 40);
        
        //-----------
        
        //Error Label
        ErrorLabel = new JLabel("");
        ErrorLabel.setForeground(Color.RED);
        ErrorLabel.setFont(new Font("MV Boli",Font.BOLD,18));
        ErrorLabel.setBounds(200, 300, 600, 40);
        
        //-----------
        
        //Clear Button
         clear.setBackground(purple);
         clear.setForeground(Color.WHITE);
         clear.setFont(new Font("MV Boli",Font.BOLD,18));
         clear.setBounds(200, 350, 100, 35);
         clear.addActionListener(new ClearListener());
        
        //-----------
        
        //Start Button
         start.setBackground(purple);
         start.setForeground(Color.WHITE);
         start.setFont(new Font("MV Boli",Font.BOLD,18));
         start.setBounds(350, 350, 100, 35);
         start.addActionListener(new StartListener());
        
        //-----------
        
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
        add(clear);
        add(start);
        add(nameText);
        add(numberText);
        add(emailText);
        add(numberLabel);
        add(emailLabel);
        add(nameLabel);
        add(ErrorLabel);
        add(player);    
        add(backGroundLabel);
        
        //Visible the frame
        setVisible(true);
        
        
    }

  
    
    
    //----------------------------------------------------------------- Action:
    
     private class ClearListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          nameText.setText("");
          emailText.setText("");
          numberText.setText("");    
      }
    }
     
      private class StartListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          String EmailForm = "^[A-Za-z0-9+_.-]+@(.+)$";
          String PhoneNumberForm = "^\\d{10}$";
          
          boolean EmailMatch = emailText.getText().matches(EmailForm);
          boolean PhoneNumberMatch = numberText.getText().matches(PhoneNumberForm);
          boolean Empty = nameText.getText().trim().isEmpty() || emailText.getText().trim().isEmpty() 
                     || numberText.getText().trim().isEmpty();
      
            if(Empty==true){
                ErrorLabel.setText("Please inter your information.");
            }
            else{
               if(EmailMatch==false){
                       ErrorLabel.setText("Please inter correct email");
               }
               if(PhoneNumberMatch==false){
                       ErrorLabel.setText("Please inter correct phone number");
               }
            }
          
            if (Empty==false && EmailMatch==true && PhoneNumberMatch==true){  
              
                writeToFile();
               
                ChossePicture StartGame = new ChossePicture();
                dispose();
            }   
      }
    }
    
      private void writeToFile() {
          
         // Create the file .
         BufferedWriter PlayerInfoFile;
         
        try {
            PlayerInfoFile = new BufferedWriter(new FileWriter("PlayerInformation.txt",false));
            
            // Write to the file.
            PlayerInfoFile.write((String) nameText.getText() + "\n");
            PlayerInfoFile.write((String) emailText.getText() + "\n");
            PlayerInfoFile.write((String) numberText.getText() + "\n");
            
            //show confirmation message
            System.out.println("Player information is added successfully");
            PlayerInfoFile.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error wrting to file");
        } catch (IOException ex) {
            System.out.println("Error wrting to file");
        }
    }
      
    private class HomeListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          HomePage Home = new HomePage();
          dispose();
      }
    }
    
}

