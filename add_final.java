/* 
 * �����ӷ������ϰ�λ���ļӷ�
 */

package Add;
import java.util.Scanner;
public class add_final 
{
	
	//����num2.length>num1.length;
	public static String addition(String num1,String num2) 
	{
				
    	//��ת�ַ���
    	num1=reverseString(num1).toString();
    	num2=reverseString(num2).toString();    	
    	
    	//res��ʾ�����
    	StringBuilder res = new StringBuilder();
    	res.reverse();
    	
    	int carry=0;  //carry��ʾ��λ��
    	
        //��ȡ��������λ����
        int N1=num1.length();
        int N2=num2.length();
        
        //iΪѭ������
        for(int i=0;i<N1;++i)
        {
        	        	
        	//��ʦ�ķ���
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
	
	//charתint����
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
	
	public static String myAdd(String x, String y) 
	{
		// ��ȡλ��
		int x_len = x.length();
		int y_len = y.length();

		// ���¶����ж�x��y��ֵ�Ĵ�С
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
		
		//ȥ��ǰ��0
		x=x.replaceFirst("^0*", "");
		y=y.replaceFirst("^0*", "");
		System.out.println(myAdd(x,y));
		sc.close();
	}
}