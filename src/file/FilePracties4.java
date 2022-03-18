package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FilePracties4 {
	public static void main(String[] args) {
		int eachSize = 100 * 1024; // 100k
		File srcFile = new File("E:/project/I2C2W(2021).pdf");
		splitFile(srcFile, eachSize);
	}
	private static void splitFile(File srcFile, int eachSize){
		if(srcFile.length()==0){
			throw new RuntimeException("�ļ�����Ϊ0�����ɲ��");
		}
		byte[] fileContent = new byte[(int)srcFile.length()];
		// ���ļ���ȡ��������
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(srcFile);
			fis.read(fileContent);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) {
					fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		// ������Ҫ�����ֳɶ������ļ�
		int fileNumber;
		if(fileContent.length%eachSize==0) {
			fileNumber = (int)(fileContent.length / eachSize);
		}
		else {
			fileNumber = (int)(fileContent.length / eachSize) + 1;
		}
		
		for(int i=0; i<fileNumber; i++) {
			String eachFileName = srcFile.getName() + "-" + i;
			File eachFile = new File(srcFile.getParent(), eachFileName);
			byte[] eachContent;
			
			if(i!=fileNumber-1) {
				eachContent = Arrays.copyOfRange(fileContent, eachSize*i, eachSize*(i+1));
			} else {
				eachContent = Arrays.copyOfRange(fileContent, eachSize*i, fileContent.length);
			}
			try{
				// д��ȥ
				FileOutputStream fos = new FileOutputStream(eachFile);
				fos.write(eachContent);
				fos.close();
				System.out.printf("������ļ�%s�����С�� %d�ֽ�%n", eachFile.getAbsoluteFile(), eachFile.length());
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}



