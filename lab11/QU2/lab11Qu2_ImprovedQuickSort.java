package QU2;

/*
Implement an improved quicksort algorithm using:
a. Insertion sort for smaller sub-lists (let’s say list of size < 5)
b. Median-of-three method
 */
public class lab11Qu2_ImprovedQuickSort {
    public static void main(String[] args) {
        int[] myArray = new int[]{5,1,19,25,17,21,5,19,20,9,15,14};

        /*Checking if findMedian method works
        int l = 0;
        int r =myArray.length - 1;
        int mid = (l + r) / 2;
        int indexMedian = findMedian(myArray,l,mid,r);

        printArray(myArray, 0, myArray.length - 1);
        System.out.println("The median of "+ myArray[l] + " " + myArray[mid] + " " + myArray[r] + " is at index " + indexMedian);
        System.out.println("Its value is " + myArray[indexMedian]);
         */

        System.out.print("Array before sorting: ");
        printArray(myArray, 0, myArray.length - 1);
        System.out.println("Array after sorting: ");
        improvedQuicksort(myArray, 0, myArray.length - 1);
        printArray(myArray, 0, myArray.length - 1);
    }

    private static void improvedQuicksort(int[] A, int l, int r){
        if(r > l){
            int pivotIndex = partition(A, l, r);
            improvedQuicksort(A, l, pivotIndex - 1);
            improvedQuicksort(A, pivotIndex + 1, r);
        }
    }

    private static int partition (int[] A, int l, int r){

        int leftPointer = l;
        int rightPointer = r;

        if (((r - l) + 1) > 5){
            int mid = (leftPointer + rightPointer) / 2;

            int indexMedian = findMedian(A, leftPointer,mid, rightPointer);

            swap(A, indexMedian, rightPointer);

            int pivot = A[r];

            while(leftPointer < rightPointer) {
                while (A[leftPointer] < pivot)
                    leftPointer++;

                while (leftPointer < rightPointer && A[rightPointer] >= pivot)
                    rightPointer--;

                if (leftPointer < rightPointer)
                    swap(A, rightPointer, leftPointer);
                else
                    swap(A, leftPointer, r);
            }
        } else {
            // If the partition length is less than 5, sort it using insertion sort
            insertionSort(A, l, r, A.length);
        }
        return leftPointer;
    }

    private static int findMedian(int[] A, int l, int mid, int r){
        int[] nums = new int[]{A[l],A[mid],A[r]};
        int indexMedian = l;

        // Insertion sort the array
        insertionSort(nums, 0, nums.length - 1, nums.length);

        if (nums[1] == A[mid])
            indexMedian = mid;
        else if (nums[1] == A[r])
            indexMedian = r;

        return indexMedian;
    }

    public static void insertionSort(int[] A, int start, int end, int n){
        for (int i = 1; i < n; i++) {
            int j = i;
            int key = A[i];

            while(j > 0 && A[j - 1] > key){
                A[j] = A[j - 1];
                j--;
            }

            A[j] = key;
        }
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

