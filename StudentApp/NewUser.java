import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUser extends JFrame{
		JLabel setr, setp;
		JButton okb;
		JTextField typer  ;
    	JPasswordField typep;
	    NewUser(){
		   setTitle("NewUser");
	       setSize(300,300);
	       setLayout(null);
           setVisible(true);
	       setResizable(false);
	       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       setr = new JLabel("Register No");
		   setp = new JLabel("set password");
		   typer = new JTextField();
		   typep = new JPasswordField();
		   okb = new JButton("OK");
		   setr.setBounds(40, 60 , 100,20);
		   add(setr);
		   setp.setBounds(40, 120, 100,20);
		   add(setp);
		   typer.setBounds(120,60,100,20);
		   add(typer);
		   typep.setBounds(120,120,100,20);
		   add(typep);
		   okb.setBounds(130,210 , 60,20);
		   add(okb);
		   okb.addActionListener(new ActionListener()
		   {

			   CheckCredentials cc = new CheckCredentials();
			   public void actionPerformed(ActionEvent e){
				   String whatr = typer.getText();
				   String whatp = String.valueOf(typep.getPassword());
				   if(!cc.checkcredentials(whatr ,whatp)){
				    try {
						 String data = whatr +","+whatp+"\n";
						 FileWriter fileWritter = new FileWriter("credentials.txt",true);
                         BufferedWriter bw = new BufferedWriter(fileWritter);
                         bw.write(data);
                         bw.close();
                    } catch (IOException ioe) {
                         System.out.println("An error occurred.");
                      }
			       }
				   dispose();
			   }
		   });
	    }
    }