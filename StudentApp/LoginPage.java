import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*; 
import java.util.*;
import JDBCcon.*;

class LoginPage extends JFrame implements ActionListener{
	JFrame f;
	String checkN , checkP;
	JLabel rn , ps, bc,l;
	JButton jb1,jb2;
	JTextField n  ;
	JPasswordField p;
	ImageIcon ic;
	LoginPage(){
	   setTitle("LoginPage");
	   setSize(600,500);
	   setLayout(null);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   rn  = new JLabel("Register No.");
	   ps  = new JLabel("Password");
	   jb1 = new JButton("Login");
	   jb2 = new JButton("New User");
	   ic = new ImageIcon("login11.jpg");
	   bc = new JLabel(ic);
	   n = new JTextField();
	   p = new JPasswordField();
	   setLayout(new BorderLayout());
	   setContentPane(bc);
       setLayout(null);
	   rn.setBounds(10 , 300 , 100 , 20);
	   add(rn);
	   ps.setBounds(10 , 350 ,100,20);
	   add(ps);
	   jb1.setBounds(10 ,400 ,100, 30);
	   add(jb1);
	   jb2.setBounds(110 ,400 ,100, 30);
	   add(jb2);
	   n.setBounds(110 , 300 , 100 ,20);
	   add(n);
	   p.setBounds(110 , 350 ,100,20);
	   add(p);
	   jb1.addActionListener(this);  
       jb2.addActionListener(this);	 
       setVisible(true);
	   setResizable(false);
	}
	public void actionPerformed(ActionEvent ae){
		   if(ae.getSource() == jb1 ){
			   checkN = n.getText();
			   checkP = String.valueOf(p.getPassword());
			   CheckCredentials cc = new CheckCredentials();
			   if(cc.checkcredentials(checkN , checkP)){
				   n.setText("");
				   p.setText("");
				   AfterLogin al = new AfterLogin(checkN);
			   }
			   else{
				   f=new JFrame();  
                   JOptionPane.showMessageDialog(f,"Invalid RegisterNo. or password","Alert",JOptionPane.WARNING_MESSAGE);
			   }
		   }
		   else if(ae.getSource() == jb2){
			   NewUser nu = new NewUser();
		   }
	}
	
	public static void main(String args[]){
		Connect con  = new Connect();
		con.CreateTable();
		CreateFile cf = new CreateFile();
        LoginPage sr =new LoginPage();
		
	}   
    
}




	
	