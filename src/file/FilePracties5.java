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
			// �ϲ���Ŀ���ļ���
			int index = 0;
			while(true) {
				// ���ļ�
				File eachFile = new File(folder, fileName + "-" + index++);
				if(!eachFile.exists()) break;
				// ��ȡ���ļ�����
				try(FileInputStream fis = new FileInputStream(eachFile);) {
					byte[] eachContent = new byte[(int)eachFile.length()];
					fis.read(eachContent);
					fis.close();
					// �����ļ�����д��ȥ
					fos.write(eachContent);
					fos.flush();
				}
				System.out.printf("�����ļ� %sд����Ŀ���ļ���%n",eachFile);
			}
			fos.close();  
			System.out.printf("���Ŀ���ļ��Ĵ�С��%,d�ֽ�" , destFile.length());
		} catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
		} catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
		}
	}
}
