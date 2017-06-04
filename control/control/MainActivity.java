package control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Ui;
import data.Student;
import data.StudentList;

public class MainActivity {
	//public ArrayList<Student> studentList = new ArrayList();
	static Ui ui = new Ui();
	static InsertStudent insertStudent = new InsertStudent();
	static EditStudent editStudent = new EditStudent();
	static DeleteStudent deleteStudent = new DeleteStudent();
	static LookInformation lookInformation = new LookInformation();
	static ClearInformation clearInformation = new ClearInformation();
	static OtherControl otherControl = new OtherControl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		otherControl.loadInformationDate();
		ui.welcomeActivity();
		//��ҳѡ��
		while (true) {
			Scanner s = new Scanner(System.in);
			try {
				int chooseNum = Integer.parseInt(s.nextLine().trim());
				if (chooseNum == 1) {
					insertStudent.insert();
					//break;
				} else if (chooseNum == 2) {
					editStudent.edit();
				} else if (chooseNum == 3) {
					deleteStudent.delete();
				} else if (chooseNum == 4) {
					lookInformation.look();
				} else if (chooseNum == 5) {
					clearInformation.clear();
				}else {
					System.out.println("**    �������������Ӧ���ֽ��в���                                                **");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("**    �������������Ӧ���ֽ��в���                                                **");
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
