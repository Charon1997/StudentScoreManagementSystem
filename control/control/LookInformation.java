package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.Ui;

public class LookInformation {
	Ui ui = new Ui();
	Scanner scanner = new Scanner(System.in);
	OtherControl otherControl = new OtherControl();
	public void look() {
		if (!otherControl.isEmptyInformation()) {
			ui.lookInformation();
			while (true) {
				try {
					int choose = Integer.parseInt(scanner.nextLine().trim());
					if (choose > 0 && choose < 4 ) {
						lookWhat(choose);
						isExit();
						break;
					} else if (choose == 0) {
						break;
					} else {
						System.out.println("��������Ӧ���ֽ��в���");
						continue;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("��������Ӧ���ֽ��в���");
					continue;
				}
			}
		} else {
			System.out.println("��δ���ѧ���ɼ���Ϣ");
		}
		
		
	}
	
	
	public void lookWhat(int choose) {
		   try {
         String encoding="GBK";
         File file = null;
         if (choose == 1) {
				file=new File("D:/StudentScoreManagementSystem/student_information.txt");
			} else if (choose ==2) {
				file=new File("D:/StudentScoreManagementSystem/sort_totalscore.txt");
			} else if (choose ==3) {
				file=new File("D:/StudentScoreManagementSystem/statistics_course.txt");
			}
         
         if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
             InputStreamReader read = new InputStreamReader(
             new FileInputStream(file),encoding);//���ǵ������ʽ
             BufferedReader bufferedReader = new BufferedReader(read);
             String lineTxt = null;
             while((lineTxt = bufferedReader.readLine()) != null){
                 System.out.println(lineTxt);
             }
             read.close();
         }else{
        	 System.out.println("�Ҳ���ָ�����ļ�");
         }
		   } catch (Exception e) {
			   System.out.println("��ȡ�ļ����ݳ���");
			   e.printStackTrace();
		   }
		}
	
	public void isExit() {
		while (true) {
			System.out.println("�Ƿ�����鿴������1�����鿴����0�˳��������棩");
			try {
				int choose = Integer.parseInt(scanner.nextLine().trim());
				if (choose == 1) {
					look();
					break;
				} else if (choose == 0) {
					break;
				} else {
					System.out.println("��������Ӧ���ֽ��в���");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("��������Ӧ���ֽ��в���");
				continue;
			}
		}
		
	}
	}
