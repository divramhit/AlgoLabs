import java.util.ArrayList;

public class bruteForce_search {
	private ArrayList<Integer>patternMatchIndexes = new ArrayList<Integer>(); //Stores the starting Points of each Match
	private int patMatch_count;  //counts the number of times the pattern matched with the string
	private int comparison_count; //Counts the number of times a comparison was made with the current string
	//BruteForceSearching
	public bruteForce_search() {
		
	}
	
	
	public void search(String str, String pattern) {
		patternMatchIndexes.clear();
		
		char char_str[] = str.toCharArray(); //string given needs to be converted into an array chars to be able to use them appropriately
		char char_pat[] = pattern.toCharArray(); //same for pattern string
		
		int string_len = char_str.length;
		int pat_len = char_pat.length;
		
		patMatch_count = 0; //resets the pattern count each time a new String is introduced
		comparison_count = 0; //resets the comparison counter each time a new String is introduced
		
		int j;
		
		for(int i = 0; i <=(string_len - pat_len); i++) {
			j = 0;
			
			while ((j < pat_len) && char_str[i + j] == char_pat[j]) {
				j++;
				comparison_count++;
			}
			
			if (j == pat_len)
			{
				comparison_count++;
				//System.out.println("Pattern starts at Position : " + i);
				setCurrentPatternStart(i);
				patMatch_count++;
				//return;	//Return statement removed to allow for multiple instances of pattern matching(This is a change added)
			}
			
			comparison_count++;
			
		}
		return;
	}
	
	
	public int getCurrentMatchCountNumber() { //Returns the current Matched pattern count OF the current string
		return this.patMatch_count;
	}
	
	public void setCurrentPatternStart(int index) { //Take the index obtained of a pattern that was matched and returns it 
		this.patternMatchIndexes.add(index);
	}
	
	public ArrayList<Integer> getCurrentPatternStart() {
		return this.patternMatchIndexes;
	}
	
	public int getCurrentComparisonCountNumber() { //Returns the amount of comparisons made for the current String
		return this.comparison_count;
	}

}
