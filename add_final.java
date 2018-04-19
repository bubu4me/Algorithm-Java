/* 
 * 大数加法，求上百位数的加法
 */

package Add;
import java.util.Scanner;
public class add_final 
{
	
	//假设num2.length>num1.length;
	public static String addition(String num1,String num2) 
	{
				
    	//反转字符串
    	num1=reverseString(num1).toString();
    	num2=reverseString(num2).toString();    	
    	
    	//res表示最后结果
    	StringBuilder res = new StringBuilder();
    	res.reverse();
    	
    	int carry=0;  //carry表示进位；
    	
        //获取两个数的位数；
        int N1=num1.length();
        int N2=num2.length();
        
        //i为循环变量
        for(int i=0;i<N1;++i)
        {
        	        	
        	//老师的方法
        	int i1=charToInt(num1.charAt(i));
        	int i2=charToInt(num2.charAt(i));
        	int r=i1+i2+carry;
        	if(r>9)
        	{
        		carry=1;
        		r=r-10;
        	}
        	else carry=0;
        	res.append(r);
        }
        for(int i=N1;i<N2;++i)
        {
        	int i2=charToInt(num2.charAt(i));
        	int r=i2+carry;
        	if(r>9)
        	{
        		carry=1;
        		r=r-10;
        	}
        	else carry=0;
        	res.append(r);
        }
        if(carry==1)
        {
        	res.append(1);
        }
        
        if(res.toString().length()<=0)
        	return "0";
        return res.reverse().toString();
	}
	
	//char转int类型
	public static int charToInt(char a)
	{
		int b=(int)a-(int)'0';
		return b;
	}
	
	//反转字符串
	public static StringBuilder reverseString(String a)
	{
		StringBuilder builder=new StringBuilder(a);
		builder.reverse();
		return builder;
	}
	
	public static String myAdd(String x, String y) 
	{
		// 获取位数
		int x_len = x.length();
		int y_len = y.length();

		// 以下都是判断x和y数值的大小
		if (x_len == y_len) 
		{
			if (x.compareTo(y) > 0) 
			{
				return addition(y, x);
			} 
			else
				return addition(x, y);
		} 
		else if (x_len > y_len) 
		{
			return addition(y, x);
		} 
		else
			return addition(x, y);
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String x=sc.nextLine();
		String y=sc.nextLine();
		
		//去掉前导0
		x=x.replaceFirst("^0*", "");
		y=y.replaceFirst("^0*", "");
		System.out.println(myAdd(x,y));
		sc.close();
	}
}