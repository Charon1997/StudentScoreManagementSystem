package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.Ui;

import data.Student;
import data.StudentList;

public class EditStudent {
	private String name;
	private long id;
	private int score1,score2;
	StudentList studentList = StudentList.getStudentList();
	InsertStudent insertStudent = new InsertStudent();
	Ui ui = new Ui();
	private int searchNum;
	Scanner scanner = new Scanner(System.in);
	public void edit(){
		System.out.println("name0"+studentList.getName(0));
		int searchNum = searchStudent();
		if (searchNum == 0) {
			//退出
		}else if (searchNum == 1) {
			//未搜索到
			System.out.println("按0退出，按1继续搜索");
			while (true) {
				try {
				int isExit = Integer.parseInt(scanner.nextLine().trim());
				if (isExit == 0) {
					//退出
					break;
				} else if (isExit == 1) {
					//再次搜索
					edit();
				}else {
					System.out.println("请输入相应数字进行操作");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("请输入相应数字进行操作");
				continue;
			}
			}
			
		} else if (searchNum == 2){
			editInformation();
		} 
		
	}
	
	
	private int searchStudent() {
		System.out.println("**           欢迎来到学生成绩管理系统                                     **");
		System.out.println("**          请输入要编辑学生的学号或名字                                **");
		System.out.println("**          按0退出此界面                                                                 **");
		
		String scanString = scanner.nextLine().trim();
		try {
			id = Long.parseLong(scanString);
			if (id == 0) {
				return 0;
			}
		} catch (Exception e) {
			// 输入的不是数字
			name = scanString;
		}
		if (name != null) {
			for(int i = 0;i < studentList.getCount();i++){
				System.out.println("mane:"+studentList.getName(i));
				if (studentList.getName(i).equals(name)) {
					id = studentList.getId(i);
					score1 = studentList.getScore1(i);
					score2 = studentList.getScore2(i);
					showSearchInf(i);
					searchNum = i;
					return 2;
				}
			}
		} else {
			for(int i = 0;i < studentList.getCount();i++){
				System.out.println("id:"+studentList.getId(i));
				if (studentList.getId(i) == id) {
					name = studentList.getName(i);
					score1 = studentList.getScore1(i);
					score2 = studentList.getScore2(i);
					showSearchInf(i);
					searchNum = i;
					return 2;
				}
			}
		} 
		System.out.println("对不起，未能查询到相应学生");
		searchNum = -1;
		return 1;
	}
	

	private void showSearchInf(int i) {
		System.out.println("学生："+studentList.getName(i));
		System.out.println("学号:"+studentList.getId(i));
		System.out.println("课程1："+studentList.getScore1(i));
		System.out.println("课程2："+studentList.getScore2(i));
		System.out.println("总成绩："+studentList.getTotalScore(i));
	}
	
	private void editInformation() {
		//Scanner scanner = new Scanner(System.in);
		ui.editStudent();
		while (true) {
			try {
			int choose = Integer.parseInt(scanner.nextLine().trim());
			if (choose == 1) {
				editName(searchNum);
				break;
			} else if (choose == 2) {
				
				break;
			} else if (choose == 3) {
				
				break;
			} else if (choose == 4) {
				
				break;
			} else if (choose == 0) {
				try {
					System.out.println("退出编辑"+studentList.getName(searchNum)+"同学");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("退出编辑");
				}
				edit();
				break;
			}else {
				System.out.println("请输入相应数字进行操作");
				continue;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("请输入相应数字进行操作");
			continue;
		}
		}
		
	}
	
	private void editName(int i) {
		System.out.println("请输入修改后的名字(输入back退出修改)");
		//Scanner scanner = new Scanner(System.in);
		while (true) {
			String name = scanner.nextLine().trim();
				if (name.length() <2 || name.length() > 16) {
					//输入错误
					System.out.println("请输入2-16字符的名字");
				} else if (name.equals("back")) {
					System.out.println("退出");
					editInformation();
					break;
				}else {
					studentList.editName(i, name);
					System.out.println("修改成功");
					showSearchInf(i);
					editInformation();
					break;
				}
		}
	}
	
	private void saveDate() {
		BufferedWriter bw =null;
		FileWriter fw;
		
		try {
			fw = new FileWriter("H:/StudentScoreManagementSystem/student_information.txt");
			bw = new BufferedWriter(fw);

			for(int i = 0;i < studentList.getCount();i++){
				String information = "姓名："+studentList.getName(i)+"     学号："+studentList.getId(i)+"     课程1："+studentList.getScore1(i)+"     课程2："+studentList.getScore2(i)+"     总成绩："+studentList.getTotalScore(i);
				System.out.println(information);
				//byte[] informationInBytes = information.getBytes();
				bw.write(information);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
