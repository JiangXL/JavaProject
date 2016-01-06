package Admin;
import java.util.Scanner;
public class admin {
       public static boolean passwd(){
    	   //可建管理员的非静态类，由此新建不同的管理员
    	   Scanner input=new Scanner(System.in);
    	   System.out.println("输入admin密码");
    	   boolean temp = false;

    	   for(int i=3;i>=1;i--){
    	   if(input.nextInt()==123456){
    		 temp=true;
    		 break;
    	   }
    	   else
    	   {    
    		   temp=false;
    		   System.out.print("密码错误,");
    		   System.out.println("你还有"+(i-1)+"次输入机会");
    		   }
    	   }
       
    	   return temp;
       }
	//密码管理
       //增加登出选项
      
}
