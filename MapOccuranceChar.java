package week3.day4;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapOccuranceChar {
	
	public static void countChar(String str)
	{
		str=str.replace(" ","");
		Map<Character,Integer> countChar=new LinkedHashMap<Character,Integer>();
		for(char ch : str.toCharArray())
		{
			if (countChar.containsKey(ch))
					{
				countChar.put(ch,  countChar.get(ch)+1);
					}
			else
			{
				countChar.put(ch, 1);
			}
		}
		System.out.println("Freqeuncy of Character counts in 'FOCUS ON SOME JAVA PROGRAMMING' ");
		for(Map.Entry<Character,Integer> ent :countChar.entrySet())		
		{
		System.out.println(ent);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countChar("FOCUS ON SOME JAVA PROGRAMMING");
	}

}
