
//package net.QRScanner.qrcode;

/*------------------------------------------------------------------------------------------------------------------------------------------------------------
IO & QR LIBS IMPORTS
----------------------------------------------------------------------------------------------------------------------------------------------------------*/

import java.sql.*;
import java.io.*;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.imageio.ImageIO;
import javax.swing.*;

/*------------------------------------------------------------------------------------------------------------------------------------------------------------
SWING IMPORTS
----------------------------------------------------------------------------------------------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//import net.QRScanner.qrcode.QRCodeJava;


public class GUI implements ActionListener 
{
/*------------------------------------------------------------------------------------------------------------------------------------------------------------
    VARIABLES DEFINITIONs
----------------------------------------------------------------------------------------------------------------------------------------------------------*/

    private JFrame mywindow,f
   ;
    private JPanel panel;
    private JButton submit, reset, exit,setUpButton,printButton,cancelButton,okButton;
    private JTextField num1, num2, num3, num4,num5,num6,num7;
    private JLabel Details, License, User_name, Pan_card, Contact, Vehicle_Type, Balance, VehicleNo;
    double total, numb1, numb2;
    
    PrinterJob printJob;
    PageFormat pageFormat;
    PrintableCanvas printableCanvas;
    
    int k,l;
    
    static String License_no;
    
    static String Username;
    
    static String Pan_no;
    
    static String Contact_no;
    
    static String vehicle_type;
    
    static String balance;
    
    static String Vehicle_no;
    
    String qrfeed;
    
    String hostname = "localhost";
    String username = "postgres";
    String password = "1234";
    String dbName = "postgres";

    String connectionUrl = "jdbc:postgresql://" + hostname +  "/" + dbName;
    Connection con = null;
/*------------------------------------------------------------------------------------------------------------------------------------------------------------
    CONSTRUCTORS
-------------------------------------------------------------------------------------------------------------------------------------------------------------*/    
	    public GUI() throws Exception
	    {
	        GUI();
	        mywindow.setVisible(true);
	    }
    
//*******************************************************************************************************************************************************************//
	    public final void GUI() throws Exception
	    {
	    	
//Creates window
        mywindow = new JFrame();
        mywindow.setSize(600, 600);
        mywindow.setTitle("TOLL FLASH");
        mywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        printJob = PrinterJob.getPrinterJob();
        pageFormat = printJob.defaultPage();

//Creates Panel.
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

//This line of code create the spacing between the components in panel.
        c.insets = new Insets(10, 10, 10, 10 ); 
        
 //******************************************************************************************************************************************************************//
//     LABELS
//******************************************************************************************************************************************************************//
		//label 1
		c.gridx = 1;
		c.gridy = 1;
		Details = new JLabel("Enter your details for TOLL FLASH registration");
		panel.add(Details, c);      
		        
		//Label 2
		c.gridx = 0;
		c.gridy = 2;
		License = new JLabel("License No");
		panel.add(License, c);
		
		//Label 3
		c.gridx = 0;
		c.gridy = 3;
		User_name = new JLabel("User Name");
		panel.add(User_name, c);
		
		//Label 4
		c.gridx = 0;
		c.gridy = 4;
		Pan_card = new JLabel("Pan Card No");
		panel.add(Pan_card, c);
		
		//Label 5
		c.gridx = 0;
		c.gridy = 5;
		Contact = new JLabel("Contact No");
		panel.add(Contact, c);
		
		//Label 6
		c.gridx = 0;
		c.gridy = 6;
		Vehicle_Type = new JLabel("Vehicle Type");
		panel.add(Vehicle_Type, c);
		
		//Label 7
		c.gridx = 0;
		c.gridy = 7;
		Balance = new JLabel("Balance");
		panel.add(Balance, c);
		
		////////////////////////////////////////////////////////////////////////////////////
		c.gridx = 0;
		c.gridy = 8;
		VehicleNo = new JLabel("Vehicle No");
		panel.add(VehicleNo, c);		
		
//*********************************************************************************************************************************************************************//
//                      TEXT FIELDS
//********************************************************************************************************************************************************************//                                
        //For the "First" Field and label.	  
        c.gridx = -1;
        c.gridy = 2;
        num1 = new JTextField(10);
        panel.add(num1, c);
        
        //For the "second" Field and label.	  
        c.gridx = -1;
        c.gridy = 3;
        num2 = new JTextField(10);
        panel.add(num2, c);
        
        //For the "third" Field and label.	  
        c.gridx = -1;
        c.gridy = 4;
        num3 = new JTextField(10);
        panel.add(num3, c);
        
        //For the "fourth" Field and label.	  
        c.gridx = -1;
        c.gridy = 5;
        num4 = new JTextField(10);
        panel.add(num4, c);
        
      //For the "fifth" Field and label.	  
        c.gridx = -1;
        c.gridy = 6;
        num5 = new JTextField(10);
        panel.add(num5, c);
        
      //For the "sixth" Field and label.	  
        c.gridx = -1;
        c.gridy = 7;
        num6 = new JTextField(10);
        panel.add(num6, c);
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        c.gridx = -1;
        c.gridy = 8;
        num7 = new JTextField(10);
        panel.add(num7, c);
//*******************************************************************************************************************************************************************//
//                       BUTTONS
//*******************************************************************************************************************************************************************//            
        //For the "Calculate" Button.
        c.gridx = 0;
        c.gridy = 9;
        submit = new JButton("Submit");
        panel.add(submit, c);
        
        //For the "Reset" Button.
        c.gridx = 1;
        c.gridy = 9;
        reset = new JButton("Reset");
        panel.add(reset, c);
             
        //For the "Exit" Button.
        c.gridx = 2;
        c.gridy = 9;
        exit = new JButton("Exit");
        panel.add(exit, c);
//*****************************************************************************************************************************************************************//
//****************************************************************************************************************************************************************//
        
//This adds the panel into the frame.
        Component add = mywindow.add(panel);

//*****************************************************************************************************************************************************************//

        //This controls what happens when user clicks on the "submit" button.
        
        submit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent myevent) 
            {
                License_no = num1.getText();
                            
                Username = num2.getText();
                
                Pan_no = num3.getText();
                
                Contact_no = num4.getText();
                
                vehicle_type = num5.getText();
                
                balance = num6.getText();
                
                Vehicle_no=num7.getText();
   //This will display the result in a pop up window (Dialog box)    
                
	   JOptionPane.showMessageDialog(null, "Your License_no: "+License_no+"\n"+"Username: "+Username+"\n"+"Pan card no: "+Pan_no+"\n"+"Contact no: "+Contact_no+"\n"+"Vehicle Type: "+vehicle_type+"\n"+"Balance: "+balance+"\n"+"Vehicle No: "+Vehicle_no);
	   

	   
	   //This takes user details and stores in QRFeed as a Primary key to Database 
	   
	   qrfeed=License_no+Username+Pan_no+Contact_no+vehicle_type+Vehicle_no;
	   
	   //This QR Code library function to generate qr code from given data
	   
	   ByteArrayOutputStream out = QRCode.from(License_no+Username+Pan_no+Contact_no+vehicle_type+Vehicle_no).to(ImageType.PNG).stream();

		
       
			try{
				
			//tells to generate	PNG image as per the data given by user
				
			FileOutputStream fout = new FileOutputStream(new File("D:\\QR_Code.PNG"));
			
			//Stores user information in the PNG Image
			fout.write(out.toByteArray());
			
			fout.flush();
			fout.close();
			
			//Use of swing to display the QR Code Generated
			String path = "D:\\QR_Code.PNG";
	    	File file = new File(path);
	    	BufferedImage image = ImageIO.read(file);
	    	JLabel label = new JLabel(new ImageIcon(image));
			
			f = new JFrame();
			setUpButton = new JButton("Page Setup");
			printButton = new JButton("Print");
			cancelButton = new JButton("Close");
			okButton =new JButton("Ok");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panels = new JPanel(new FlowLayout());
			panels.add(label);
			panels.add(okButton);
			panels.add(setUpButton);
			panels.add(printButton);
			panels.add(cancelButton);
			
			okButton.addActionListener(new ActionListener(){
	             public void actionPerformed(ActionEvent myevent){
	            	 try{ 
	 	                Class.forName("org.postgresql.Driver");
	 	       	        con = DriverManager.getConnection(connectionUrl,username, password);
	 	       	        Statement st = con.createStatement();
	 	       	       JOptionPane.showMessageDialog(null,"im here");
	 	       	        k=st.executeUpdate("insert into  qrdetails values('"+qrfeed+"',"+License_no+",'"+Username+"','"+Pan_no+"',"+Contact_no+",'"+vehicle_type+"','"+Vehicle_no+"')");
	 	       	        l=st.executeUpdate("insert into  amtdetails values('"+qrfeed+"','"+vehicle_type+"',"+balance+",'"+Vehicle_no+"')");
	 	       	        JOptionPane.showMessageDialog(null,"Data is successfully saved");
	 	       	        System.out.println("Data is successfully saved");
	 	       	        ResultSet rs = st.executeQuery("");
	 	                  }
	 	                  catch(Exception eee){}
	                 
	             }});
			
			
			setUpButton.addActionListener(new ActionListener(){
	             public void actionPerformed(ActionEvent myevent){
	            	 pageFormat = printJob.pageDialog(pageFormat);
	                 printJob.validatePage(pageFormat);
	                 
	             }});
	        
	        printButton.addActionListener(new ActionListener()
	        		{
	             public void actionPerformed(ActionEvent myevent){
	            	 try{
	            	 printableCanvas = new PrintableCanvas(pageFormat);
	            	 }
	            	 catch(Exception ee)
	            	 {}
	                 printJob.setPrintable(printableCanvas);
	         boolean ok = printJob.printDialog();
	                 if (ok) {
	                   try {
	                     printJob.print();
	                   } catch (Exception pe) {
	                     System.out.println("Printing Exception Occured!");
	                     pe.printStackTrace();
	                   }
	                  try{ 
	                Class.forName("org.postgresql.Driver");
	       	        con = DriverManager.getConnection(connectionUrl,username, password);
	       	        Statement st = con.createStatement();
	       	       // JOptionPane.showMessageDialog(null,"im here");
	       	        k=st.executeUpdate("insert into  qrdetails values('"+qrfeed+"',"+License_no+",'"+Username+"','"+Pan_no+"',"+Contact_no+",'"+vehicle_type+"','"+Vehicle_no+"')");
	       	        l=st.executeUpdate("insert into  amtdetails values('"+qrfeed+"','"+vehicle_type+"',"+balance+",'"+Vehicle_no+"')");
	       	        JOptionPane.showMessageDialog(null,"Data is successfully saved");
	       	        System.out.println("Data is successfully saved");
	       	        ResultSet rs = st.executeQuery("");
	                  }
	                  catch(Exception eee){}
	                   
	                   
	                   //JOptionPane.showMessageDialog(null, "DATA is Saved");
	             }}});
	   
	        cancelButton.addActionListener(new ActionListener(){
	             public void actionPerformed(ActionEvent myevent){
	            	 JOptionPane.showMessageDialog(null, "DATA is Saved");
	            	 //System.exit(0);
	            	 f.setVisible(false);
	             }});
			
			
			f.getContentPane().add(panels);
			f.pack();
			f.setLocation(550, 275);
			f.setVisible(true);	
			
	       


			} 
			catch (Exception e) {
			 //Do Logging
	             System.out.print(e);
			e.printStackTrace();
			}
   
 }
            
//******************************************************************************************************************************************************************//    
});
      //This controls what happens when user clicks on the "reset" button. 
         reset.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent myevent){
                 num1.setText("");
                 num2.setText("");
                 num3.setText("");
                 num4.setText("");
                 num5.setText("");
                 num6.setText("");
                 num7.setText("");
             }
             
//*************************************************************************************************************************************************************************//    
//This controls what happens when user clicks on the "Exit" Button.             
    });
         exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent myevent){
                System.exit(0);
            } 
         });
    }

//****************************************************************************//
                        //Main
    public static void main(String[] args)throws Exception 
    {
    	
     GUI frametest = new GUI();
     
     
     
     
     
     
//****************************************************************************//                
}
    
    public void actionPerformed(ActionEvent e) {
    	
    }
}

class DrawingCanvas extends JPanel {
	  Font font;
	FontMetrics fontMetrics;
	int w, h;
	String path = "D:\\QR_Code.PNG";
	File file = new File(path);
	BufferedImage image = ImageIO.read(file);
	JLabel label = new JLabel(new ImageIcon(image));
	DrawingCanvas()throws Exception {
		
		
		
	    setBackground(Color.white);
	    setSize(400, 275);
	w = this.getWidth();
	    h = this.getHeight();
	font = new Font("Dialog", Font.BOLD, 50);
	    fontMetrics = getFontMetrics(font);
	  }
	public void paintComponent(Graphics g) {
	    super.paintComponent(g); 
	    Graphics2D g2D = (Graphics2D) g;
	paintContent(g2D, w, h);
	  }
	public void paintContent(Graphics2D g2D, int w, int h) {
	    g2D.setFont(font);
	
	g2D.drawImage(image,100,100,null);
	}
	}
	class PrintableCanvas implements Printable {
	  DrawingCanvas canvas;
	PageFormat pageFormat;
	public PrintableCanvas(PageFormat pf)throws Exception {
	    pageFormat = pf;
	  }
	public int print(Graphics g, PageFormat pageFormat, int pageIndex)
	      throws PrinterException {
	    if (pageIndex >= 1) {
	      return Printable.NO_SUCH_PAGE;
	    }
	Graphics2D g2D = (Graphics2D) g;
	try{
	canvas = new DrawingCanvas();
	}
	catch(Exception ii){}
	canvas.paintContent(g2D, (int) pageFormat.getImageableWidth(),
	        (int) pageFormat.getImageableHeight());
	// successful printing of the page
	    return Printable.PAGE_EXISTS;
	  }
	}
