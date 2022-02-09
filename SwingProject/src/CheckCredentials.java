import java.io.File;
import java.util.Scanner;

public class CheckCredentials {

	private Scanner x;
	public boolean checkcredentials(String name, String password){
		boolean found  = false;
		 String tempn = "" ;
         String tempp = "";
		 try{
			 x = new Scanner(new File("credentials.txt"));
			 x.useDelimiter("[,\n]");
			 while(x.hasNext() && !found){
				 tempn = x.next();
				 tempp = x.next();
				 if(tempn.trim().equals(name.trim()) && tempp.trim().equals(password.trim())){
					 found = true;
				 }
			 }
			 x.close();
			 
		 }catch(Exception e){
           System.out.println("An error occurred.");			 
		 }
		return found;
	}
}
