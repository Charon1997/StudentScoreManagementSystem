package control;

import java.util.Scanner;

public class ClearInformation {
	Scanner scanner = new Scanner(System.in);
	OtherControl otherControl = new OtherControl();
	public void clear() {
		clearAll();
	}
	
	private void clearAll() {
		System.out.println("      �Ƿ����������Ϣ������1��գ���0�˳���");
		while(true){
			try {
				int choose = Integer.parseInt(scanner.nextLine().trim());
				if (choose == 0) {
					break;
				}else if (choose == 1) {
					//���������Ϣ
					otherControl.clearAll(1);
					otherControl.clearAll(2);
					otherControl.clearAll(3);
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
