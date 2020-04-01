package week1.day3;

public class reverseString {

	public static void main(String[] args) {
		String text = "Welcome";
		int j = text.length();
		char[] charArray = text.toCharArray();
		//System.out.println(charArray[1]);
		String a = "";
		for(int i=j-1;i>=0;i--)
		{
			a = a+(charArray[i]);
	    }
		System.out.println(a);

	}
}