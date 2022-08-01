import java.awt.event.*;
import JDBCcon.*;
import javax.swing.*;
import java.sql.*;

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
	Connect con = new Connect();
	String degree[]={"B.Tech","B.E" , "Law" , "B.Com" };
	String dat[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String month[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
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
		String name="", mail="", contact="", cgpa="", gender="M", deg="B.Tech", d="1", m="Jan", y ="1995";
		String query = "select name, EXTRACT(year FROM dob),to_char( dob, 'MON' ) ,EXTRACT(day FROM dob),gender,mail,contact,degree,cgpa from studentdetails where regno='"+regno+"'";
		try{
			ResultSet rs = con.stm.executeQuery(query);
			if(rs!=null){
				while(rs.next()){
					name = rs.getString(1);
					y = rs.getString(2);
					m = rs.getString(3);
					d = rs.getString(4);
					gender = rs.getString(5);
					mail = rs.getString(6);
					contact = rs.getString(7);
					deg = rs.getString(8);
					cgpa = rs.getString(9);
				}
			}
		}catch(Exception e){System.out.println(e);}
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
		tn.setText(name);
		ti = new JTextField();
		ti.setBounds(170 ,120,150,30);
		ti.setText(regno);
		add(ti);
		tm = new JTextField();
		tm.setBounds(170 ,320,150,30);
		add(tm);
		tm.setText(mail);
		tcon = new JTextField();
		tcon.setBounds(170 ,370,150,30);
		add(tcon);
		tcon.setText(contact);
		tc = new JTextField();
		tc.setBounds(170 ,470,150,30);
		add(tc);
		tc.setText(cgpa);

		//radiobuttons
		jrb1=new JRadioButton("M");
		jrb1.setActionCommand( jrb1.getText() );
		jrb1.setBounds(170,270,60,30);
		jrb2=new JRadioButton("F");
		jrb2.setActionCommand( jrb2.getText() );
		jrb2.setBounds(230,270,60,30);
		jrb3 = new JRadioButton("Other");
		jrb3.setActionCommand( jrb3.getText() );
		jrb3.setBounds(290,270,60,30);
		bg1=new ButtonGroup();
		bg1.add(jrb1);
		bg1.add(jrb2);
		bg1.add(jrb3);
		add(jrb1);
		add(jrb2);
		add(jrb3);
		if (gender.equals("M")) {
			jrb1.setSelected(true);
		} else if(gender.equals("F")){ 
			jrb2.setSelected(true);
		}else{
			jrb3.setSelected(true);
		}

		//combobox
		jcmb1=new JComboBox<String>(degree);
		jcmb1.setBounds(170,420,80,30);
		add(jcmb1);
		jcmb1.setSelectedItem(deg);
		jcmb4=new JComboBox<String>(dat);
		jcmb4.setBounds(170 , 220 ,60,30);
		add(jcmb4);
		jcmb4.setSelectedItem(d);
		jcmb5=new JComboBox<String>(month);
		jcmb5.setBounds(230 , 220 ,60,30);
		add(jcmb5);
		jcmb5.setSelectedItem(m);
		jcmb6=new JComboBox<String>(year);
		jcmb6.setBounds(290 , 220 ,60,30);
		add(jcmb6);
		jcmb6.setSelectedItem(y);

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
		String regno = ti.getText();
		String name = tn.getText();
		String mail= tm.getText();
		String contact = tcon.getText();
		String cgpa = tc.getText();
		String gender = bg1.getSelection().getActionCommand() ;
		String deg =  jcmb1.getSelectedItem().toString() ;
		String dob = jcmb4.getSelectedItem().toString()+'-'+jcmb5.getSelectedItem().toString()+'-'+jcmb6.getSelectedItem().toString();
		if(ae.getSource() == AddRecord){
			String query = "INSERT INTO STUDENTDETAILS VALUES ('" +regno+"','"+name+"','"+dob+"','"+gender+"','"+mail+"','"+contact+"','"+deg+"','"+cgpa+"')";
			int d=0;
			try{
				d = con.stm.executeUpdate(query);
			}catch(Exception e){
				System.out.println(e);
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"This record already exists! Please update if any changes"); 
			}
			if(d==1){
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Details Successfully Added!"); 
			}
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
			String query = "UPDATE studentdetails SET name ='"+name+"',dob='"+dob+"',gender='"+gender+"',mail='"+mail+"',contact='"+contact+"',degree='"+deg+"',cgpa='"+cgpa+"' WHERE regno='"+regno+"'";
			int d=0;
			try{
				d = con.stm.executeUpdate(query);
			}catch(Exception e){
				System.out.println(e);
			}
			if(d==1){				
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Details Updated!"); 
			}
			else{
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Data does not exist! Please add record before updating!"); 
			}
		}
		
	}
}