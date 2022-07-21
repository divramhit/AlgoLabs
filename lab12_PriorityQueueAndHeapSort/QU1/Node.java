package QU1;

class Node{
    private int element;
    private Node next;

    public Node(){
        element = 0;
        next = null;
    }

    public Node(int element){
        this.element = element;
        next = null;
    }

    public int getElement(){
        return element;
    }

    public Node getNext(){
        return next;
    }

    public void setElement(int newElement){
        element = newElement;
    }

    public void setNext(Node newNext){
        next = newNext;
    }

    public String toString(){
        return Integer.toString(this.element);
    }
} // end class Node
