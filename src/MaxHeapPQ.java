// Represents a Max Heap Priority Queue
public class MaxHeapPQ {
    public int n;   // size of the heap
    public int[] heap; // array representing the heap; first element is always 0 (empty

    public MaxHeapPQ(int capacity) {
        // Constructor
        heap = new int[capacity+1];
        n = 0;
    }

    public boolean isEmpty() {
        // Determine if the heap is empty
        return n == 0;
    }

    public int size() {
        // Return the number of elements in the heap
        return n;
    }

    public void resize(int newCapacity) {
        // Resize the heap if necessary
        int[] newHeap = new int[newCapacity];
        for (int i = 0; i < heap.length; i++) newHeap[i] = heap[i];
        this.heap = newHeap;
    }

    public void insert(int x) {
        // Insert element x into the Max Heap; call swim() to reheapify the heap
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    public int deleteMax() {
        // Delete the maximum element in a max heap; call sink() to reheapify the heap
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1] = 0;
        if (n > 0 && (n == (heap.length - 1) / 4)) resize(heap.length / 2);
        return max;
    }

    public void swim(int k) {
        // Bottom-up reheapify technique to maintain the heap property when inserting into the heap
        // 'k' is the index of the element being inserted
        while (k > 1 && parent(k) < get(k)) {
            int temp = get(k);
            heap[k] = parent(k);
            heap[k/2] = temp;
            k = k/2;
        }
    }

    public void sink(int k) {
        // Top-down reheapify (sink) operation to maintain the max heap property
        boolean isHeapified = false;
        while (!isHeapified && 2 * k <= n) {
            int j = 2 * k;
            if (j < n && get(j) < get(j+1)) j++;
            if (get(k) >= get(j)) {
                isHeapified = true;
            } else {
                swap(k, j);
                k = j;
            }
        }
    }

    public int get(int k) {
        // return the element at index k
        return heap[k];
    }

    public int parent(int k) {
        // Return the index of the parent node at index k
        return heap[k/2];
    }

    public int left(int k) {
        // Return the index of left child of node at index k
        return heap[2 * k];
    }
    public int right(int k) {
        // Return the index of right child of node at index k
        return heap[2 * k + 1];
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int findMax() {
        // Return the element with maximum value in the heap
        return heap[1];
    }

    public void display() {
        // Display the elements in the heap
        for (int i = 0; i < heap.length; i++) {
            if (get(i) == 0) {
                System.out.print("null" + " ");
            } else {
                System.out.print(get(i) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeapPQ pq = new MaxHeapPQ(3);    // 0\ null null null

        // Measure time for insert() method
        long startTimeInsert = System.nanoTime();
        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        long endTimeInsert = System.nanoTime();
        long timeTakenInsert = endTimeInsert - startTimeInsert;

        System.out.print("Heap: "); pq.display();
        System.out.println("Size: " + pq.size());
        System.out.println("Is empty: " + pq.isEmpty());
        System.out.println("Maximum: " + pq.findMax());

        // Measure time for deleteMax() method
        long startTimeDelete = System.nanoTime();
        int maxDeleted = pq.deleteMax();
        long endTimeDelete = System.nanoTime();
        long timeTakenDelete = endTimeDelete - startTimeDelete;

        System.out.println("Deleting max: " + maxDeleted);
        System.out.print("Heap: "); pq.display();

        System.out.println("Time taken for insert(): " + timeTakenInsert / 1000000.0 + " milliseconds");
        System.out.println("Time taken for deleteMax(): " + timeTakenDelete / 1000000.0 + " milliseconds");
    }

}
