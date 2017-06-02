package control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Ui;
import data.Student;

public class MainActivity {
	public ArrayList<Student> studentList = new ArrayList();
	static Ui ui = new Ui();
	static InsertStudent insertStudent = new InsertStudent();
	static EditStudent editStudent = new EditStudent();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ui.welcomeActivity();
		//��ҳѡ��
		while (true) {
			Scanner s = new Scanner(System.in);
			
			int chooseNum = s.nextInt();
			if (chooseNum == 1) {
				insertStudent.insert();
				//break;
			} else if (chooseNum == 2) {
				editStudent.edit();
			}else {
				System.out.print("����������");
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
	
//	public void toMain() {
//		System.out.println("�����������������");
//		Scanner scanner = new Scanner(System.in);
//		ui.welcomeActivity();
//		scanner.close();
//	}

}
