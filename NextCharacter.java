package week1.day3;

public class NextCharacter {
	
	public static void main(String[] args) {
		String input = "A1B2C3";
		char[] charArray = input.toCharArray();
		//System.out.println(charArray);
		String a = "";
		String str = "";
		//String b = "";
		int num = 0;
		String k="";
	//	String result = "";
		for(int i=0;i<=input.length()-1;i=i+2)
		{
		a = a+charArray[i];
		}
		
	//	System.out.println(a);
		
		for(int i=0;i<=a.length()-1;i++)
		{
		
			 for(int j=i+1; j<=a.length();j=j+3)
			  {
				 char ch = a.charAt(i);
				 int ascii = ch;
				 int d = ascii+1;
				 str = Character.toString((char)d);
		         num = j+1;
		         k = k+(str+num);
		        
	          }
	  }
		 System.out.println(k);
	}

}
