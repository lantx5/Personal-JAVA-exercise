package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilePracties3 {
	public static void main(String[] args){
		try{
			File f = new File("d:/xyz/abc/testpracties.txt");
			File dir = f.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			byte data[] = {88, 89};
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(data);
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
