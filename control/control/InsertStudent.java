package control;


import java.util.Scanner;

import com.Ui;

import data.StudentList;

public class InsertStudent {
	static Ui ui = new Ui();
	StudentList studentList = StudentList.getStudentList();
	String name;
	long id;
	int score1,score2;

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
					//输入错误
					System.out.println("请输入2-16字符的名字");
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
					//输入错误
					System.out.println("请输入1-2147483646的数");
					continue;
				}else {
					if (otherControl.isExistStudentId(id)) {
						System.out.println("该学号已存在，请重新输入");
						continue;
					} else {
						break;
					}
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("请输入1-2147483646的数");
				continue;
			}
		}
	}
	private void checkScore1(Scanner scanner) {
		while (true) {
			try {
				score1 = Integer.parseInt(scanner.nextLine().trim());
			if (score1 < 0 || score1 >100) 
				System.out.println("请输入0-100的数");
			else 
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("请输入0-100的数");
				continue;
			}
		}
	}

	private void checkScore2(Scanner scanner) {
		while (true) {
			try {
				score2 = Integer.parseInt(scanner.nextLine().trim());
			if (score2 < 0 || score2 >100) 
				System.out.println("请输入0-100的数");
			else 
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("请输入数字");
				continue;
			}
		}
		
	}
	private void showInf() {
		System.out.println("      添加成功！");
		System.out.println("      名字："+name);
		System.out.println("      学号："+id);
		System.out.println("      课程1："+score1);
		System.out.println("      课程2："+score2);
	}
}
