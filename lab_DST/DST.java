/*Implement a digital search tree that will store numeric values (in the range 0 – 100). You are also required to implement the following methods:
    insertElement
    searchElement
    countElement
* */
public class DST {
    // 0 - 100 means 7 bits
    private DSTNode root;
    private static int maxNumBits = 7;

    public DST(){
        root = null;
    } // end constructor

    public DSTNode getRoot(){
        return root;
    } // end getRoot

    public void insertElement(int value){
        DSTNode newNode = new DSTNode(value);

        // the binary value is padded on the left with zeroes to make it 7 bits
        String binValue = String.format("%7s", Integer.toBinaryString(value)).replace(' ', '0');

        if(root == null)
            root = newNode;
        else {
            int numBits = maxNumBits - 1;
            DSTNode parent, current;
            parent = current = root;

            while (current != null){
                parent = current;

                if (bit(Integer.parseInt(binValue, 2), numBits) == 0){
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
                numBits--;
            }

            current = newNode;
            if(bit(Integer.parseInt(binValue, 2), numBits + 1) == 0){
                parent.setLeft(current);
            } else {
                parent.setRight(current);
            }
        }

    }

    public static int bit (int n, int k){
        return n >> k & 1;
    }

    public DSTNode searchElement(int searchValue){
        DSTNode tmp = root;

        int numBits = maxNumBits - 1;
        String binValue = String.format("%7s", Integer.toBinaryString(searchValue)).replace(' ', '0');

        while((tmp != null) && (tmp.getValue() != searchValue)){
            if (bit(Integer.parseInt(binValue, 2), numBits) == 0){
                tmp = tmp.getLeft();
            } else {
               tmp = tmp.getRight();
            }

            numBits--;
        }

        return tmp;
    }

    public int countElements(){
        return countElementsFromNode(root);
    }

    private int countElementsFromNode(DSTNode node){

        if (node == null) return 0;

        // node is a leaf
        if (node.getLeft() == null && node.getRight() == null) return 1;

        return 1 + countElementsFromNode(node.getLeft()) + countElementsFromNode(node.getRight());
    }

    public void inOrder(DSTNode node){
        if(node != null){
            inOrder(node.getLeft());
            System.out.print("\t" + node.getValue());
            inOrder(node.getRight());
        }
    } // end inOrder
}
