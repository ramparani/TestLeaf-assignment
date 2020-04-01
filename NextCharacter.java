package week1.day3;

public class NextCharacter {

	public static void main(String[] args) {
		String input = "A1B2C3";
		char[] a = input.toCharArray();
	//	--System.out.println(a);
		String b = "";
		String c = "";
		String str ="";
		String num = "";
		int m=0;
		String k ="";
		String reverse = "";
		for(int i=0;i<=input.length()-1;i=i+2)
		{
		b =b+a[i];
	   }
	//--	System.out.println(b);
		for(int i=1;i<=input.length()-1;i=i+2)
		{
		c =c+a[i];
	   }
	//--	System.out.println(c);
		for(int i=0;i<=b.length()-1;i++)
		{
			for(int j=i;j<=i;j++)
			{
			char ch = b.charAt(i);
			int ascii = ch;
			//int castascii = (int)ch;
            int d = ascii+1;
            str = str+ Character.toString((char)d);
             m = j+2;
           // int k=0;
            //System.out.println(str);
           // System.out.println( Integer.valueOf(String.valueOf(m)));
            num=num+m;
           // System.out.println(num);
           // System.out.println(str+num);
           k=str+num;
			}
		} 
		
		//--System.out.println(k);
		// System.out.println(num);
		
        //System.out.println( Integer.valueOf(String.valueOf(m)));
		//System.out.println(k);
	//System.out.println(k.charAt(0)+k.charAt(2)+k.charAt(1)+k.charAt(3)+k.charAt(5)+k.charAt(4));
	for(int i = 0; i<k.length();i=i+3)
	{
		reverse = reverse+k.charAt(i);
		//char[] rev = k.toCharArray();
		//reverse = reverse+rev[i];
		
	}
	for (int j =1;j<k.length();j=j+3)
	{
		reverse = reverse+k.charAt(j);
	}
	for (int l =2;l<k.length();l=l+3)
	{
		reverse = reverse+k.charAt(l);
	}
	System.out.println(reverse);
	}
	
	}
