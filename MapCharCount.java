package week3.day4;

import java.util.HashMap;
import java.util.Map;

class MapCharCount
{
	public static Map<Character, Integer> constructFrequencyMap(char[] chars) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for (char ch: chars) {
			if (!freq.containsKey(ch)) {
				freq.put(ch, 0);
			}
			freq.put(ch, freq.get(ch) + 1);
		}

		return freq;
	}

	public static int countOccurrences(Map<Character, Integer> freq, char ch) {
		return freq.get(ch);
	}

	public static void main(String[] args)
	{
		String str = "FOCUS ON SOME JAVA PROGRAMMING";
		char ch = 'A';

		Map<Character, Integer> freq = constructFrequencyMap(str.toCharArray());
		System.out.println("Character " + ch + " occurs " +
							countOccurrences(freq, ch) + " times.");
	}
}

