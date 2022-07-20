
public class kmpSearch {
	
	public kmpSearch() {
		
	}
	
	//Improved KMP Searching for multiple Pattern Matching instances
	public void search(String str, String pattern) {
		
		char[] char_str = str.toCharArray();
		char[] char_pat = pattern.toCharArray();
		
		int strLength = char_str.length;
		int patLength = char_pat.length;
		
		int fail[] = computeFail(pattern);
		
		int i = 0;
		int j = 0;
		int patMatch_count = 0;
		
		while (i < strLength) {
			if (char_pat[j] == char_str[i]) {
				if (j == patLength - 1) {
					System.out.println("Pattern Match found at : " + (i - patLength + 1));
					patMatch_count++;
					//return;
				}
				
				i++;
				
				if (j < patLength - 1) {
					j++;
				}
				
			}
			else if(j > 0) {
				j = fail[j - 1];
			}
			else {
				i++;
			}
		}
		
		if (patMatch_count > 0)
		{
			System.out.println("Pattern Match found " + patMatch_count + " times.");
		}
		else {
			System.out.println("No Pattern Match found");
		}
		return;
	}
	
	public int[] computeFail(String pattern) {
		
		char[] char_pattern = pattern.toCharArray();
		
		int fail[] = new int[pattern.length() - 1];
		fail[0]  = 0;
		
		int patternLength = char_pattern.length;
		
		int j =0;
		int i =1;
		
		while(i < patternLength - 1) {
			if (char_pattern[j] == char_pattern[i]) {
				fail[i] = j + 1;
				
				i++;
				j++;
			}
			else if (j > 0) {
				j = fail[j - 1];
			}
			else {
				fail[i] = 0;
				i++;
			}
		}
		
		return fail;
 	}

}
