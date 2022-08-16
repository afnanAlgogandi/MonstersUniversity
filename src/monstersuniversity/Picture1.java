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
 * This Frame for Picture 1 , this frame is the game , the user have
 * to choice a color from the radio buttons 
 * the code of the color will display in the text area , the user will click 
 * the buttons to chinge the color 
 * and finaly when the user finshing and the picture complete , 
 * click to the Done button.
 */
public class Picture1 extends JFrame {
    
    //frame componants
    private JLabel ColumnLabel , PictureLabel;
    private JRadioButton RBPurple , RBBlue , RBBlack ,RBSilver, RBWhite;
    private JButton DoneButton;
    private ImageIcon PictureIcon;
    private ButtonGroup RBGroup;
    private JPanel FramePanel , ColoringPanel , boardPanel , RowPanel , ColorPanel , GamePanel , PicturePanel;
    private JScrollPane CodeScroll;
    private JTextArea CodeTextArea;
    
    private JButton [] Buttons;
    private JLabel [] Rows;
    
    final private Color Purple , Blue , LightGray, Silver , Gray;
    String color;
    
    // mneu
    private JMenuBar MenuBar;
    private JMenu FileMenu , EditMenu , HelpMenu;
    private JMenuItem CloseItem , AboutItem , BackItem , HomeItem;
    private JCheckBoxMenuItem DarkModeItem ;
    
    //--------------------------------------------------------------------------
    /*
     * Constructr
     */
    public Picture1(){
        
        //Frame character
        setTitle(" Monsters University ");
        setSize(650,500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setResizable(false);
        
        //----------------------------------------------------
        
        FramePanel = new JPanel();
        FramePanel.setLayout(new BorderLayout(10,10));
        
        //----------------------------------------------------
        
        // creat the colors
        Purple = new Color(123,104,238);
        Blue = new Color(30,144,255);
        LightGray = new Color(220,220,220);
        Silver = new Color(192,192,192);
        Gray = FramePanel.getBackground();
        
        //----------------------------------------------------
        
        //Bilid method
        BulidMenu();
        BulidColoringPanel();
        BulidColorPanel();
        BulidGamePanel();
        
        //----------------------------------------------------
        
        //add componants to the frame
        setJMenuBar(MenuBar);
        add(FramePanel);
        
        //add to the panel
        FramePanel.add(ColoringPanel,BorderLayout.CENTER);
        FramePanel.add(ColorPanel,BorderLayout.SOUTH);
        FramePanel.add(GamePanel,BorderLayout.WEST);
        
        //----------------------------------------------------
        
        //visible the frame
        setVisible(true);
    }
    
    //--------------------------------------------------------------------------
    
     public void BulidGamePanel(){
         
         GamePanel = new JPanel();
         GamePanel.setLayout(new GridLayout(2,0,4,4));
         
        //----------------------------------------------------
         
        //Done Button
         DoneButton = new JButton("Done");
         DoneButton.setBackground(Purple);
         DoneButton.setForeground(Color.WHITE);
         DoneButton.setFont(new Font("Ink Free",Font.BOLD,20));
         DoneButton.addActionListener(new DoneButton());
         
         //the pic
         PictureIcon = new ImageIcon("Picture1Lines.jpg");
         PictureLabel = new JLabel(PictureIcon);
         
         //add to the panel
         PicturePanel = new JPanel();
         PicturePanel.setLayout(new BorderLayout(2,2));
         PicturePanel.add(DoneButton,BorderLayout.NORTH);
         PicturePanel.add(PictureLabel,BorderLayout.CENTER);
         
        //----------------------------------------------------
        
        //Text Area to the code
         CodeTextArea = new JTextArea (10,10);
         CodeTextArea.setFont(new Font("Ink Free",Font.BOLD,20));
         CodeTextArea.setForeground(Color.GRAY);
         CodeTextArea.setBackground(LightGray);
         CodeTextArea.setText("Code is here");
         CodeScroll = new JScrollPane(CodeTextArea);
         CodeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         
         //----------------------------------------------------
         
         //add to  the panel
         GamePanel.add(PicturePanel);   
         GamePanel.add(CodeScroll);
     }
     
     //-------------------------------------------------------------------------
     
     public void BulidColorPanel(){
         
         ColorPanel = new JPanel();
         RBGroup = new ButtonGroup();
         
        //----------------------------------------- radio Buttton Colors:
         
         RBPurple = new JRadioButton ("Purple");
         RBPurple.setForeground(Purple);
         RBPurple.setFont(new Font("MV Boli",Font.BOLD,15));
         RBPurple.addActionListener(new colorListener());
         RBGroup.add(RBPurple);
        
         RBBlack = new JRadioButton ("Black");
         RBBlack.setForeground(Color.BLACK);
         RBBlack.setFont(new Font("MV Boli",Font.BOLD,15));
         RBBlack.addActionListener(new colorListener());
         RBGroup.add(RBBlack);
         
         RBWhite = new JRadioButton ("White");
         RBWhite.setForeground(Color.WHITE);
         RBWhite.setFont(new Font("MV Boli",Font.BOLD,15));
         RBWhite.addActionListener(new colorListener());
         RBGroup.add(RBWhite);
         
         RBBlue = new JRadioButton ("Blue");
         RBBlue.setForeground(Blue);
         RBBlue.setFont(new Font("MV Boli",Font.BOLD,15));
         RBBlue.addActionListener(new colorListener());
         RBGroup.add(RBBlue);
         
         RBSilver = new JRadioButton ("Silver");
         RBSilver.setForeground(Silver);
         RBSilver.setFont(new Font("MV Boli",Font.BOLD,15));
         RBSilver.addActionListener(new colorListener());
         RBGroup.add(RBSilver);
         
        //----------------------------------------------------
         
        //add to the panel
         ColorPanel.add(RBPurple);
         ColorPanel.add(RBBlue);
         ColorPanel.add(RBSilver);
         ColorPanel.add(RBBlack);
         ColorPanel.add(RBWhite);
         
     }
     
    //--------------------------------------------------------------------------
     
     public void BulidColoringPanel(){
        
        ColoringPanel  = new JPanel();
        ColoringPanel.setLayout(new BorderLayout()); 
        
       //------------------------------------------------
       
       //RowLabel
        RowPanel = new JPanel();
        RowPanel.setLayout(new GridLayout(0,1)); 
       
        Rows = new JLabel[24];
        
        for (int i=0;i<24;i++){
            String Number = String.valueOf(i);
        Rows[i] = new JLabel(Number);
        Rows[i].setFont(new Font("MV Boli",Font.BOLD,11));
        Rows[i].setForeground(Purple);
        RowPanel.add(Rows[i]);
        }
       
       //------------------------------------------------
       
       //ColumnLabel
       ColumnLabel = new JLabel("    A  B  C  D  E  F  G  H  I   J  K  L  M  N  O  P   Q  R  S  T  U");
       ColumnLabel.setFont(new Font("MV Boli",Font.BOLD,11));
       ColumnLabel.setForeground(Purple);
       
       //------------------------------------------------
        
       //Playing Area
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(24,21)); 
       
        Buttons = new JButton[504];
        
        for (int i=0;i<504;i++){
        Buttons[i] = new JButton("");
        Buttons[i].setBackground(Color.WHITE);
        Buttons[i].addActionListener(new ButtonListener());
        Buttons[i].setPreferredSize(new Dimension(20,20));
        boardPanel.add(Buttons[i]);
        }
        
       //------------------------------------------------
        
       //add to the panel
        ColoringPanel.add(ColumnLabel , BorderLayout.NORTH);
        ColoringPanel.add(RowPanel , BorderLayout.WEST);
        ColoringPanel.add(boardPanel , BorderLayout.CENTER);
    }
     
     //-------------------------------------------------------------------------
    
     /*
      * mnue
      */
    private void BulidMenu(){
        
        MenuBar = new JMenuBar();
        
        //----------------------------------------------------
        FileMenu = new JMenu("File");
        
        BackItem = new JMenuItem("Back");
        BackItem.addActionListener(new FileMenuItemnListener());
        HomeItem = new JMenuItem("Home");
        HomeItem.addActionListener(new FileMenuItemnListener());
        CloseItem = new JMenuItem("Close");
        CloseItem.addActionListener(new FileMenuItemnListener());
        
        FileMenu.add(BackItem);
        FileMenu.add(HomeItem);
        FileMenu.add(CloseItem);
        
        //----------------------------------------------------
        
        EditMenu = new JMenu("Edit");
        
        DarkModeItem = new JCheckBoxMenuItem("Dark Mode");
        DarkModeItem.addItemListener(new DarkModeMItemnListener());
        
        EditMenu.add(DarkModeItem);
        
        //----------------------------------------------------
        
        HelpMenu = new JMenu("Help");
        
        AboutItem = new JMenuItem("About us");
        AboutItem.addActionListener(new AboutUsListener());
        
        HelpMenu.add(AboutItem);
        
        //----------------------------------------------------
        
        MenuBar.add(FileMenu);
        MenuBar.add(EditMenu);
        MenuBar.add(HelpMenu);
     }
    
    //--------------------------------------------------------- Menu Actions:
    
    private class FileMenuItemnListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          if(e.getSource() == CloseItem){
              System.exit(0); // close the program
          }
          else if (e.getSource() == BackItem){
              ChossePicture StartGame = new ChossePicture();
              dispose();
          }
          else if (e.getSource() == HomeItem){
              HomePage Home = new HomePage();
              dispose();
          }
      }
    }
 
     //action to display AboutUs frame
     private class AboutUsListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
          if(e.getSource() == AboutItem){
              AboutUs aboutUs = new AboutUs();
          }
      }
    }
     
     //Action to Dark Mode
     private class DarkModeMItemnListener implements ItemListener{
      public void itemStateChanged(ItemEvent e){
          
          //Dark Mode
          if(DarkModeItem.isSelected()){
               FramePanel.setBackground(Color.BLACK);
               ColoringPanel.setBackground(Color.BLACK);
               boardPanel.setBackground(Color.BLACK);
               RowPanel.setBackground(Color.BLACK);
               ColorPanel.setBackground(Color.BLACK);
               GamePanel.setBackground(Color.BLACK);
               PicturePanel.setBackground(Color.BLACK);
               RBPurple.setBackground(Color.BLACK);
               RBBlue.setBackground(Color.BLACK);
               RBBlack.setBackground(Color.BLACK);
               RBBlack.setForeground(Color.GRAY);
               RBSilver.setBackground(Color.BLACK);
               RBWhite.setBackground(Color.BLACK);
               
          }
          else {
               FramePanel.setBackground(Gray);
               ColoringPanel.setBackground(Gray);
               boardPanel.setBackground(Gray);
               RowPanel.setBackground(Gray);
               ColorPanel.setBackground(Gray);
               GamePanel.setBackground(Gray);
               PicturePanel.setBackground(Gray);
               RBPurple.setBackground(Gray);
               RBBlue.setBackground(Gray);
               RBBlack.setBackground(Gray);
               RBBlack.setForeground(Color.BLACK);
               RBSilver.setBackground(Gray);
               RBWhite.setBackground(Gray);
          }
      }
    }
    
    //------------------------------------------------------------------- GAME
     
     private class DoneButton implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
              if (e.getSource() == DoneButton){
                MonstersLicense License = new MonstersLicense();
                dispose();
              }
      }
    }
  
    private class colorListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
              if(RBPurple.isSelected()){
                  color ="Purple";
                  CodeTextArea.setText("D20\nE16\nF7 F9 F10 F12 F14 F19\nG12 G13\nH16 H17 H19\nI15 I16\nM15 M16\n"
                          + "N16 N18 N19\nP7 P9 P10 P12 P14\nQ16");
              }
              else if(RBBlue.isSelected()){
                  color ="Blue";
                  CodeTextArea.setText("E15 E20\nF6 F8 F11 F15 F16 F20\nG5 G6 G7 G8 G9 G10 G11 G15\nH5 H6 H7 "
                          + "H9 H10 H11 H12 H13 H18 H20\nI5 I6 I7 I8 I9 I10 I11 I12 I13 I17 I18 I19 I20\n"
                          + "J5 J6 J7 J8 J10 J11 J12 J13 J15 J16 J17 J18 J20\nK5 K6 K7 K8 K10 K11 K12 K13 K15 "
                          + "K16 K17 K18\nL5 L6 L7 L8 L10 L11 L12 L13 L15 L16 L17 L18 L20\nM5 M6 M7 M8 M9 M10 M11 M12 M13\n"
                          + "M17 M18 M19 M20\nN5 N6 N7 N9 N10 N11 N12 N13 N17 N20\nO5 O6 O7 O8 O9 O10 O11 O12 O13 O15\n"
                          + "P6 P8 P11 P15 P16\nQ15");
              }
              else if(RBSilver.isSelected()){
                  color ="Silver";
                  CodeTextArea.setText("E3 E4 E5\nF4\nP4\nQ3 Q4 Q5");
              }
              else if(RBBlack.isSelected()){
                  color ="Black";
                  CodeTextArea.setText("C20 C21\nD3 D4 D5 D6 D14 D15 D19 D21\nE2 E6 E7 E8 E9 E10 E11 E12 E14 E17 E19 E21\n"
                          + "F3 F5 F13 F17 F18 F21\nG4 G14 G16 G17 G18 G19 G20\nH4 H8 H14 H15 H21\nI4 I14 I21\n"
                          + "J4 J9 J14 J19 J21\nK4 K9 K14 K19 K20\nL4 L9 L14 L19 L21\nM4 M14 M21\nN4 N8 N14 N15 N21\n"
                          + "O4 O14 O16 O17 O18 O19 O20\nP3 P5 P13 P17\nQ2 Q6 Q7 Q8 Q9 Q10 Q11 Q12 Q14 Q17\n"
                          + "S3 S4 S5 S15 S16");
              }
              else{
                  color ="White";
                  CodeTextArea.setText("");
              
          }
    }}
    private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          if(color == "Purple"){
               for (int i=0;i<504;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Purple);
                   }
               }
          }
          else if(color == "Blue"){
               for (int i=0;i<504;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Blue);
                   }
               }
          }
          else if(color == "Silver"){
               for (int i=0;i<504;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Silver);
                   }
               }
          }
          else if(color == "Black"){
               for (int i=0;i<504;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Color.BLACK);
                   }
               }
          }
          else {
              for (int i=0;i<504;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Color.WHITE);
                   }
               }
          }
      }
    }   
}

    

