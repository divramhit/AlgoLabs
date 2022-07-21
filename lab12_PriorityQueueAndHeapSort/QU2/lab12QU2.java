package QU2;

public class lab12QU2 {
    public static void heapSort(Assignment[] myAssignments){
        Assignment[] heap = new Assignment[myAssignments.length + 1];

        // heapify the array
        for(int i = 0; i < myAssignments.length; i++){
            heap[i + 1] = myAssignments[i];
            upheap(heap, i + 1);
        }

        // while the array is not empty, remove and replace the root, reheap the new root
        for(int i = 1; i < heap.length; i++){
            Assignment tmp = heap[1];
            heap[1] = heap[heap.length - i];
            heap[heap.length - i] = tmp;

            downheap(heap, 1, heap.length - 1 - i);
        }

        System.arraycopy(heap, 1, myAssignments, 0, myAssignments.length);
    } // end heapSort

    public static void upheap(Assignment[] heap, int index){
        Assignment tmp;

        // sort based on deadlines
        while ((index > 1) && (heap[index/2].getWeekDeadline() > heap[index].getWeekDeadline())){
            tmp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = tmp;
            index = index/2;
        }

        // TODO: sort based on maximum mark

        // TODO: sort based on number of credits
    } // end upheap

    public static void downheap(Assignment[] heap, int index, int size){
        int j = index * 2;
        Assignment tmp;

        while(j <= size){			// while(j < size) was preventing us to swap the first element with the second to get the maximum as root
            if(j < size && (heap[j].getWeekDeadline() < heap[j + 1].getWeekDeadline()))   // we should add condition j < size, because if j = size then, we have a single child for the node on which we're performing a downheap
                j++;
            if(heap[index].getWeekDeadline() >= heap[j].getWeekDeadline())
                break;
            tmp = heap[index];
            heap[index] = heap[j];
            heap[j] = tmp;
            index = j;
            j *= 2;
        }
    } // end downheap
}
