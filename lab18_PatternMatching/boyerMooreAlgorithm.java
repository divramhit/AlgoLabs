
public class boyerMooreAlgorithm {
	public boyerMooreAlgorithm() {
		
	}
	
	//Improved Boyer-Moore Algorithm
	public void search(String str, String pattern) {
		char[] char_str = str.toCharArray();
		char[] char_pat = pattern.toCharArray();
 		
		int last[] = buildLast(pattern);
		
		int strLength = char_str.length;
		int patLength = char_pat.length;
		
		int i = patLength - 1;
		
		int lo;
		
		int patMatch_count = 0;
		
		if (i > strLength - 1) {
			return;
		}
		
		int j = patLength - 1;
		
		do {
			if (char_pat[j] == char_str[i]) {
				if(j == 0) {
					System.out.println("Pattern Match found at : " + i);
					//Changes made here to address single match issue
					patMatch_count++;
					lo = last[char_str[i]];
					i = i + patLength - Math.min(j, 1 + lo);
					j = patLength - 1;
					//Change1 end here
					//return;
				}
				else {
					i--;
					j--;
				}
			}
			else {
				lo = last[char_str[i]];
				i = i + patLength - Math.min(j, 1 + lo);
				j = patLength - 1;
			}
		}
		while (i <= strLength - 1);
		
		if (patMatch_count > 0)
		{
			System.out.println("Pattern Match found " + patMatch_count + " times.");
		}
		else {
			System.out.println("No Pattern Match found");
		}
		return;
	}
	
	public int[] buildLast(String pattern) {
		char[] char_pat = pattern.toCharArray();
		
		int last[] = new int[128];
		
		for(int i = 0; i < 128; i++) {
			last[i] = -1;
		}
		
		for(int i = 0; i < char_pat.length; i++) {
			last[char_pat[i]] = i;
		}
		
		return last;
	}
}
