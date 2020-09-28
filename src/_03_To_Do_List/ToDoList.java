package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame("To-Do List");
	JPanel panel = new JPanel();
	JButton addTask = new JButton("Add Task");
	JButton viewTasks = new JButton("View Tasks");
	JButton removeTasks = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();
	ToDoList() {
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTasks);
		panel.add(saveList);
		panel.add(loadList);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTasks.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
	}
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == addTask) {
			tasks.add(JOptionPane.showInputDialog("Enter a task"));
		}else if(buttonPressed == viewTasks) {
			JOptionPane.showMessageDialog(null, makeList(tasks));
		}else if(buttonPressed == removeTasks) {
			tasks.remove(Integer.parseInt(JOptionPane.showInputDialog("Enter the number you wish to remove"))-1);
		}else if(buttonPressed == saveList) {
			writeToFile(makeList(tasks));
		}else if(buttonPressed == loadList) {
			JOptionPane.showMessageDialog(null, readFromFile());
		}
	}
	String makeList(ArrayList<String> str) {
		String s = "";
		for(int i = 0; i < str.size(); i++) {
			s += (i+1) + ". " + str.get(i);
			s += "\n";
		}
		return s;
	}
	void writeToFile(String str) {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/ToDoList.txt");
			
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
	String readFromFile() {
		String str = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/ToDoList.txt"));
			
			String line = br.readLine();
			while(line != null){
				str+=line;
				str += "\n";
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
