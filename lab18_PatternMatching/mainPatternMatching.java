import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainPatternMatching {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String str = "AAABBAABBABABAABBABAB";
		String pattern = "ABAB";
		
		bruteForce_search bruteForceSearch = new bruteForce_search();
		kmpSearch KMPSearch = new kmpSearch();
		boyerMooreAlgorithm BoyerMooreSearch = new boyerMooreAlgorithm();
		
		System.out.println("Searching with BruteForce Algorithm:");
		bruteForceSearch.search(str, pattern);
		System.out.println("");
		
		System.out.println("Searching with KMP Algorithm:");
		KMPSearch.search(str, pattern);
		System.out.println("");
		
		System.out.println("Searching with Boyer-Moore Algorithm:");
		BoyerMooreSearch.search(str, pattern);
		System.out.println("");
		
//		Labsheet18 Question Start
		
//		Write a simple program (in JAVA) that reads a small text file and applies the following string searching
//		algorithms to search for text inputs from the keyboard.
//		i. Brute-force searching
//		ii. KMP searching
//		iii. Boyer-Moore searching
//		You are also required to count the number of comparisons (for the same text file and the same search
//		pattern) done in each case and display same in a tabular format.
		
		pattern = "QPNE";	
		int lineCounter = 0;
		
		try {
			BufferedReader filereader = new BufferedReader(new FileReader("C:\\Users\\Ramhit\\eclipse-workspace\\2019Y Lab\\lab18_PatternMatching\\patternMatching.txt"));
			
			String line;
			
			while((line = filereader.readLine()) != null) {
				lineCounter++;
				System.out.print("Line :" + lineCounter + " ");
				bruteForceSearch.search(line, pattern);
				
				//Change the Search Algorithms to enable adding and fit this question add a function to return number of times matching occurred
				//Need to account for number of comparisons done as well 
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occurred: ");
			e.printStackTrace();
		}
		
		
		
	}

}
