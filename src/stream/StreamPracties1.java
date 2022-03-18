// �ļ�����
package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamPracties1 {
	public static void encoderFile(File encodingFile, File encodedFile) {
		try(FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
			char[] fileContent = new char[(int)encodingFile.length()];
			fr.read(fileContent);
			System.out.println("����ǰ�����ݣ�");
			System.out.println(new String(fileContent));
			
			// ���м���
			encode(fileContent);
			
			System.out.println("����ǰ�����ݣ�");
			System.out.println(new String(fileContent));
			
			fw.write(fileContent);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static void encode(char[] fileContent) {
		for (int i = 0; i < fileContent.length; i++) {
            char c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                case '9':
                    c = '0';
                    break;
                case 'z':
                    c = 'a';
                    break;
                case 'Z':
                    c = 'A';
                    break;
                default:
                    c++;
                    break;
                }
            }
            fileContent[i] = c;
        }
    }
	
	public static boolean isLetterOrDigit(char c) {
        // ��ʹ��Character���isLetterOrDigit��������Ϊ������Ҳ�ᱻ�ж�Ϊ��ĸ
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 == letterOrDigital.indexOf(c) ? false : true;
    }

	public static void main(String[] args) {
		File encodingFile = new File("E:/project/test.txt");
		File encodedFile = new File("E:/project/test1.txt");
		encoderFile(encodingFile, encodedFile);
	}

}
