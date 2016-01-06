package homepage;

import java.util.Scanner;

import book.Book_list;
import users.reader_info;
//未完成借阅最多次数的图书
public class Library_Services {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		homepage: while (1 > 0) {
			tools.spark.gas();// 插入分隔符
			
		/*reader_info.read("/home/weirdest_tap/reader_LID.txt",reader_info.reader_LID);
			reader_info.read("/home/weirdest_tap/reader_SID.txt",reader_info.reader_SID);
			reader_info.read("/home/weirdest_tap/reader_name.txt",reader_info.reader_name);
			reader_info.read("/home/weirdest_tap/reader_sex.txt",reader_info.reader_sex);*/
			System.out.println("   1.读者信息管理(需管理员登录）");
			System.out.println("   2.图书馆信息管理(需管理员登录)");
			System.out.println("   3.借还书管理");
			System.out.println("   4.查询可借阅图书");
			System.out.println("   5.查询个人借阅情况");
			System.out.print("请输入功能编号(1/2/3/4/5)");
			// 从键盘获取选项
			

			switch (input.nextInt()) {
			case 1: {
				int choice = 3;

				if (Admin.admin.passwd()) {
					// 判读密码对错
					switch (tools.spark.choice_2()) {
					// 再次选择
					case 1:
						    do {
							 users.reader_info.reader_info_add();

							 choice = tools.spark.choice_3();
							// 选择紧接着的操作
							 if (choice == 2)
								break;	 // 打穿到下一个case
						     } while (choice == 1);
							
						// 我想再次还会到增加读者信息
					default:
						users.reader_info.reader_info_output();
						//错误修正功能未实现
						continue homepage;
					}
				} else
					continue homepage;
			}

			
			
			case 2: {
				if (Admin.admin.passwd()) {
					int choice = 3;
					switch (Book_list.choice()) {
					case 1:
						    do {
							Book_list.book_new();
							switch(book.Book_list.choice_3()){
							case 3:{
								book.Book_list.book_info_output();	
								break;
							}
							
							case 2:{
								Book_list.book_change();
								break; 	//未完成穿洞
							}
							
							default:
								continue homepage;
								   }
						     } while (choice == 1);
					case 2:
						
						Book_list.book_change();
						continue homepage;
						// 差交叉返回操作
					case 3:
						book.Book_list.book_info_output();
						continue homepage;
						//错误修正功能未实现
					default:
						continue homepage;
					}
					    
				} else
					continue homepage;
			}

			
			
			case 3: {
					switch (book.Circulation.choice()) {
					case 1:
						    book.Circulation.borrowing();
						    continue homepage;
					case 2:
							book.Circulation.returning();
							continue homepage;
					case 3:book.Getmoretime.overtime();
					        continue homepage;
					
					case 4:book.Getmoretime.borrowmore();
					        continue homepage;

					default:
						    continue homepage;
					}
			}

			
			
			case 4: {
				
				users.Find_book.main(null);
				continue homepage;
			}

			case 5:
				switch(users.reader_manage.book_choice()){
				default:
				users.reader_manage.main();
				continue homepage;
				case 2:users.reader_manage.readerhistory();
				continue homepage;
				}
				
			default:
				break;

				// 测试程序系统运行时间

			}
		}

	}
}
