public class HashTable {
    private int size;
    private HashTableEntry[] hashTable;

    public HashTable(int size) {
        // Question: Should I have set the size to the next biggest prime number? If so, how to do it ?
        this.size = size;
        this.hashTable = new HashTableEntry[size];
    }

    private int hashValue(String nickname){
        // Using hash function for strings in lecture notes
        int h = (int) nickname.charAt(0);

        for (int i = 1; i < nickname.length(); i++) {
            h = (h*32 + nickname.charAt(i)) % this.size;
        }
        return h;
    }

    public void put(HashTableEntry hte){
        int position = hashValue(hte.getNickname());

        while (hashTable[position] != null){
            // Calculate next available position using linear probing
            position = (position + 1) % this.size;
        }
        hashTable[position] = hte;
    }

    public int get(String nickname){
        int initialPosition = hashValue(nickname);      
        int currentPosition = initialPosition;

        if (!hashTable[initialPosition].getNickname().equals(nickname)){
            currentPosition = (currentPosition + 1) % this.size;

            while(currentPosition != initialPosition){
                if (hashTable[currentPosition].getNickname().equals(nickname)){
                    return currentPosition;
                }
            }
        } else {
            return initialPosition;
        }

        return -1;
    }

    public int remove(String nickname){
        return -1;
    }
    
    public String getNickname(int index) {
    	return this.hashTable[index].getNickname();
    }

    public void printTable(){
        for (HashTableEntry hte: this.hashTable ) {
            System.out.println(hte.getNickname() + ": " + hte.getRealName());
        }
    }
}
