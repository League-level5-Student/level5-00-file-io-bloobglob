package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager.
	 * Use any key you want (1 - 25) to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		FileEncryptor fe = new FileEncryptor();
		fe.writeToAFile(fe.encrypt(JOptionPane.showInputDialog("Insert a message")));
	}
	String encrypt(String str) {
		String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String modAlph = "efghijklmnopqrstuvwxyzabcdEFGHIJKLMNOPQRSTUVWXYZABCD";
		String s = "";
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				s += modAlph.charAt(alph.indexOf((str.charAt(i))));
			}else {
				s += str.charAt(i);
			}
		}
		return s;
	}
	void writeToAFile(String str) {
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			fw.write(str);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
