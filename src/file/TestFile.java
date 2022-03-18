package file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
	public static void main(String[] args){
		File f1	= new File("E:/project/test.txt");
		// f1的绝对路径
		System.out.println(f1.getAbsolutePath());
		// 是否存在
		System.out.println(f1.exists());
		// 是否是文件夹
		System.out.println(f1.isDirectory());
		// 是否是文件（非文件夹）
		System.out.println(f1.isFile());
		// 文件长度
		System.out.println(f1.length());
		
		long time = f1.lastModified();
		Date d = new Date(time);
		System.out.println(d);
		
//		f1.setLastModified(0);
		
		// 重命名
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
		// JVM结束的时候，刪除文件，常用于临时文件的删除
		f.deleteOnExit();
		
        System.out.println(parent);
        
	}
}
