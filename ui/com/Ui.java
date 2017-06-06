package com;


public class Ui {
	public void welcomeActivity(){
		System.out.println("**           欢迎来到学生成绩管理系统                                     **");
		System.out.println("**    1. 新建学生                                                                                       **");
		System.out.println("**    2. 编辑学生                                                                                       **");
		System.out.println("**    3. 删除学生                                                                                       **");
		System.out.println("**    4. 查看信息                                                                                       **");
		System.out.println("**    5. 清空信息                                                                                       **");
		System.out.println("**    输入相应数字进行操作                                                                       **");
	}

	public void insertStudentName(){
		System.out.println("      1. 请输入学生名字                    ");
	}
	public void insertStudentId(){
		System.out.println("      2. 请输入学生学号                    ");
	}
	public void insertStudentScore1(){
		System.out.println("      3. 请输入学生课程1成绩       ");
	}
	public void insertStudentScore2(){
		System.out.println("      4. 请输入学生课程2成绩       ");
	}
	public void editStudent(){
		System.out.println("**    1. 编辑姓名                                                                                       **");
		System.out.println("**    2. 编辑学号                                                                                       **");
		System.out.println("**    3. 编辑课程1成绩                                                                          **");
		System.out.println("**    4. 编辑课程2成绩                                                                          **");
		System.out.println("**    0. 按0退出                                                                                       **");
		System.out.println("**    输入相应数字进行操作                                                                      **");
	}
	
	public void lookInformation(){
		System.out.println("**    1. 查看学生信息                                                                            **");
		System.out.println("**    2. 查看总成绩排名                                                                       **");
		System.out.println("**    3. 查看课程分析                                                                           **");
		System.out.println("**    0. 按0退出                                                                                     **");
		System.out.println("**    输入相应数字进行操作                                                                    **");
	}
	
	
	
}
