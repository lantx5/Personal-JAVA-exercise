package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FilePracties2 {
	public static void main(String[] args){
		try{
			File f = new File("E:/project/test.txt");
			// 输入流读取到内存
			FileInputStream fis = new FileInputStream(f);
			// 从jvm内存输入到硬盘文件
			FileOutputStream fos = new FileOutputStream(f);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
