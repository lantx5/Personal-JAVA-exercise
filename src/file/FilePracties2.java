package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FilePracties2 {
	public static void main(String[] args){
		try{
			File f = new File("E:/project/test.txt");
			// ��������ȡ���ڴ�
			FileInputStream fis = new FileInputStream(f);
			// ��jvm�ڴ����뵽Ӳ���ļ�
			FileOutputStream fos = new FileOutputStream(f);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
