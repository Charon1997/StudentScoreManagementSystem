package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
				String information = "������"+studentList.getName(i)+"     ѧ�ţ�"+studentList.getId(i)+"     �γ�1��"+studentList.getScore1(i)+"     �γ�2��"+studentList.getScore2(i)+"     �ܳɼ���"+studentList.getTotalScore(i);
				bw.write(information);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.out.println("      ��ɱ���");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		sortTotalScore();
		statisticsCourse();
	}
	
	public void showSearchInf(int i) {
		System.out.println("ѧ����"+studentList.getName(i));
		System.out.println("ѧ��:"+studentList.getId(i));
		System.out.println("�γ�1��"+studentList.getScore1(i));
		System.out.println("�γ�2��"+studentList.getScore2(i));
		System.out.println("�ܳɼ���"+studentList.getTotalScore(i));
	}
	
	public void loadInformationDate() {
		   try {
               String encoding="GBK";
               File file=new File("H:/StudentScoreManagementSystem/student_information.txt");
               if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                   InputStreamReader read = new InputStreamReader(
                   new FileInputStream(file),encoding);//���ǵ������ʽ
                   BufferedReader bufferedReader = new BufferedReader(read);
                   String lineTxt = null;
                   while((lineTxt = bufferedReader.readLine()) != null){
                       int nameNum = lineTxt.indexOf("����");
                       int idNum = lineTxt.indexOf("ѧ��");
                       int score1Num = lineTxt.indexOf("�γ�1");
                       int score2Num = lineTxt.indexOf("�γ�2");
                       int totalScoreNum = lineTxt.indexOf("�ܳɼ�");
                       String name = lineTxt.substring(nameNum+3, idNum-5);
                       long id = Long.parseLong(lineTxt.substring(idNum+3,score1Num-5)) ;
                       int score1 = Integer.parseInt(lineTxt.substring(score1Num+4,score2Num-5));
                       int score2 = Integer.parseInt(lineTxt.substring(score2Num+4,totalScoreNum-5));
                       studentList.addItem(name, id, score1, score2);
                   }
                   read.close();
       }
       } catch (Exception e) {
           System.out.println("      ��ȡ�ļ����ݳ���");
           e.printStackTrace();
       }
	}
	
	public void sortTotalScore() {
		ArrayList<Integer> integersList = new ArrayList<>();
		
			for (int j = 200; j >= 0; j--) {
				for(int i = 0 ;i < studentList.getCount();i++){
				if (studentList.getTotalScore(i) == j) {
					integersList.add(i);
					}
				}
			}
			
			BufferedWriter bw =null;
			FileWriter fw;
			try {
				fw = new FileWriter("H:/StudentScoreManagementSystem/sort_totalscore.txt");
				bw = new BufferedWriter(fw);

				for(int i = 0;i < studentList.getCount();i++){
					int num = integersList.get(i);
					String information = "������"+studentList.getName(num)+"     ѧ�ţ�"+studentList.getId(num)+"     �γ�1��"+studentList.getScore1(num)+"     �γ�2��"+studentList.getScore2(num)+"     �ܳɼ���"+studentList.getTotalScore(num);
					bw.write(information);
					bw.newLine();
				}
				bw.flush();
				bw.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	
	public void statisticsCourse() {
		
		double score1Ave = 0;
		double score2Ave = 0;
		double no_pass1 = 0;
		double no_pass2 = 0;
		double pass1 = 0;
		double pass2 = 0;
		double excellent1 = 0;
		double excellent2 = 0;
		double good1 = 0;
		double good2 = 0;
		double mid1 = 0;
		double mid2 = 0;
		double bad1 = 0;
		double bad2 = 0;
		for(int i = 0;i < studentList.getCount();i++){
			score1Ave = score1Ave+studentList.getScore1(i);
			score2Ave = score2Ave+studentList.getScore2(i);
			int score1 = studentList.getScore1(i);
			if (score1>= 60) {
				pass1++;
			}
			if (score1 >= 90) {
				excellent1++;
			} else if (score1 >= 70 && score1 < 90) {
				good1++;
			} else if (score1 >= 60 && score1 < 70) {
				mid1++;
			} else {
				bad1++;
				no_pass1++;
			}
			int score2 = studentList.getScore2(i);
			if (score2>= 60) {
				pass2++;
			}
			if (score2 >= 90) {
				excellent2++;
			} else if (score2 >= 70 && score2 < 90) {
				good2++;
			} else if (score2 >= 60 && score2 < 70) {
				mid2++;
			} else {
				bad2++;
				no_pass2++;
			}
		}
		score1Ave /= studentList.getCount();
		score2Ave /= studentList.getCount();
		double rate = 100/studentList.getCount();
		pass1 *=rate;
		pass2 *=rate;
		no_pass1 *=rate;
		no_pass2 *=rate;
		excellent1 *=rate;
		excellent2 *=rate;
		good1 *=rate;
		good2 *=rate;
		mid1 *=rate;
		mid2 *=rate;
		bad1 *=rate;
		bad2 *=rate;
		
		
		BufferedWriter bw =null;
		FileWriter fw;
		try {
			fw = new FileWriter("H:/StudentScoreManagementSystem/statistics_course.txt");
			bw = new BufferedWriter(fw);

			String information1 ="�γ�1:  ƽ���֣�"+score1Ave+"  �����ʣ�"+pass1+"  �������ʣ�"+no_pass1+"  �ţ�"+excellent1+"  ����"+good1+"  �У�"+mid1+"  �"+bad1;
			bw.write(information1);
			bw.newLine();
			
			String information2 ="�γ�2:  ƽ���֣�"+score2Ave+"  �����ʣ�"+pass2+"  �������ʣ�"+no_pass2+"  �ţ�"+excellent2+"  ����"+good2+"  �У�"+mid2+"  �"+bad2;			
			bw.write(information2);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void clearAll(int choose) {
		BufferedWriter bw =null;
		FileWriter fw = null;
		
		try {
		
			if (choose == 1) {
				fw=new FileWriter("H:/StudentScoreManagementSystem/student_information.txt");
			} else if (choose ==2) {
				fw=new FileWriter("H:/StudentScoreManagementSystem/sort_totalscore.txt");
			} else if (choose ==3) {
				fw=new FileWriter("H:/StudentScoreManagementSystem/statistics_course.txt");
			}
			bw = new BufferedWriter(fw);
			
			bw.write("");
			
			bw.flush();
			bw.close();
			if (choose == 1) {
				System.out.println("      ���ѧ����Ϣ�ɹ�");
			} else if (choose ==2) {
				System.out.println("      ����ܳɼ�����ɹ�");
			} else if (choose ==3) {
				System.out.println("      ��տγ̷����ɹ�");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean isEmptyInformation() {
		boolean isEmpty = true;
		 try {
             String encoding="GBK";
             File file=new File("H:/StudentScoreManagementSystem/student_information.txt");
             if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                 InputStreamReader read = new InputStreamReader(
                 new FileInputStream(file),encoding);//���ǵ������ʽ
                 BufferedReader bufferedReader = new BufferedReader(read);
            
                 while((bufferedReader.readLine()) != null){
                    isEmpty = false;
                 }
                 read.close();
     }
     } catch (Exception e) {
         System.out.println("      ��ȡ�ļ����ݳ���");
         e.printStackTrace();
     }
		return isEmpty;
	}

	public boolean isExistStudentId(long id) {
		for (int i = 0; i < studentList.getCount(); i++) {
			if (id == studentList.getId(i)) {
				return true;
			}
		} return false;
	}
}
