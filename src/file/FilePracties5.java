package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilePracties5 {
	public static void main(String[] args){
		murgeFile("E:/project", "I2C2W(2021).pdf");
	}
	private static void murgeFile(String folder, String fileName) {
		File destFile = new File(folder, fileName);
		try(FileOutputStream fos = new FileOutputStream(destFile);) {
			// 合并的目标文件夹
			int index = 0;
			while(true) {
				// 子文件
				File eachFile = new File(folder, fileName + "-" + index++);
				if(!eachFile.exists()) break;
				// 读取子文件内容
				try(FileInputStream fis = new FileInputStream(eachFile);) {
					byte[] eachContent = new byte[(int)eachFile.length()];
					fis.read(eachContent);
					fis.close();
					// 把子文件内容写进去
					fos.write(eachContent);
					fos.flush();
				}
				System.out.printf("把子文件 %s写出到目标文件中%n",eachFile);
			}
			fos.close();  
			System.out.printf("最后目标文件的大小：%,d字节" , destFile.length());
		} catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
		} catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
		}
	}
}
