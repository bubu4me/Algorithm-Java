import java.util.Scanner;
public class sub
{
	//将char型转为int类型
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
	
	//假设num2>num1,即num2减去num1；
	public static String subtract(String num1, String num2)
	{
		//删除前导0;
		num1=num1.replaceFirst("^0*", "");
		num2=num2.replaceFirst("^0*", "");
		
		//反转字符串
		num1=reverseString(num1).toString();
		num2=reverseString(num2).toString();
		
		int carry=0;   //向前一位数取10，赋初值为0；
		
		//res为最后结果
		StringBuilder res=new StringBuilder();
		res.reverse();
		
		//获取位数
		int N1=num1.length();
		int N2=num2.length();
		
		//位数上的值相减
		for(int i=0;i<N1;++i)
		{
			//获取位数上的值
			int i1=charToInt(num1.charAt(i));
			int i2=charToInt(num2.charAt(i));
			int r=i2-carry-i1;
			//判断i1和i2的大小
			if(r<0)
			{
				carry=1;
				r=r+10;
			}
			else carry=0;
			res.append(r);
		}
		for(int i=N1;i<N2;++i)
		{
			int i2=charToInt(num2.charAt(i));
			int r=i2-carry;
			if(r<0)
			{
				carry=1;
				r=r+10;
			}
			else carry=0;
			res.append(r);
		}
		
		//判断两个数字是否全为0；
		if(res.toString().length()<=0)
			return "0";
		
		//num1=num2时删除结果的前置0
		if(num1.equals(num2)==true)
		 {
			return "0";
		 }
		
		//删除结果中的前置0
		//例如111，22的结果得089，是不符合的
		String result=res.reverse().toString();
		result=result.replaceFirst("^0*", "");
		return result;
	}
	
	//判断num1与num2的大小，假设num2>num1
	public static boolean strCompare(String num1,String num2)
	{
		//删除前导0;否则出现结果因前导0而计算错误的情况
		//例如000111，999的结果得112，是错误的；
		num1=num1.replaceFirst("^0*", "");
		num2=num2.replaceFirst("^0*", "");
		
		//获取位数;
		int N1=num1.length();
		int N2=num2.length();
		
		//以下都是判断x和y数值的大小，以确定输出的是正数还是负数
		if(N1==N2)
		{
			if(num2.compareTo(num1)>=0)
			{
				return true;
			}
			else  return false;
		}
		else if(N2>N1)
		{
			return true;
		}
		else return false;
	}
	
	//返回结果,num2>num1
	public static String mySub(String num1, String num2)
	{
		
		if(strCompare(num1,num2)==true)
		{
			return subtract(num1,num2);
		}
		else return '-'+subtract(num2,num1);
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String x=sc.next();
		String y=sc.next();
		System.out.println(mySub(y,x));
		sc.close();
	}
}
