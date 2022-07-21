public class DSTApp {
    public static void main(String[] args) {
        //String binValue = String.format("%7s", Integer.toBinaryString(60)).replace(' ', '0');
        //System.out.println(binValue);
        DST myDST = new DST();

        // insert the elements 60, 70, 20, 10, 40, 50, 30, 55
        myDST.insertElement(60);
        myDST.insertElement(70);
        myDST.insertElement(20);
        myDST.insertElement(10);
        myDST.insertElement(40);
        myDST.insertElement(50);
        myDST.insertElement(30);
        myDST.insertElement(35);

        myDST.inOrder(myDST.getRoot());

        System.out.println("\nIs 22 in the tree ?");
        DSTNode answer = myDST.searchElement(22);

        if (answer != null){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("\nIs 40 in the tree ?");
        answer = myDST.searchElement(40);

        if (answer != null){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("How many elements are there in the tree ? " + myDST.countElements());

        myDST.insertElement(22);
        System.out.println("Tree after inserting 22 is: " );
        myDST.inOrder(myDST.getRoot());

        System.out.println("\nHow many elements are there in the tree now ? " + myDST.countElements());




    }
}

