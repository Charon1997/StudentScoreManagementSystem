package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.Ui;

import data.Student;
import data.StudentList;

public class InsertStudent {
	static Ui ui = new Ui();
	StudentList studentList = StudentList.getStudentList();
	ArrayList<Student> sList= new ArrayList();
	String name;
	long id;
	int score1,score2;

		private File file;
		private BufferedReader reader;
		private InputStream is;
		private InputStreamReader isReader;
		OtherControl otherControl = new OtherControl();
		
	
	public void insert() {
		
		Scanner scanner = new Scanner(System.in);
		ui.insertStudentName();
		checkName(scanner);
		ui.insertStudentId();
		checkId(scanner);
		ui.insertStudentScore1();
		checkScore1(scanner);
		ui.insertStudentScore2();
		checkScore2(scanner);
		
		
		//Student student = new Student(id,name,score1,score2);
		studentList.addItem(name, id, score1, score2);
		//studentList.showId(0);
		//sList.add(student);
		showInf();
		//scanner.close();
		//EditStudent editStudent = new EditStudent(studentList);
		//backMain
		//1mainActivity.toMain();
		otherControl.saveDate();
	}
	
	private void checkName(Scanner scanner) {
		while (true) {
			name = scanner.nextLine().trim();
				if (name.length() <2 || name.length() > 16) {
					//�������
					System.out.println("������2-16�ַ�������");
				}else {
					break;
				}
		}
	}
	private void checkId(Scanner scanner) {
		while (true) {
			try {
				id = Long.parseLong(scanner.nextLine().trim());
				if (id <= 0 || id > 2147483646) {
					//�������
					System.out.println("������1-2147483646����");
					continue;
				}else {
					if (otherControl.isExistStudentId(id)) {
						System.out.println("��ѧ���Ѵ��ڣ�����������");
						continue;
					} else {
						break;
					}
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("������1-2147483646����");
				continue;
			}
		}
	}
	private void checkScore1(Scanner scanner) {
		while (true) {
			try {
				score1 = Integer.parseInt(scanner.nextLine().trim());
			if (score1 < 0 || score1 >100) 
				System.out.println("������0-100����");
			else 
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("������0-100����");
				continue;
			}
		}
	}

	private void checkScore2(Scanner scanner) {
		while (true) {
			try {
				score2 = Integer.parseInt(scanner.nextLine().trim());
			if (score2 < 0 || score2 >100) 
				System.out.println("������0-100����");
			else 
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("����������");
				continue;
			}
		}
		
	}
	private void showInf() {
		System.out.println("      ��ӳɹ���");
		System.out.println("      ���֣�"+name);
		System.out.println("      ѧ�ţ�"+id);
		System.out.println("      �γ�1��"+score1);
		System.out.println("      �γ�2��"+score2);
	}
	
	
	private void initReader() {
		if(file != null && file.isFile() && file.canRead()) {
		//�ļ����ڿɶ�ȡ�����ǡ��ļ���������Ŀ¼
			try {
				is = new FileInputStream(file);//�����ļ�������
				isReader = new InputStreamReader(is);//�����������Reader
				reader = new BufferedReader(isReader);//���ڰ��ж�ȡ�ļ�
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	}
}
