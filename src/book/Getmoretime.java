package book;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class Getmoretime {
	
	
       
	public static void overtime(){
		
		int choice=getmoretime_choice();//from 黄文辉

		while(choice==1){
			int book_index=Book_list.book_index();
			if(Book_list.book_state.get(book_index).equals("借出")
				&&!Circulation.timejudge("bookNumber", book_index)){
				System.out.println();
				
				long time=Calendar.getInstance().getTimeInMillis();
				
		
				long differ=Calendar.getInstance().getTimeInMillis()
						-book.Book_list.time_return.get(book_index);
				System.out.println("你欠书很多天了"+differ/(1000 * 60 * 60 * 24));
				System.out.println("欠款："+	differ/(1000 * 60 * 60 * 24));	
		
				choice=getmoretime_choice();
			}
			else{
				System.out.println("此书未借出或未过期");
				break;
			}
		}
		
	}
	
	
	private static int getmoretime_choice(){
		System.out.printf("%6S","1.继续归还过期图书/续借");
		System.out.printf("%6s","2.返回主界面");
	
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		if(choice==1){
			return 1;
		}
		else{
			return 2;
		}
	}
	
	public static void borrowmore(){
		
		int choice=getmoretime_choice();
		while(choice==1){
			int book_index=Book_list.book_index();
			if(Book_list.book_state.get(book_index).equals("借出")
				&&Circulation.timejudge("bookNumber", book_index)){
			System.out.println("");
			
			long new_time=book.Book_list.time_return.get(book_index)+(15*24*60*60*1000);
			book.Book_list.time_return.set(book_index, new_time);
			choice=getmoretime_choice();
			}
		}
	}
	
	
}
