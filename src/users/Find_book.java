package users;

import java.util.Scanner;

import book.Book_list;

import java.util.ArrayList;

public class Find_book {

	static String a;
	static int n=2;
	static int total,number1,number2 = 0;

	public static void main(String[] args) {
		while(n==2){
		System.out.print("输入图书关键字：");
		Scanner input = new Scanner(System.in);

		a = input.nextLine();

		for (String item : book.Book_list.book_name) {
			if (item.contains(a)) {
				int index=book.Book_list.book_name.indexOf(item);
				int counter=0;
				//item.indexOf(a);
				System.out.println("图书编号： "+book.Book_list.book_number.get(index));
				System.out.println("书名： "+item);
				System.out.println("书架名： "+book.Book_list.book_shelfNumber.get(index));
				if(book.Book_list.book_state.get(index).equals("在馆"))	
					{counter = counter + 1;
					if (counter!=0)
						System.out.println("在馆数量 ："+counter+"\n");
					}
					
				number1 = number1 + 1;}
		                                              } 
		
		
	
		
		for (String item : book.Book_list.book_number) {
			if (item.contains(a)) {
				int index=book.Book_list.book_number.indexOf(item);
				item.indexOf(a);
				int counter=0;
				System.out.println("图书编号： "+item);
				System.out.println("书名： "+book.Book_list.book_name.get(index));
				System.out.println("书架名： "+book.Book_list.book_shelfNumber.get(index));
				if(book.Book_list.book_state.equals("在馆"))	
					{counter = counter + 1;
					if (counter!=0)
					System.out.println("在馆数量 ："+counter+"\n");}
					
				number2 = number2 + 1;}
		                                              }     
					
				
				
      total=number1+number2;
	
	
	
	if (total == 0) {
		System.out.println("你所选择的书籍不存在");
	}
	System.out.print("输入1结束查询，输入2重复查询");
    Scanner input1 = new Scanner(System.in);
     n = input.nextInt();
     if (n==1){
    	 break;
    	 }
		}
}
}