import java.io.File;
import java.io.IOException;

public class CreateFile{
	CreateFile(){
	  try {
        File myObj = new File("credentials.txt");
		if(!myObj.exists()) {
            myObj.createNewFile();
         }
      } catch (IOException e) {
           System.out.println("An error occurred.");
        }
	}
}
