package book;

import java.util.Scanner;
import java.util.ArrayList;

public class Book_list {
	//未明白arraylist中int[]的使用
	public static ArrayList<String> book_number = new ArrayList<String>();
	public static ArrayList<String> book_name = new ArrayList<String>();
	public static ArrayList<String> book_time = new ArrayList<String>();	
	public static ArrayList<String> book_price = new ArrayList<String>();
	public static ArrayList<String> book_shelfNumber = new ArrayList<String>();
	public static ArrayList<String> book_state = new ArrayList<String>();
	public static ArrayList<Long> time_return=new ArrayList<Long>();
	//还书时间(Calendar file 使用麻烦，放下)
	public static ArrayList<Long> time_borrow=new ArrayList<Long>();
	//借书时间

	
	
	public static int book_index(){
		System.out.println("输入图书编号");
		Scanner input=new Scanner(System.in);
		return book.Book_list.book_number.indexOf(input.next());
	}
	
	public static int choice() {
		// 第二级选择菜单
		int choice = 4;
		Scanner input = new Scanner(System.in);
		System.out.printf("%4s%s\n", " ", "1.新书入馆");
		System.out.printf("%4s%s\n", " ", "2.编辑图书信息");
		System.out.printf("%4s%s\n", " ", "3.显示图书信息");
		System.out.printf("%4s%s", " ", "4.主界面(1/2/3/4)");
		// 默认返回主界面 没完成
		switch (input.nextInt()) {
		case 1:
			choice = 1;
			break;
		case 2:
			choice = 2;
			break;
		case 3:
			choice = 3;
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
		System.out.printf("%6s%s\n", " ", "2.编辑图书信息");
		System.out.printf("%6s%s\n", " ", "3.显示图书信息");
		System.out.printf("%6s%s\n", " ", "4.回到主界面（1/2/3/4):");
		// 默认返回主界面 没完成
		switch (input.nextInt()) {
		case 1:
			choice = 1;
			break;
		case 2:
			choice =2;
		case 3:
			choice =3;
		default:
			choice=4;
			break;
		}
		return choice;

	}

	public static void book_new(){
		//未解决书名带空格的BUG
		Scanner i = new Scanner(System.in);

		System.out.printf("请输入图书编号：");
		String number=i.next();
		book_number.add(number);

		System.out.printf("请输入书名：");
		String name=i.next();
		book_name.add(name);
		

		System.out.printf("请输入单价:");
		String price=i.next();
		book_price.add(price);
		
		System.out.println("新书编号："+number);
		System.out.println("书名："+name);
		System.out.println("单价："+price);
		
		book_time.add(null);
		book_shelfNumber.add(null);
		book_state.add("在馆");
		time_borrow.add((long) 0);
		time_return.add((long)0);
 
	}

	
	public static void book_change() {
		Scanner i = new Scanner(System.in);

         
		System.out.printf("请输入原来图书编号：");
		
		int book_index=book_number.indexOf(i.next());
		
		System.out.printf("请输入新的图书编号：");
		String number=i.next();
		book_number.set(book_index,number);

		System.out.printf("请输入修改后的书名：");
		String name=i.next();
		book_name.set(book_index,name);

		System.out.printf("请输入修改后的单价:");
		String price=i.next();
		book_price.set(book_index,price);

		System.out.printf("请输入入馆时间:");
		String time=i.next();
		book_time.set(book_index, time);

		System.out.printf("请输入书架编号:");
		String shelfNumber=i.next();
		book_shelfNumber.set(book_index,shelfNumber);

		System.out.printf("请输入图书状态:");
		String state=i.next();
		book_state.set(book_index,state);

		 System.out.println("编号："+number);
		 System.out.println("书名:"+name);
		 System.out.println("单价"+price);
		 System.out.println("入馆时间："+time);
		 System.out.println("书架编号"+shelfNumber);
		 System.out.println("图书状态"+state);
		 

	}

	public static int book_info_output() {
		if (book_number.size() == 0) {
			System.out.println("没有图书，请添加图书");
			//错误预警功能，
		} else {
			System.out.printf("\n\n" + "图书编号" + "  " + "书名" + "      " + "单价" + "   " + "入馆时间" + "    " + "书架编号"
					+ "    " + "图书状态" + "\n");
			for (int number = 0; number < book_number.size(); number++) {
				System.out.print(book_number.get(number)+" ");
				System.out.print(book_name.get(number)+"     ");
				System.out.print(book_price.get(number)+"  ");
				System.out.print(book_time.get(number)+"   ");
				System.out.print(book_shelfNumber.get(number)+"   ");
				System.out.print(book_state.get(number));

				System.out.println();

			}
		}
		return book_number.size();

	}

}

