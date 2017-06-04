package control;

import java.util.Scanner;

public class ClearInformation {
	Scanner scanner = new Scanner(System.in);
	OtherControl otherControl = new OtherControl();
	public void clear() {
		clearAll();
	}
	
	private void clearAll() {
		System.out.println("      是否清空所有信息？（按1清空，按0退出）");
		while(true){
			try {
				int choose = Integer.parseInt(scanner.nextLine().trim());
				if (choose == 0) {
					break;
				}else if (choose == 1) {
					//清空所有信息
					otherControl.clearAll(1);
					otherControl.clearAll(2);
					otherControl.clearAll(3);
					break;
				} else {
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
	
}
