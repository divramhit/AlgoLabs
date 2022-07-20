
public class mainPatternMatching {

	public static void main(String[] args) {
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
		
		//Labsheet18 Question
//		Write a simple program (in JAVA) that reads a small text file and applies the following string searching
//		algorithms to search for text inputs from the keyboard.
//		i. Brute-force searching
//		ii. KMP searching
//		iii. Boyer-Moore searching
//		You are also required to count the number of comparisons (for the same text file and the same search
//		pattern) done in each case and display same in a tabular format.
		
		
		
	}

}
