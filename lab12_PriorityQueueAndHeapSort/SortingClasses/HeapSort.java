package SortingClasses;

public class HeapSort {
    public static void main(String[] args) {
        int[] myArray = {2, 5, 16, 4, 10, 23, 39, 18, 26, 15};

        System.out.println("Elements before sort: ");
        for(int num : myArray){
            System.out.print("\t" + num);
        }
        System.out.println();System.out.println();
        heapSort(myArray);

        System.out.println("Elements after sort: ");
        for(int num : myArray){
            System.out.print("\t" + num);
        }

    } // end main

    public static void heapSort(int[] myArray){
        int[] heap = new int[myArray.length + 1];

        // heapify the array
        for(int i = 0; i < myArray.length; i++){
            heap[i + 1] = myArray[i];
            upheap(heap, i + 1);
        }

        // while the array is not empty, remove and replace the root, reheap the new root
        for(int i = 1; i < heap.length; i++){
            int tmp = heap[1];
            heap[1] = heap[heap.length - i];
            heap[heap.length - i] = tmp;

            downheap(heap, 1, heap.length - 1 - i);
        }

        System.arraycopy(heap, 1, myArray, 0, myArray.length);
    } // end heapSort

    public static void upheap(int[] heap, int index){
        int tmp;
        while ((index > 1) && (heap[index/2] < heap[index])){
            tmp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = tmp;
            index = index/2;
        }
    } // end upheap

    public static void downheap(int[] heap, int index, int size){
        int j = index * 2;
        int tmp;

        while(j <= size){			// while(j < size) was preventing us to swap the first element with the second to get the maximum as root
            if(j < size && heap[j] < heap[j + 1])   // we should add condition j < size, because if j = size then, we have a single child for the node on which we're performing a downheap
                j++;
            if(heap[index] >= heap[j])
                break;
            tmp = heap[index];
            heap[index] = heap[j];
            heap[j] = tmp;
            index = j;
            j *= 2;
        }
    } // end downheap
}
