package control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Ui;
import data.Student;

public class MainActivity {
	//public ArrayList<Student> studentList = new ArrayList();
	static Ui ui = new Ui();
	static InsertStudent insertStudent = new InsertStudent();
	static EditStudent editStudent = new EditStudent();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ui.welcomeActivity();
		//首页选择
		while (true) {
			Scanner s = new Scanner(System.in);
			try {
				int chooseNum = Integer.parseInt(s.nextLine().trim());
				if (chooseNum == 1) {
					insertStudent.insert();
					//break;
				} else if (chooseNum == 2) {
					editStudent.edit();
				}else {
					System.out.print("输入错误，输入相应数字进行操作 ");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print("输入错误，输入相应数字进行操作");
				continue;
			}
			
			
			
			try {
				Thread.sleep(2000);
				ui.welcomeActivity();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
