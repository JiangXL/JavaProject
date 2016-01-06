package users;

import java.util.Scanner;
import java.io.*;


import java.util.ArrayList;

public class reader_info {
	//未解决中名字的问题
	//未解决名字空格的问题
	public static ArrayList<ArrayList<String>> reader_book=new ArrayList<ArrayList<String>>();
	public static ArrayList<String> reader_LID=new ArrayList<String>();//library ID
	public static ArrayList<String> reader_SID = new ArrayList<String>();//Student ID
	public static ArrayList<String> reader_name = new ArrayList<String>();
	public static ArrayList<String> reader_sex = new ArrayList<String>();//male or female
	public static ArrayList<ArrayList<String>> reading_histroy=new ArrayList<ArrayList<String>>();
	
	public static  void read(String path,ArrayList date){
		
		try{
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(path);
			//	创建FileWriter对象，用来写入字符流 
			BufferedWriter bw = new BufferedWriter(fw); 
	//	将缓冲对文件的输出 
			String myreadline;
	//	定义一个String类型的变量,用来每次读取一行 
			while (br.ready()) {
				myreadline = br.readLine();
	//读取一行 
				bw.write(myreadline);
				date.add(myreadline);
	//写入文件
				bw.newLine();
				bw.flush(); 
	//刷新该流的缓冲 
				bw.close();
				br.close();
				fw.close(); 
				br.close(); 
				fr.close(); 
				}
			}
	catch (IOException e) { e.printStackTrace(); } 
	}
	
	
		
		public static void update(String path,ArrayList date) {
			 try{
				 File writename = new File(path); 
	            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	            for(Object temp:date){
	            	 out.write(temp+"\n"); // \r\n即为换行	  
	            	 out.flush(); // 把缓存区内容压入文件  
	            	 out.close(); // 最后记得关闭文件
	              }
			 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
	}
	//读者信息储存和增加
		//平行储存读者信息
	public static void reader_info_add() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入新读者借书卡号");
		reader_LID.add(input.next());
      // update("/home/weirdest_tap/reader_LID.txt",reader_LID);
		
		System.out.println("请输入新读者学号");
		reader_SID.add(input.next());
      // update("/home/weirdest_tap/reader_SID.txt",reader_SID);

		
		System.out.println("请输入新读者的姓名");      
		reader_name.add(input.next());
		//update("/home/weirdest_tap/reader_name.txt",reader_name);

	
		System.out.println("请输入新读者的性别");
		System.out.printf("%4s\t%s","  ","1.男  2.女");
		switch(input.nextInt()){
		case 1:
			reader_sex.add( "男");
			break;
		case 2:
			reader_sex.add( "女");
			break;
		}

		
		//update("/home/weirdest_tap/reader_sex.txt",reader_sex);
		
	    ArrayList <String> borrowbook =new ArrayList<String>();
		reader_book.add(borrowbook);
	


	}

	public static int reader_info_output() {
		if(reader_SID.size()==0){
			System.out.println("暂无用户，请返回添加");
		}
		else
		for (int number = 0; number < reader_SID.size(); number++) {
		
			System.out.print(reader_LID.get(number));
			System.out.print(reader_SID.get(number));
			System.out.print(reader_name.get(number));
			System.out.print(reader_sex.get(number));
			System.out.println();
			//还要优化
		}
         return reader_SID.size();


	}
	
	
	public static int book_to_readerindex(String book_number){
		int acid=0;
		for(int i=0;i<users.reader_info.reader_book.size();i++){
			for(String buffer:users.reader_info.reader_book.get(i)){
				if(buffer.equals(book_number)){
					acid=i;
				}
				else{
				}
			}
		}
		return acid;
	}

}
