import java.util.ArrayList;

public class kmpSearch {
	private ArrayList<Integer>patternMatchIndexes = new ArrayList<Integer>(); //Stores the starting Points of each Match
	private int patMatch_count;  //counts the number of times the pattern matched with the string
	private int comparison_count; //Counts the number of times a comparison was made with the current string
	
	public kmpSearch() {
		
	}
	
	//Improved KMP Searching for multiple Pattern Matching instances
	public void search(String str, String pattern) {
		patternMatchIndexes.clear();
		
		char[] char_str = str.toCharArray();
		char[] char_pat = pattern.toCharArray();
		
		int strLength = char_str.length;
		int patLength = char_pat.length;
		
		int fail[] = computeFail(pattern);
		
		int i = 0;
		int j = 0;
		patMatch_count = 0; //resets the pattern count each time a new String is introduced
		comparison_count = 0; //resets the comparison counter each time a new String is introduced
		
		while (i < strLength) {
			if (char_pat[j] == char_str[i]) {
				comparison_count++;
				
				if (j == patLength - 1) {
					comparison_count++;
					//System.out.println("Pattern Match found at : " + (i - patLength + 1));
					setCurrentPatternStart((i - patLength + 1));
					patMatch_count++;
					//return;
				}
				
				i++;
				
				if (j < patLength - 1) { //Change added here to allow for more pattern matching as leaving it as it was causes index out of bounds error
					comparison_count++;
					j++;
				}
				
			}
			else if(j > 0) {
				comparison_count++;
				j = fail[j - 1];
			}
			else {
				comparison_count++;
				i++;
			}
			
			comparison_count++;
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
