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
			//�˳�
		}else if (choose == 1) {
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
					delete();
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
		}else if (choose == 2) {
			deleteInformation();
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
		System.out.println("�Բ���δ�ܲ�ѯ����Ӧѧ��");
		searchNum = -1;
		return 1;
	}

	private void deleteInformation() {
		System.out.println("�Ƿ�ɾ��"+studentList.getName(searchNum)+"����Ϣ");
		System.out.println("��1ȷ��ɾ������0�˳��˽���");
		
		while (true) {
			try {
				int isDelete = Integer.parseInt(scanner.nextLine().trim());
				if (isDelete == 1) {
					//ɾ��
					studentList.deleteItem(searchNum);
					System.out.println("ɾ���ɹ�");
					otherControl.saveDate();
					break;
				} else if (isDelete == 0) {
					//�˳�
					System.out.println("�˳�");
					delete();
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("������Ӧ���ֽ��в���");
				
			}
			
		}
		
		
	
	}
}
