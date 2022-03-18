package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TestStream1 {
	public static void main(String[] args) {
		File f = new File("E:/project/test.txt");
		try(FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr)) {
			while(true) {
				String line = br.readLine();
				if(line==null) break;
				System.out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
