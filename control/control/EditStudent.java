package control;

import java.util.Scanner;

import com.Ui;

import data.StudentList;



public class EditStudent {
	private String name;
	private long id;
	StudentList studentList = StudentList.getStudentList();
	OtherControl otherControl = new OtherControl();
	Ui ui = new Ui();
	private int searchNum;
	Scanner scanner = new Scanner(System.in);
	public void edit(){
		int searchNum = searchStudent();
		if (searchNum == 0) {
			//�˳�
		}else if (searchNum == 1) {
			//δ������
			System.out.println("      ��0�˳�����1��������");
			while (true) {
				try {
				int isExit = Integer.parseInt(scanner.nextLine().trim());
				if (isExit == 0) {
					//�˳�
					break;
				} else if (isExit == 1) {
					//�ٴ�����
					edit();
					break;
				}else {
					System.out.println("**    ������Ӧ���ֽ��в���                                                                    **");
					continue;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("**    ������Ӧ���ֽ��в���                                                                    **");
				continue;
			}
			}
			
		} else if (searchNum == 2){
			editInformation();
		} 
		
	}
	
	
	private int searchStudent() {
		System.out.println("**    ������Ҫ�༭ѧ����ѧ�Ż�����                                **");
		System.out.println("**    ��0�˳��˽���                                                                 **");
		
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
				if (studentList.getName(i).equals(name)) {
					id = studentList.getId(i);
					otherControl.showSearchInf(i);
					searchNum = i;
					return 2;
				}
			}
		} else {
			for(int i = 0;i < studentList.getCount();i++){
				if (studentList.getId(i) == id) {
					name = studentList.getName(i);
					otherControl.showSearchInf(i);
					searchNum = i;
					return 2;
				}
			}
		} 
		System.out.println("**    �Բ���δ�ܲ�ѯ����Ӧѧ��                                                         **");
		searchNum = -1;
		return 1;
	}
	
	
	private void editInformation() {
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
					System.out.println("      �˳��༭"+studentList.getName(searchNum)+"ͬѧ");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("      �˳��༭");
				}
				edit();
				break;
			}else {
				System.out.println("**    ��������Ӧ���ֽ��в���                                                                  **");
				continue;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("**    ��������Ӧ���ֽ��в���                                                                  **");
			continue;
		}
		}
		
	}
	
	private void editName(int i) {
		System.out.println("      �������޸ĺ������(����back�˳��޸�)");
		//Scanner scanner = new Scanner(System.in);
		while (true) {
			String name = scanner.nextLine().trim();
				if (name.length() <2 || name.length() > 16) {
					//�������
					System.out.println("      ������2-16�ַ�������");
				} else if (name.equals("back")) {
					System.out.println("**    �˳�                                                                                                           **");
					editInformation();
					break;
				}else {
					studentList.editName(i, name);
					System.out.println("**    �޸ĳɹ�                                                                                                 **");
					otherControl.saveDate();
					otherControl.showSearchInf(i);
					editInformation();
					break;
				}
		}
	}
	
	private void editId(int i) {
		System.out.println("      �������޸ĺ��ѧ�ţ�����0�˳��޸ģ�");
		while (true) {
			try {
				long id = Long.parseLong(scanner.nextLine().trim());
			if (id < 0 || id > 2147483646) {
				//�������
				System.out.println("**    ������1-2147483646����                                                  **");
			} else if (id == 0) {
				System.out.println("**    �˳�                                                                                                           **");
				editInformation();
				break;
			}else {
				studentList.editId(i, id);
				System.out.println("**    �޸ĳɹ�                                                                                                 **");
				otherControl.saveDate();
				otherControl.showSearchInf(i);
				editInformation();
				break;
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("**    ������1-2147483646����                                                  **");
			}
		}
	}
	

	private void editScore1(int i) {
		System.out.println("      �������޸ĺ�γ�1�ĳɼ�������-1�˳��޸ģ�");
		while (true) {
			try {
				int score1 = Integer.parseInt(scanner.nextLine().trim());
			if (score1 < -1 || score1 > 100) {
				//�������
				System.out.println("**    ������0-100����                                                                           **");
			} else if (score1 == -1) {
				System.out.println("**    �˳�                                                                                                           **");
				editInformation();
				break;
			}else {
				studentList.editScore1(i, score1);
				System.out.println("**    �޸ĳɹ�                                                                                                 **");
				otherControl.saveDate();
				otherControl.showSearchInf(i);
				editInformation();
				break;
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("**    ������0-100����                                                                           **");
			}
		}
	}
	
	private void editScore2(int i) {
		System.out.println("      �������޸ĺ�γ�2�ĳɼ�������-1�˳��޸ģ�");
		while (true) {
			try {
				int score2 = Integer.parseInt(scanner.nextLine().trim());
			if (score2 < -1 || score2 > 100) {
				//�������
				System.out.println("**    ������0-100����                                                                            **");
			} else if (score2 == -1) {
				System.out.println("**    �˳�                                                                                                           **");
				editInformation();
				break;
			}else {
				studentList.editScore2(i, score2);
				System.out.println("**    �޸ĳɹ�                                                                                                 **");
				otherControl.saveDate();
				otherControl.showSearchInf(i);
				editInformation();
				break;
			}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("**    ������0-100����                                                                           **");
			}
		}
	}
	
	
	
	
}
