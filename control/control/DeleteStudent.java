package control;

import java.util.Scanner;

import data.StudentList;

public class DeleteStudent {
	private long id;
	private String name;
	private int score1,score2;
	private int searchNum ;
	StudentList studentList = StudentList.getStudentList();
	OtherControl otherControl = new OtherControl();
	private Scanner scanner = new Scanner(System.in);
	public void delete() {
		int choose = searchStudent();
		if (choose == 0) {
			//退出
		}else if (choose == 1) {
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
					delete();
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
		}else if (choose == 2) {
			deleteInformation();
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
		}if (name != null) {
			for(int i = 0;i < studentList.getCount();i++){
				//System.out.println("mane:"+studentList.getName(i));
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

	private void deleteInformation() {
		System.out.println("是否删除"+studentList.getName(searchNum)+"的信息");
		System.out.println("按1确定删除，按0退出此界面");
		
		while (true) {
			try {
				int isDelete = Integer.parseInt(scanner.nextLine().trim());
				if (isDelete == 1) {
					//删除
					studentList.deleteItem(searchNum);
					System.out.println("删除成功");
					otherControl.saveDate();
					break;
				} else if (isDelete == 0) {
					//退出
					System.out.println("退出");
					delete();
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入相应数字进行操作");
				
			}
			
		}
		
		
	
	}
}
