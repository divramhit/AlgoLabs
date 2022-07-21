import java.util.ArrayList;

public class boyerMooreAlgorithm {
	private ArrayList<Integer>patternMatchIndexes = new ArrayList<Integer>(); //Stores the starting Points of each Match
	private int patMatch_count;  //counts the number of times the pattern matched with the string
	private int comparison_count; //Counts the number of times a comparison was made with the current string
	
	public boyerMooreAlgorithm() {
		
	}
	
	//Improved Boyer-Moore Algorithm
	public void search(String str, String pattern) {
		patternMatchIndexes.clear();
		
		char[] char_str = str.toCharArray();
		char[] char_pat = pattern.toCharArray();
 		
		int last[] = buildLast(pattern);
		
		int strLength = char_str.length;
		int patLength = char_pat.length;
		
		int i = patLength - 1;
		
		int lo; //Changes here as well, this was initially declared in the first else statement after the loop 
		
		patMatch_count = 0; //resets the pattern count each time a new String is introduced
		comparison_count = 0; //resets the comparison counter each time a new String is introduced
		
		if (i > strLength - 1) {
			comparison_count++;
			return;
		}
		
		int j = patLength - 1;
		
		do {
			if (char_pat[j] == char_str[i]) {
				comparison_count++;
				
				if(j == 0) {
					comparison_count++;
					setCurrentPatternStart(i);
					//Change1 made here to address single match issue
					patMatch_count++;
					lo = last[char_str[i]];
					i = i + patLength - Math.min(j, 1 + lo);
					j = patLength - 1;
					//Change1 end here
					//return;		//Return statement removed for same reason as other algorithms, allow multiple pattern matching
				}
				else {
					comparison_count++;
					i--;
					j--;
				}
			}
			else {
				comparison_count++;
				lo = last[char_str[i]];
				i = i + patLength - Math.min(j, 1 + lo);
				j = patLength - 1;
			}
			
			comparison_count++;
		}
		while (i <= strLength - 1);
		
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
