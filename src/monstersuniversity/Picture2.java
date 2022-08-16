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
 * This Frame for Picture 2 , this frame is the game , the user have
 * to choice a color from the radio buttons 
 * the code of the color will display in the text area , the user will click 
 * the buttons to chinge the color 
 * and finaly when the user finshing and the picture complete , 
 * click to the Done button.
 */
public class Picture2 extends JFrame {
    
     //frame componants
    private JLabel ColumnLabel , PictureLabel;
    private JRadioButton RBLightGreen , RBGreen , RBDarkGreen , RBBlack , RBWhite , RBBrown , RBBlue;
    private JButton DoneButton;
    private ImageIcon PictureIcon;
    private ButtonGroup RBGroup;
    private JPanel FramePanel , ColoringPanel , boardPanel , RowPanel , ColorPanel , GamePanel , PicturePanel;
    private JScrollPane CodeScroll;
    private JTextArea CodeTextArea;
    
    private JButton [] Buttons;
    private JLabel [] Rows;
    
    //new Colors
    private Color LightGreen , Green , DarkGreen , Brown , Blue , LightGray , Gray;
    private String color;
    
    // mneu
    private JMenuBar MenuBar;
    private JMenu FileMenu , EditMenu , HelpMenu;
    private JMenuItem CloseItem , AboutItem , BackItem , HomeItem;
    private JCheckBoxMenuItem DarkModeItem ;
    
    //--------------------------------------------------------------------------
    
    /*
     * Constructr
     */
    public Picture2(){
        
        //Frame character
        setTitle(" Monsters University ");
        setSize(650,500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
        setLocationRelativeTo(null);
        
        //----------------------------------------------------
        
        FramePanel = new JPanel();
        FramePanel.setLayout(new BorderLayout(10,10));
        
        //----------------------------------------------------
        
        //creat the colors
        Green = new Color(120,190,25);
        LightGreen = new Color(154,205,50);
        DarkGreen = new Color(0,128,0);
        Brown = new Color(255,222,173);
        Blue = new Color(70,130,180);
        LightGray = new Color(220,220,220);
        
        //----------------------------------------------------
        
        //Bulid methods
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
        
        //Visible the frame
        setVisible(true);
    }
    
    //--------------------------------------------------------------------------
    
     public void BulidGamePanel(){
         
         GamePanel = new JPanel();
         GamePanel.setLayout(new GridLayout(2,0,4,4));
         
        //----------------------------------------------------
         
        //Done BUtton
         DoneButton = new JButton("Done");
         DoneButton.setBackground(LightGreen);
         DoneButton.setForeground(Color.WHITE);
         DoneButton.setFont(new Font("Ink Free",Font.BOLD,20));
         DoneButton.addActionListener(new DoneButton());
         
         // the pic
         PictureIcon = new ImageIcon("Picture2Lines.jpg");
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
         
         //add to the panel
         GamePanel.add(PicturePanel);   
         GamePanel.add(CodeScroll);
     }
     
     //-------------------------------------------------------------------------
     
     public void BulidColorPanel(){
         
         ColorPanel = new JPanel();
         RBGroup = new ButtonGroup();
         
        //----------------------------------------- radio Buttton Colors:
         
         RBLightGreen = new JRadioButton ("Ligth Green");
         RBLightGreen.setForeground(LightGreen);
         RBLightGreen.setFont(new Font("MV Boli",Font.BOLD,15));
         RBLightGreen.addActionListener(new colorListener());
         RBGroup.add(RBLightGreen);
        
         RBGreen = new JRadioButton ("Green");
         RBGreen.setForeground(Green);
         RBGreen.setFont(new Font("MV Boli",Font.BOLD,15));
         RBGreen.addActionListener(new colorListener());
         RBGroup.add(RBGreen);
         
         RBDarkGreen = new JRadioButton ("Dark Green");
         RBDarkGreen.setForeground(DarkGreen);
         RBDarkGreen.setFont(new Font("MV Boli",Font.BOLD,15));
         RBDarkGreen.addActionListener(new colorListener());
         RBGroup.add(RBDarkGreen);
         
         RBBrown = new JRadioButton ("Brown");
         RBBrown.setForeground(Brown);
         RBBrown.setFont(new Font("MV Boli",Font.BOLD,15));
         RBBrown.addActionListener(new colorListener());
         RBGroup.add(RBBrown);
         
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
         
        //----------------------------------------------------
         
        // add the color to the panel
         ColorPanel.add(RBLightGreen);
         ColorPanel.add(RBGreen);
         ColorPanel.add(RBDarkGreen);
         ColorPanel.add(RBBrown);
         ColorPanel.add(RBBlue);
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
       
        Rows = new JLabel[19];
        
        for (int i=0;i<19;i++){
            String Number = String.valueOf(i);
        Rows[i] = new JLabel(Number);
        Rows[i].setFont(new Font("MV Boli",Font.BOLD,11));
        Rows[i].setForeground(LightGreen);
        RowPanel.add(Rows[i]);
        }
       
       //------------------------------------------------
       
       //ColumnLabel
       ColumnLabel = new JLabel("    A  B   C  D   E   F  G  H   I   J  K  L  M   N  O  P   Q  R");
       ColumnLabel.setFont(new Font("MV Boli",Font.BOLD,11));
       ColumnLabel.setForeground(LightGreen);
       
       //------------------------------------------------
        
       //Playing Area
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(19,15)); 
       
        Buttons = new JButton[342];
        
        for (int i=0;i<342;i++){
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
               RBLightGreen.setBackground(Color.BLACK); 
               RBGreen.setBackground(Color.BLACK);
               RBDarkGreen.setBackground(Color.BLACK);
               RBBrown.setBackground(Color.BLACK);
               RBBlue.setBackground(Color.BLACK);
               RBBlack.setBackground(Color.BLACK);
               RBBlack.setForeground(Color.GRAY);
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
               RBLightGreen.setBackground(Gray); 
               RBGreen.setBackground(Gray);
               RBDarkGreen.setBackground(Gray);
               RBBrown.setBackground(Gray);
               RBBlue.setBackground(Gray);
               RBBlack.setBackground(Gray);
               RBBlack.setForeground(Color.BLACK);
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
         
              if(RBLightGreen.isSelected()){
                  color ="LightGreen";
                  CodeTextArea.setText("E7 E8 E9 E10\nF10 F11\nG11 G12 G15 G16 G17\n H11 H12 "
                          + " \nI11\nJ11\nK3 K11\n L3 L4 L10 L11 L15 L16 L17\nM4 M5 M6 "
                          + "M7 M8 M9 M10\nN4 N5 N6 N7 N8 N9 N10 N12\n" + "O6 O7 O8 O9\nP9 P10"
                          + "\nQ11 Q12 Q13 Q14 Q15");
              }
              else if(RBGreen.isSelected()){
                  color ="Green";
                  CodeTextArea.setText("B11 B12 B13 B14 B15\nC9 C10\nD6 D7 D8 D9\nE4 E5 E6"
                          + " E11 E12\nF3 F4 F12 F13\nG2 G3 G5 G13\n H2 H4 H13\n"
                          + "I2 I4 I18\nJ2 J4 J13\nK2 K5 K13\nL2 L13\nM3 M13");
              }
              else if(RBDarkGreen.isSelected()){
                  color ="DarkGreen";
                  CodeTextArea.setText("D10 D11\nF5 F17\nG4 G14\nH3 H5\nI3 I5\nJ3 J5\n"
                          + "K4\nL5 L14\nM17\nO10 O11");
              }
              else if(RBBlack.isSelected()){
                  color ="Black";
                  CodeTextArea.setText("A11 A12 A13 A14 A15\nB9 B10 B16\nC6 C7 C8 C11 C12 C13 C14 C15 C16\n"
                          + "D4 D5 D12\nE0 E1 E2 E3 E13 E17 E18\nF0 F14 F15 F16 F18\nG1 G18\nH1 H14 H15 H16 H17 H18\n"
                          + "I1 I7 I14\nJ1 J14\nK1 K14 K15 K16 K17 K18\nL1 L18\nM0 M14 M15 M16 M18\n"
                          + "N0 N1 N2 N3 N13 N17 N18\nO4 O5 O12\nP6 P7 P8 P11 P12 P13 P14 P15 P16\nQ9 Q10 "
                          + "Q16\nR11 R12 R13 R14 R15");
              }
              else if(RBBlue.isSelected()){
                   color ="Blue";
                  CodeTextArea.setText("H6 H7 H8 \nI6 I8 \nJ6 J7 J8");
              }
              else if(RBBrown.isSelected()){
                  color ="Brown";
                  CodeTextArea.setText("F1 F2 \nM1 M2");
              }
              else {
                  color ="White";
                  CodeTextArea.setText("");
              }
          }
    }
    private class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          
          if(color == "LightGreen"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(LightGreen);
                   }
               }
          }
          else if(color == "Green"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Green);
                   }
               }
          }
          else if(color == "DarkGreen"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(DarkGreen);
                   }
               }
          }
          else if(color == "Black"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Color.BLACK);
                   }
               }
          }
          else if(color == "White"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Color.WHITE);
                   }
               }
          }
          else if(color == "Brown"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       //if(e.getSource() == Buttons[23]){
                          Buttons[i].setBackground(Brown);
                    }
                       //else
                          // Buttons[i].setBackground(Color.WHITE);
                   
               }
          }
          else if(color == "Blue"){
               for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Blue);
                   }
               }
          }
          else {
              for (int i=0;i<342;i++){
                   if(e.getSource() == Buttons[i]){
                       Buttons[i].setBackground(Color.WHITE);
                   }
               }
          }
      } 
    }
    
}
