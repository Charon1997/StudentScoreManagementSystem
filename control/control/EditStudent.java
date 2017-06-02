package control;

import java.util.Scanner;

public class EditStudent {
	private String name;
	private long id;
	private int score1,score2;
	MainActivity mainActivity = new MainActivity();
	
	public void edit(){
		searchStudent();
		showSearchInf();
	}
	
	private void searchStudent() {
		System.out.println("请输入要编辑学生的学号或名字");
		Scanner scanner = new Scanner(System.in);
		String scanString = scanner.nextLine().trim();
		try {
			id = Long.parseLong(scanString);
		} catch (Exception e) {
			// 输入的不是数字
			name = scanString;
		}
		if (name != null) {
			for(int i = 0;i < mainActivity.studentList.size();i++){
				if (mainActivity.studentList.get(i).getStudentName().equals(name)) {
					id = mainActivity.studentList.get(i).getStudentId();
					score1 = mainActivity.studentList.get(i).getScore1();
					score2 = mainActivity.studentList.get(i).getScore2();
					break;
				}
			}
		} else {
			for(int i = 0;i < mainActivity.studentList.size();i++){
				if (mainActivity.studentList.get(i).getStudentId() == id) {
					name = mainActivity.studentList.get(i).getStudentName();
					score1 = mainActivity.studentList.get(i).getScore1();
					score2 = mainActivity.studentList.get(i).getScore2();
					break;
				}
			}
		}
	}
	private void showSearchInf() {
		
	}
}
