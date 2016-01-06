package tools;

import java.util.Scanner;

public class spark {

	public static void gas() {
		for (int i = 0; i <= 14; i++) {
			System.out.print("--");
		}
		System.out.println();
	}
  
	

	
	
	public static int choice_2() {
		// 第二级选择菜单
		int choice = 3;
		Scanner input = new Scanner(System.in);
		System.out.printf("%4s%s\n", " ", "1.增加读者信息");
		System.out.printf("%4s%s\n", " ", "2.显示所有读者信息");
		System.out.printf("%4s%s", " ", "3.主界面(1/2/3)");
		// 默认返回主界面 没完成
		switch (input.nextInt()) {
		case 1:
			choice = 1;
			break;
		case 2:
			choice = 2;
			break;
		default:
			break;
		}
		return choice;
	}

	public static int choice_3() {
		// 第3级选择菜单
		int choice = 1;
		Scanner input = new Scanner(System.in);
		System.out.printf("%6s%s\n", " ", "1.继续增加");
		System.out.printf("%6s%s\n", " ", "2.显示信息并回到主界面");
		// 默认返回主界面 没完成
		switch (input.nextInt()) {
		case 1:
			choice = 1;
			break;
		default:
			choice=2;
			break;
		}
		return choice;

	}
    
    
    

}




