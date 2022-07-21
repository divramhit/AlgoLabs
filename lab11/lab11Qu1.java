/*
Implement the basic quicksort algorithm to sort numeric/alphabetic keys using the:
a. Rightmost element
b. Leftmost element
as the pivot (partitioning element). Your output should show the intermediate partitions created
during the sorting process.
 */
public class lab11Qu1 {
    public static void main(String[] args) {
        int[] myArray = new int[]{5,1,19,25,17,21,5,19,20,9,15,14};
        quicksortRight(myArray, 0, myArray.length - 1);
        printArray(myArray, 0 , myArray.length - 1);
        quickSortLeft(myArray, 0, myArray.length - 1);

    }

    private static void quicksortRight(int[] myArray, int l, int r) {
        if (r > l){
            int pivotIndex = partitionRightPivot(myArray, l, r);
            quicksortRight(myArray, l, pivotIndex - 1);
            quicksortRight(myArray, pivotIndex + 1, r);
        }
    }

    private static void quickSortLeft(int[] myArray, int l, int r) {
    }

    static int partitionRightPivot(int A[], int l, int r){
        int pivot = A[r];
        int leftPointer = l; // instead of using i
        int rightPointer = r; // instead of using j

        while(leftPointer < rightPointer){
            // Looking for an element bigger than pivot from the left
            while(A[leftPointer] < pivot)
                leftPointer++;

            while((leftPointer < rightPointer) && A[rightPointer] >= pivot)
                rightPointer--;

            if (leftPointer < rightPointer)
                swap(A, leftPointer, rightPointer);
            else
                swap(A, leftPointer, r);
        }

        System.out.println("Pivot: " + pivot);
        System.out.print("Partition to the left: ");
        printArray(A, 0, leftPointer - 1);
        System.out.print("Partition to the right: ");
        printArray(A, leftPointer + 1, A.length - 1);
        System.out.println();
        return leftPointer;

    }

    int partitionLeftPivot(int A[], int l, int r){
        int pivot = A[l];
        int leftPointer = l; // instead of using i
        int rightPointer = r; // instead of using j

        while(leftPointer < rightPointer){
            // Looking for an element smaller than pivot from the left
            while(A[leftPointer] < pivot)
                leftPointer++;

            while((leftPointer < rightPointer) && A[rightPointer] > pivot)
                rightPointer--;

            if (leftPointer < rightPointer)
                swap(A, leftPointer, rightPointer);
            else
                swap(A, leftPointer, l);
        }

        return leftPointer;

    }

    private static void swap(int[] A, int i, int i1) {
        int temp = A[i];
        A[i] = A[i1];
        A[i1] = temp;
    }

    private static void printArray(int myArray[], int start, int end){
        System.out.print("[ ");
        for (int i = start; i <= end; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println(" ]");
    }
}

