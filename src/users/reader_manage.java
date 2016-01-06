package users;
//未完成跳回续借操作
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

import book.Book_list;

public class reader_manage {
	static String a;
	static int b;
	
	
	
	public static int book_choice() {
		int choice = 2;
		Scanner input = new Scanner(System.in);
		System.out.printf("%6s%s\n", " ", "1.当前借阅图书");
		System.out.printf("%6s%s\n", " ", "2.历史借阅图书");
		switch (input.nextInt()) {
		case 1:
			choice = 1;
			break;
		default:
			break;
		}
		return choice;

	}
	
	public static void main() {

		System.out.print("输入借书证号:");

		Scanner input = new Scanner(System.in);
		a = input.next();

		if (users.reader_info.reader_LID.contains(a)) {
			int index = users.reader_info.reader_LID.indexOf(a);

			if (users.reader_info.reader_book.get(index).size() != 0) {
				for (String item : users.reader_info.reader_book.get(index)) {

					System.out.println("图书编号： " + book.Book_list.book_number.get(index));
					System.out.println("书名： " + book.Book_list.book_name.get(index));
					long time_borrow=book.Book_list.time_borrow.get(index);
					Calendar c = Calendar.getInstance();
					c.setTimeInMillis(time_borrow);

					System.out.println("借阅时间： " + c.getTime());
					
					long time_return=book.Book_list.time_return.get(index);
					c.setTimeInMillis(time_return);

					System.out.println("到期时间： "+c.getTime() );
				}
			} else {
				System.out.println("你没有借阅任何的书籍");
			}
		} else {
			System.out.println("读者证号不存在");

		}
	}
	public static void readerhistory(){
	     String a;
		System.out.print("输入您的学生卡号");
	   Scanner input=new Scanner(System.in);
	   a=input.next();
	  
			int index = users.reader_info.reader_LID.indexOf(a);

			System.out.println("借阅书籍                    "+"借阅时间");
	   for (String item : users.reader_info.reading_histroy.get(index)) {
			
				
				System.out.println(item);

				          
	   	
			//读者借书记录
		}
	}
	
	

}