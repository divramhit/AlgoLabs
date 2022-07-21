import java.util.ArrayList;
import java.util.Scanner;

public class Facebook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;
        int facebookSize;
        
        String nicknameCombinationString = null;
        ArrayList<String>realName = null;
        String[][] combinationStrings; 
        
        HashTableEntry hashTableEntry;
        HashTable hashTable;

        System.out.println("Enter number of people on Facebook: ");
        facebookSize = input.nextInt();
        input.nextLine(); //If ever inputs are made in consequence always add .nextLine() for each. This the simplest but there are another method using parseInt
        
        combinationStrings = new String[facebookSize][];
        hashTable = new HashTable(facebookSize + 10);
        
        System.out.println("Enter nickname full name combinations: ");

        for (int i = 0; i < facebookSize; i++) {
        	System.out.println(i);
            line = input.nextLine();
            String[] info = line.split(" ", 2);
            combinationStrings[i] = info;

            // to be continued

        }
        
        for (int i = 0; i <facebookSize; i++) {
        	for (int j = 0; j < 2; j++) {
        		if (j == 0) {
        			//Nickname part
        			nicknameCombinationString = combinationStrings[i][j];
        		}
        		else {
        			//realName part
        			realName = new ArrayList<String>();
        			realName.add(combinationStrings[i][j]);
        		}
        	}
        	
        	hashTable.put(new HashTableEntry(nicknameCombinationString, realName));
        	
        }
        
        ArrayList<String>nicknamesInputArrayList = new ArrayList<String>();
        nicknamesInputArrayList = null;
        int hastTable_NickName_pos = 0;
        
        System.out.println("Enter nicknames: ");

        for (int i = 0; i < facebookSize; i++) {
        	System.out.println(i);
            line = input.nextLine();
//            String[] info = line.split(" ", 2);
//            combinationStrings[i] = info;

            hastTable_NickName_pos = hashTable.get(line);
            
            if (hastTable_NickName_pos >= 0) {
            	System.out.println(hashTable.getRealStringName(hastTable_NickName_pos));
            }
            else if(hastTable_NickName_pos == -1){
            	System.out.println("impostor!!!");
            }
        }


    }
}
