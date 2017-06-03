package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import com.Ui;

import data.StudentList;


/*save 没做
 * 编辑选择234没做
 * 
 * */
public class EditStudent {
	private String name;
	private long id;
	private int score1,score2;
	StudentList studentList = StudentList.getStudentList();
	//InsertStudent insertStudent = new InsertStudent();
	OtherControl otherControl = new OtherControl();
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
					otherControl.showSearchInf(i);
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
					otherControl.showSearchInf(i);
					searchNum = i;
					return 2;
				}
			}
		} 
		System.out.println("对不起，未能查询到相应学生");
		searchNum = -1;
		return 1;
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
				editId(searchNum);
				break;
			} else if (choose == 3) {
				editScore1(searchNum);
				break;
			} else if (choose == 4) {
				editScore2(searchNum);
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
					otherControl.saveDate();
					otherControl.showSearchInf(i);
					editInformation();
					break;
				}
		}
	}
	
	private void editId(int i) {
		System.out.println("请输入修改后的学号（输入0退出修改）");
		while (true) {
			try {
				long id = Long.parseLong(scanner.nextLine().trim());
			if (id < 0 || id > 2147483646) {
				//输入错误
				System.out.println("请输入1-2147483646的数");
			} else if (id == 0) {
				System.out.println("退出");
				editInformation();
				break;
			}else {
				studentList.editId(i, id);
				System.out.println("提交成功");
				otherControl.saveDate();
				otherControl.showSearchInf(i);
				editInformation();
				break;
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("请输入1-2147483646的数");
			}
		}
	}
	

	private void editScore1(int i) {
		System.out.println("请输入修改后的学号（输入-1退出修改）");
		while (true) {
			try {
				int score1 = Integer.parseInt(scanner.nextLine().trim());
			if (score1 < -1 || score1 > 100) {
				//输入错误
				System.out.println("请输入0-100的数");
			} else if (score1 == -1) {
				System.out.println("退出");
				editInformation();
				break;
			}else {
				studentList.editScore1(i, score1);
				System.out.println("提交成功");
				otherControl.saveDate();
				otherControl.showSearchInf(i);
				editInformation();
				break;
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("请输入0-100的数");
			}
		}
	}
	
	private void editScore2(int i) {
		System.out.println("请输入修改后的学号（输入-1退出修改）");
		while (true) {
			try {
				int score2 = Integer.parseInt(scanner.nextLine().trim());
			if (score2 < -1 || score2 > 100) {
				//输入错误
				System.out.println("请输入0-100的数");
			} else if (score2 == -1) {
				System.out.println("退出");
				editInformation();
				break;
			}else {
				studentList.editScore2(i, score2);
				System.out.println("提交成功");
				otherControl.saveDate();
				otherControl.showSearchInf(i);
				editInformation();
				break;
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("请输入0-100的数");
			}
		}
	}
	
	
	
	
}
