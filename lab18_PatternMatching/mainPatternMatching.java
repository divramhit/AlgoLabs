import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainPatternMatching {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int bruteFroceAlgorithm_SumComparisons, KMPAlgorithm_SumComparisons, boyerMooreAlgorithm_SumComparisons;
		
		//This part of the code will go in the testing, JUNIT testing
		String str = "AAABBAABBABABAABBABAB";
		String pattern = "ABAB";
		
		bruteForce_search bruteForceSearch = new bruteForce_search();
		kmpSearch KMPSearch = new kmpSearch();
		boyerMooreAlgorithm BoyerMooreSearch = new boyerMooreAlgorithm();
		
		//START: Brute Force Algorithm
		System.out.println("Searching with BruteForce Algorithm:");
		bruteForceSearch.search(str, pattern);
		if (bruteForceSearch.getCurrentMatchCountNumber() > 0)
		{
			System.out.println("Pattern Match found " + bruteForceSearch.getCurrentMatchCountNumber() + " times");
			System.out.println("Patterns started at Index(es): " + bruteForceSearch.getCurrentPatternStart());
		}
		else {
			System.out.println("No Pattern Match found");
		}
		System.out.println("");
		//END: Brute Force Algorithm
		
		//START: KMP Algorithm
		System.out.println("Searching with KMP Algorithm:");
		KMPSearch.search(str, pattern);
		if (bruteForceSearch.getCurrentMatchCountNumber() > 0)
		{
			System.out.println("Pattern Match found " + bruteForceSearch.getCurrentMatchCountNumber() + " times");
			System.out.println("Patterns started at Index(es): " + bruteForceSearch.getCurrentPatternStart());
		}
		else {
			System.out.println("No Pattern Match found");
		}
		System.out.println("");
		//END: KMP Algorithm
		
		//START: BOYER MOORE Algorithm
		System.out.println("Searching with Boyer-Moore Algorithm:");
		BoyerMooreSearch.search(str, pattern);
		if (bruteForceSearch.getCurrentMatchCountNumber() > 0)
		{
			System.out.println("Pattern Match found " + bruteForceSearch.getCurrentMatchCountNumber() + " times");
			System.out.println("Patterns started at Index(es): " + bruteForceSearch.getCurrentPatternStart());
		}
		else {
			System.out.println("No Pattern Match found");
		}
		System.out.println("");
		//END: BOYER MOORE Algorithm
		
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
		bruteFroceAlgorithm_SumComparisons = 0;
		KMPAlgorithm_SumComparisons = 0;
		boyerMooreAlgorithm_SumComparisons = 0;
		
		try {
			BufferedReader filereader = new BufferedReader(new FileReader("C:\\Users\\Ramhit\\eclipse-workspace\\2019Y Lab\\lab18_PatternMatching\\patternMatching.txt"));
			
			String line;
			int choice = 0;
			
			System.out.println("===========================Main Menu================");
			System.out.println("\t1. Brute Force Algorithm.");
			System.out.println("\t2. KMP Algorithm.");
			System.out.println("\t3. Boyer Moore Algorithm.");
			System.out.println("===========================Enter Choice:================");
			choice = 3;		//Choice is hardcoded for now.
			
			while((line = filereader.readLine()) != null) {
				lineCounter++;
				System.out.print("Line :" + lineCounter + " ");
				
				if (choice == 1)
				{
				//Running the line through the Brute Force Algorithm
					bruteForceSearch.search(line, pattern);
					bruteFroceAlgorithm_SumComparisons += bruteForceSearch.getCurrentComparisonCountNumber();
					System.out.println("Comparisons were made : " + bruteForceSearch.getCurrentComparisonCountNumber() + " times.");
					if (bruteForceSearch.getCurrentMatchCountNumber() > 0)
					{
						//System.out.println("Pattern Match found " + patMatch_count + " times.");
						System.out.println("Pattern Match found " + bruteForceSearch.getCurrentMatchCountNumber() + " times");
						System.out.println("Patterns started at Index(es): " + bruteForceSearch.getCurrentPatternStart());
					}
					else {
						System.out.println("No Pattern Match found");
					}
				//End of Brute Force Algorithm
				}	
				else if(choice == 2)
				{
				//Running the line through the KMP Algorithm
					KMPSearch.search(line, pattern);
					KMPAlgorithm_SumComparisons += KMPSearch.getCurrentComparisonCountNumber();
					System.out.println("Comparisons were made : " + KMPSearch.getCurrentComparisonCountNumber() + " times.");
					if (KMPSearch.getCurrentMatchCountNumber() > 0)
					{
						//System.out.println("Pattern Match found " + patMatch_count + " times.");
						System.out.println("Pattern Match found " + KMPSearch.getCurrentMatchCountNumber() + " times");
					}
					else {
						System.out.println("No Pattern Match found");
					}
				//End of KMP Algorithm
				}
				else if(choice == 3) 
				{
					
				//Running the line through the BOYER MOORE Algorithm
					BoyerMooreSearch.search(line, pattern);
					boyerMooreAlgorithm_SumComparisons += BoyerMooreSearch.getCurrentComparisonCountNumber();
					System.out.println("Comparisons were made : " + BoyerMooreSearch.getCurrentComparisonCountNumber() + " times.");
					if (BoyerMooreSearch.getCurrentMatchCountNumber() > 0)
					{
						//System.out.println("Pattern Match found " + patMatch_count + " times.");
						System.out.println("Pattern Match found " + BoyerMooreSearch.getCurrentMatchCountNumber() + " times");
					}
					else {
						System.out.println("No Pattern Match found");
					}
				//End of BOYER MOORE Algorithm
				}
					
			}
			
			if (choice == 1){
				System.out.println("Total No of Comparisons made for whole using Brute Force :" + bruteFroceAlgorithm_SumComparisons);
			}
			else if(choice == 2) {
				System.out.println("Total No of Comparisons made for whole using KMP :" + KMPAlgorithm_SumComparisons);
			}
			else if(choice == 3) {
				System.out.println("Total No of Comparisons made for whole using BOYER MOORE :" + boyerMooreAlgorithm_SumComparisons);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Occurred: ");
			e.printStackTrace();
		}
		
		
		
	}

}
