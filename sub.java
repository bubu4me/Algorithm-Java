import java.util.Scanner;
public class sub
{
	//��char��תΪint����
	public static int charToInt(char a)
	{
		int b=(int)a-(int)'0';
		return b;
	}
	
	//��ת�ַ���
	public static StringBuilder reverseString(String a)
	{
		StringBuilder builder=new StringBuilder(a);
		builder.reverse();
		return builder;
	}
	
	//����num2>num1,��num2��ȥnum1��
	public static String subtract(String num1, String num2)
	{
		//ɾ��ǰ��0;
		num1=num1.replaceFirst("^0*", "");
		num2=num2.replaceFirst("^0*", "");
		
		//��ת�ַ���
		num1=reverseString(num1).toString();
		num2=reverseString(num2).toString();
		
		int carry=0;   //��ǰһλ��ȡ10������ֵΪ0��
		
		//resΪ�����
		StringBuilder res=new StringBuilder();
		res.reverse();
		
		//��ȡλ��
		int N1=num1.length();
		int N2=num2.length();
		
		//λ���ϵ�ֵ���
		for(int i=0;i<N1;++i)
		{
			//��ȡλ���ϵ�ֵ
			int i1=charToInt(num1.charAt(i));
			int i2=charToInt(num2.charAt(i));
			int r=i2-carry-i1;
			//�ж�i1��i2�Ĵ�С
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
		
		//�ж����������Ƿ�ȫΪ0��
		if(res.toString().length()<=0)
			return "0";
		
		//num1=num2ʱɾ�������ǰ��0
		if(num1.equals(num2)==true)
		 {
			return "0";
		 }
		
		//ɾ������е�ǰ��0
		//����111��22�Ľ����089���ǲ����ϵ�
		String result=res.reverse().toString();
		result=result.replaceFirst("^0*", "");
		return result;
	}
	
	//�ж�num1��num2�Ĵ�С������num2>num1
	public static boolean strCompare(String num1,String num2)
	{
		//ɾ��ǰ��0;������ֽ����ǰ��0�������������
		//����000111��999�Ľ����112���Ǵ���ģ�
		num1=num1.replaceFirst("^0*", "");
		num2=num2.replaceFirst("^0*", "");
		
		//��ȡλ��;
		int N1=num1.length();
		int N2=num2.length();
		
		//���¶����ж�x��y��ֵ�Ĵ�С����ȷ����������������Ǹ���
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
	
	//���ؽ��,num2>num1
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
