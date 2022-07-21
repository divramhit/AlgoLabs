public class DSTNode {
    private int value;
    private DSTNode left;
    private DSTNode right;


    public int getValue() {
        return value;
    }

    public DSTNode getLeft() {
        return left;
    }

    public DSTNode getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(DSTNode left) {
        this.left = left;
    }

    public void setRight(DSTNode right) {
        this.right = right;
    }

    public DSTNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }

    public DSTNode(int value, DSTNode left, DSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

