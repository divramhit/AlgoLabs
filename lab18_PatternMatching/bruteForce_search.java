
public class bruteForce_search {
	
	//BruteForceSearching
	public bruteForce_search() {
		
	}
	
	
	public void search(String str, String pattern) {
		char char_str[] = str.toCharArray(); //string given needs to be converted into an array chars to be able to use them appropriately
		char char_pat[] = pattern.toCharArray(); //same for pattern string
		
		int string_len = char_str.length;
		int pat_len = char_pat.length;
		
		int patMatch_count = 0; //counts the number of times the pattern matched with the string
		
		int j;
		
		for(int i = 0; i <=(string_len - pat_len); i++) {
			j = 0;
			
			while ((j < pat_len) && char_str[i + j] == char_pat[j]) {
				j++;
			}
			if (j == pat_len)
			{
				System.out.println("Pattern starts at Position : " + i);
				patMatch_count++;
				//return;
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

}
