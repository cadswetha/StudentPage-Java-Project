import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AfterLogin extends JFrame implements ActionListener{
	JFrame f;
    JLabel lname , lid , ldob, lgender , lmail,lcNo ,lbranch,lcgpa,lbc ,logo ;
	JRadioButton jrb1,jrb2,jrb3;
	ButtonGroup bg1 , bg2;
	JTextField tn ,ti , tm,tcon,tc;
	JCheckBox jcb1, jcb2, jcb3 ,jcb4;
	JPanel p1 ,p;
	JButton AddRecord, Clear , Update ,logout;
	JComboBox<String> jcmb1,jcmb2,jcmb3,jcmb4,jcmb5,jcmb6;
	ImageIcon ic1,ic2;
	
	String degree[]={"B.Tech","B.E" , "Law" , "B.Com" };
	String dat[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String year[]={"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};
	
	AfterLogin(String regno){
	    setTitle("StudentInfo");
	    setSize(700,600);
	    setLayout(null);
            setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	   
		//imageicon
		ic2 = new ImageIcon("SASTRALOGO.png");
		logo = new JLabel(ic2);
		logo.setBounds(100,5,475,100);
		add(logo);
		
		//jlables
		lname = new JLabel("Name");
		lname.setBounds(50 , 170 ,100,30);
		add(lname);
		lid = new JLabel("RegisterNo");
		lid.setBounds(50 , 120 ,100,30);
		add(lid);
		ldob = new JLabel("DOB");
		ldob.setBounds(50 , 220 ,100,30);
		add(ldob);
		lgender = new JLabel("Gender");
		lgender.setBounds(50,270,100,30);
		add(lgender);
		lmail = new JLabel("E-mail");
		lmail.setBounds(50 , 320,100,30);
		add(lmail);
		lcNo = new JLabel("Contact No.");
		lcNo.setBounds(50,370,100,30);
		add(lcNo);
		lbranch = new JLabel("Degree");
		lbranch.setBounds(50,420,100,30);
		add(lbranch);
		lcgpa = new JLabel("CGPA");
		lcgpa.setBounds(50 , 470 ,100,30);
		add(lcgpa);
		
		//textareaas
		tn = new JTextField();
		tn.setBounds(170,170,150,30);
		add(tn);
		ti = new JTextField();
		ti.setBounds(170 ,120,150,30);
		ti.setText(regno);
		add(ti);
		tm = new JTextField();
		tm.setBounds(170 ,320,150,30);
		add(tm);
		tcon = new JTextField();
		tcon.setBounds(170 ,370,150,30);
		add(tcon);
		tc = new JTextField();
		tc.setBounds(170 ,470,150,30);
		add(tc);
		
		//radiobuttons
		jrb1=new JRadioButton("M");
		jrb1.setBounds(170,270,60,30);
                jrb2=new JRadioButton("F");
		jrb2.setBounds(230,270,60,30);
		jrb3 = new JRadioButton("Other");
		jrb3.setBounds(290,270,60,30);
                bg1=new ButtonGroup();
                bg1.add(jrb1);
                bg1.add(jrb2);
		bg1.add(jrb3);
                add(jrb1);
                add(jrb2);
		add(jrb3);
		
		//combobox
		jcmb1=new JComboBox<String>(degree);
                jcmb1.setBounds(170,420,80,30);
       		add(jcmb1);
        	jcmb4=new JComboBox<String>(dat);
        	jcmb4.setBounds(170 , 220 ,60,30);
        	add(jcmb4);
        	jcmb5=new JComboBox<String>(month);
        	jcmb5.setBounds(230 , 220 ,60,30);
        	add(jcmb5);
        	jcmb6=new JComboBox<String>(year);
        	jcmb6.setBounds(290 , 220 ,60,30);
        	add(jcmb6);
		
		//imageicon
	    	ic1 = new ImageIcon("login.jpg");
	    	lbc = new JLabel(ic1);
		lbc.setBounds(370,150,300,200);
		add(lbc);
		
		//JButton
		AddRecord = new JButton("Add Record");
		AddRecord.setBounds(390,400 , 100,30);
		AddRecord.addActionListener(this);
		Clear = new JButton("Clear");
		Clear.setBounds(450,440 , 100,30);
		Clear.addActionListener(this);
		Update = new JButton("Update");
		Update.setBounds(500,400 , 100,30);
		Update.addActionListener(this);
		logout = new JButton("LogOut");
		logout.setBounds(300,510,100,30);
		logout.addActionListener(this);
		add(logout);
		add(AddRecord);
		add(Clear);
		add(Update);
		
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == AddRecord){
			f=new JFrame();  
            		JOptionPane.showMessageDialog(f,"Details Successfully Added!"); 
		}
		else if(ae.getSource() == logout){
			dispose();
		}
		else if(ae.getSource() == Clear){
			tn.setText("");
			tm.setText("");
			tcon.setText("");
			tc.setText("");
			f=new JFrame(); 
            		JOptionPane.showMessageDialog(f,"Data Cleared!"); 
		}
		else if(ae.getSource() == Update){
			f=new JFrame();  
            		JOptionPane.showMessageDialog(f,"Details Updated!"); 
		}
		
	}
}
