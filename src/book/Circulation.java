package book;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import users.reader_info;

public class Circulation {
	// 借还书管理

	public static int choice() {
		// 第二级选择菜单
		int choice = 5;
		Scanner input = new Scanner(System.in);
		System.out.printf("%4s%s\n", " ", "1.借书");
		System.out.printf("%4s%s\n", " ", "2.还书");
		System.out.printf("%4s%s\n", " ", "3.过期图书");
		System.out.printf("%4s%s\n", " ", "4.续借");
		System.out.printf("%4s%s", " ", "5.主界面(1/2/3/4/5)");
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
		case 4:
			choice=4;
		default:
			break;
		}
		return choice;
	}

	public static int book_choice() {
		// 第3级选择菜单
		int choice = 2;
		Scanner input = new Scanner(System.in);
		System.out.printf("%6s%s\n", " ", "1.继续借/还书");
		System.out.printf("%6s%s\n", " ", "2.显示已借图书并回到主界面");
		// 默认返回主界面 没完成
		switch (input.nextInt()) {
		case 1:
			choice = 1;
			break;
		default:
			break;
		}
		return choice;

	}

	public static boolean timejudge(String book_numberorLID,int index){
		//choice 为LID或booknubmer;
		long time = Calendar.getInstance().getTimeInMillis();
		boolean timejudge=true;
		// 判断是否过期
		if(book_numberorLID.equals("book_number")){
			if(Book_list.book_state.get(index).equals("在馆")){
				timejudge=true;
			}
			else{
				long time_return=book.Book_list.time_return.get(index);
				timejudge=(time_return>=time);
			}
		}
		else if(book_numberorLID.equals("LID")){
		    //调出所借图书
		    boolean healin=reader_info.reader_book.size()==0
		    		||reader_info.reader_book.get(index).size()==0;
		    //判断有没有人借书，再判断这个人有没有借书
		    //未完成返回操作
		    if(healin){
		    	timejudge=true;
		    	}
		    else{
			    int counter=0;
		    	for(String temp:reader_info.reader_book.get(index)){
		    		int b_index=book.Book_list.book_number.indexOf(temp);
					if(Book_list.book_state.get(b_index).equals("借出")){
						long time_return=Book_list.time_return.get(b_index);
						if(time_return>=time){
						}
						else{
							counter++;
						}
					}
						
		    	}
		    	if(counter==0){
		    		timejudge=true;
		    	}
		    	else{
		    		timejudge=false;
		         	}
		    }
	  }
		return timejudge;
		//true 为可以借书，false为不可以借书
		
	}
	
	public static void borrowing() {
		//读者借书记录未完成
		// 找到一一对应的arraylist下标
		Scanner input = new Scanner(System.in);
		System.out.print("请输入借书卡号：");
		String LID = input.next();
		int temp = 1;
		int reader_index = reader_info.reader_LID.indexOf(LID);
		//可以考虑调出
		
		// 判断是否过期
		if (Circulation.timejudge("LID", reader_index)) {
			do {
				System.out.print("输入图书编号：");
				String book_number = input.next();
				//未判断是否存在这样的书
				int book_index = book.Book_list.book_number.indexOf(book_number);
              
				if(book.Book_list.book_state.get(book_index).equals("在馆")){
				    ArrayList <String> borrowbook =new ArrayList<String>();
					book.Book_list.book_state.set(book_index, "借出");
					users.reader_info.reader_book.get(reader_index).add(book_number);
					
				//未测试
					Calendar time = Calendar.getInstance();
					time.set(time.HOUR, 0);
					time.set(time.MINUTE, 0);
					time.set(time.SECOND, 0);
					book.Book_list.time_borrow.set(book_index, time.getTimeInMillis());
					time.add(time.DATE,30 );// 2个arraylist的时间是一样的？why?
					book.Book_list.time_return.set(book_index,time.getTimeInMillis());
					System.out.println("成功借阅："+Book_list.book_name.get(book_index));
					//未完成应该还日期
					
					ArrayList <String> histroy =new ArrayList<String>();
					
					//reader_info.reading_histroy.get(reader_index).add(null);
					System.out.printf("%6s%s\n", " ", "1.继续借书");
					System.out.printf("%6s%s", " ", "2.显示已借图书并回到主界面(1/2)");
					if (input.nextInt() == 2) {
					// 输出读者信息
						for(String number:reader_info.reader_book.get(reader_index)){
							int index=Book_list.book_number.indexOf(number);
							String name=Book_list.book_name.get(index);
							System.out.println("图书编号:"+book_number+"书名："+name);
							System.out.println();
						}
						break;
					}
					else{
					}
					}
								
				else{
					System.out.println("该图书已借出");					
					System.out.printf("%6s%s\n", " ", "1.继续借书（默认）");
					System.out.printf("%6s%s", " ", "2.回到主界面(1/2)");
					if(input.nextInt()==2){
						break;
						}
					else{
						
					}
					}
				
				
			} while (temp == 1);

		}	

	}

	public static void returning() {
		//读者借书记录未完成
       Scanner input=new Scanner(System.in);

		System.out.println("输入图书编号:");
		String book_number = input.next();
		
		//未完成检查
		int book_index = book.Book_list.book_number.indexOf(book_number);
	       if(Circulation.timejudge("book_number", book_index)){
	    	   int choice=1;
              do{    
					int indexOfReader=reader_info.book_to_readerindex(book_number);
            	  users.reader_info.reader_book.get(indexOfReader).remove(book_number);
            	  book.Book_list.book_state.set(book_index, "在馆");
            	  book.Book_list.time_return.set(book_index,(long)0);
            	  book.Book_list.time_borrow.set(book_index, (long)0);
            	  
            	  choice=Circulation.book_choice();
            	  if(choice==2){
            		  break;
            	  }
            	  else{
            		  choice=1;
            	  }
            		  
              }while(choice==1);
	       }
	       else{
	    	   	System.out.println("你有过期图书或该书未借出");
	       }

	}
	

}
