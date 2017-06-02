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
			//�˳�
		}else if (searchNum == 1) {
			//δ������
			System.out.println("��0�˳�����1��������");
			while (true) {
				try {
				int isExit = Integer.parseInt(scanner.nextLine().trim());
				if (isExit == 0) {
					//�˳�
					break;
				} else if (isExit == 1) {
					//�ٴ�����
					edit();
				}else {
					System.out.println("��������Ӧ���ֽ��в���");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("��������Ӧ���ֽ��в���");
				continue;
			}
			}
			
		} else if (searchNum == 2){
			editInformation();
		} 
		
	}
	
	
	private int searchStudent() {
		System.out.println("**           ��ӭ����ѧ���ɼ�����ϵͳ                                     **");
		System.out.println("**          ������Ҫ�༭ѧ����ѧ�Ż�����                                **");
		System.out.println("**          ��0�˳��˽���                                                                 **");
		
		String scanString = scanner.nextLine().trim();
		try {
			id = Long.parseLong(scanString);
			if (id == 0) {
				return 0;
			}
		} catch (Exception e) {
			// ����Ĳ�������
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
		System.out.println("�Բ���δ�ܲ�ѯ����Ӧѧ��");
		searchNum = -1;
		return 1;
	}
	

	private void showSearchInf(int i) {
		System.out.println("ѧ����"+studentList.getName(i));
		System.out.println("ѧ��:"+studentList.getId(i));
		System.out.println("�γ�1��"+studentList.getScore1(i));
		System.out.println("�γ�2��"+studentList.getScore2(i));
		System.out.println("�ܳɼ���"+studentList.getTotalScore(i));
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
					System.out.println("�˳��༭"+studentList.getName(searchNum)+"ͬѧ");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("�˳��༭");
				}
				edit();
				break;
			}else {
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
	
	private void editName(int i) {
		System.out.println("�������޸ĺ������(����back�˳��޸�)");
		//Scanner scanner = new Scanner(System.in);
		while (true) {
			String name = scanner.nextLine().trim();
				if (name.length() <2 || name.length() > 16) {
					//�������
					System.out.println("������2-16�ַ�������");
				} else if (name.equals("back")) {
					System.out.println("�˳�");
					editInformation();
					break;
				}else {
					studentList.editName(i, name);
					System.out.println("�޸ĳɹ�");
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
				String information = "������"+studentList.getName(i)+"     ѧ�ţ�"+studentList.getId(i)+"     �γ�1��"+studentList.getScore1(i)+"     �γ�2��"+studentList.getScore2(i)+"     �ܳɼ���"+studentList.getTotalScore(i);
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
