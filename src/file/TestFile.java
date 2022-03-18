package file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
	public static void main(String[] args){
		File f1	= new File("E:/project/test.txt");
		// f1�ľ���·��
		System.out.println(f1.getAbsolutePath());
		// �Ƿ����
		System.out.println(f1.exists());
		// �Ƿ����ļ���
		System.out.println(f1.isDirectory());
		// �Ƿ����ļ������ļ��У�
		System.out.println(f1.isFile());
		// �ļ�����
		System.out.println(f1.length());
		
		long time = f1.lastModified();
		Date d = new Date(time);
		System.out.println(d);
		
//		f1.setLastModified(0);
		
		// ������
//		File f2 =new File("E:/project/test2.txt");
//      f1.renameTo(f2);
		
		File f = new File("E:/project/test.txt");
		File[] fs = f.listFiles();
		String parent = f.getParent();
		f.getParentFile();
		f.mkdir();
		f.mkdirs();
//		f.createNewFile();
		f.listRoots();
		f.delete();
		// JVM������ʱ�򣬄h���ļ�����������ʱ�ļ���ɾ��
		f.deleteOnExit();
		
        System.out.println(parent);
        
	}
}
