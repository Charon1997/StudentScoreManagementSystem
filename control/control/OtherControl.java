package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import data.Student;
import data.StudentList;

public class OtherControl {
	StudentList studentList = StudentList.getStudentList();
	
	public void saveDate() {
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
	
	public void showSearchInf(int i) {
		System.out.println("学生："+studentList.getName(i));
		System.out.println("学号:"+studentList.getId(i));
		System.out.println("课程1："+studentList.getScore1(i));
		System.out.println("课程2："+studentList.getScore2(i));
		System.out.println("总成绩："+studentList.getTotalScore(i));
	}
	
	public void loadInformationDate() {
		   try {
               String encoding="GBK";
               File file=new File("H:/StudentScoreManagementSystem/student_information.txt");
               if(file.isFile() && file.exists()){ //判断文件是否存在
                   InputStreamReader read = new InputStreamReader(
                   new FileInputStream(file),encoding);//考虑到编码格式
                   BufferedReader bufferedReader = new BufferedReader(read);
                   String lineTxt = null;
                   while((lineTxt = bufferedReader.readLine()) != null){
                       System.out.println(lineTxt);
                       int nameNum = lineTxt.indexOf("姓名");
                       int idNum = lineTxt.indexOf("学号");
                       int score1Num = lineTxt.indexOf("课程1");
                       int score2Num = lineTxt.indexOf("课程2");
                       int totalScoreNum = lineTxt.indexOf("总成绩");
                       String name = lineTxt.substring(nameNum+3, idNum-5);
                       long id = Long.parseLong(lineTxt.substring(idNum+3,score1Num-5)) ;
                       int score1 = Integer.parseInt(lineTxt.substring(score1Num+4,score2Num-5));
                       int score2 = Integer.parseInt(lineTxt.substring(score2Num+4,totalScoreNum-5));
                       studentList.addItem(name, id, score1, score2);
                       System.out.println(name+id+score1+score2);
                   }
                   read.close();
       }else{
           System.out.println("找不到指定的文件");
       }
       } catch (Exception e) {
           System.out.println("读取文件内容出错");
           e.printStackTrace();
       }
		
	}
	 
}
