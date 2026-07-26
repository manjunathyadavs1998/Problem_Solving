package Heaps;

public class HeapConstruction {
    private int k;
    private MyMinHeap heap;

    public HeapConstruction(int k, int[] nums) {
        this.k = k;
        this.heap = new MyMinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // KEY 1!! Must check current size to prevent peeking an empty heap
        // KEY 2!! If capacity is not exceeded, just add it; the heap maintains order automatically. Replace manually only when full
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

/**
 Custom fixed-capacity Min-Heap implementation.
 Rule: Parent node is always smaller than child nodes (partial ordering).
 */
class MyMinHeap {
    private int size;
    private int[] heap;

    MyMinHeap(int capacity) {
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void offer(int num) {
        if (heap.length == size) {
            throw new RuntimeException("Heap overflow");
        }
        heap[size] = num; // Add to the end if capacity allows
        swiftUp(size);    // Sift up from the end to maintain heap property
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int top = heap[0]; // Record the minimum value to return

        heap[0] = heap[size - 1]; // Overwrite top with the last element
        size--;                   // KEY! Decrement size first to establish correct boundary for swiftDown
        swiftDown(0);             // Sift down from the top

        return top;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];
    }

    public int size() {
        return size;
    }

    // Sift up from child level, swap if parent > child
    private void swiftUp(int idx) {
        // Termination condition: reached the top of the heap
        while (idx > 0) {
            // Compare with parent level
            int parent = (idx - 1) / 2;
            if (heap[parent] < heap[idx]) {
                break; // Parent is smaller: stop sifting up
            }
            swap(parent, idx);
            idx = parent;
        }
    }

    // Sift down from parent level, swap if parent > child
    private void swiftDown(int idx) {
        // Termination condition: reached the bottom of the heap
        while (idx * 2 + 1 < size) {
            // Compare with both children, swap with the smaller child
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int smallChild = left;
            if (right < size && heap[right] < heap[left]) { //if right child exists
                smallChild = right;
            }

            if (heap[smallChild] > heap[idx]) {
                break; // Parent is smaller than children: stop sifting down
            }
            swap(smallChild, idx);
            idx = smallChild;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {

            int k = 3;
            int[] nums = {4, 5, 8, 2};

            HeapConstruction kthLargest = new HeapConstruction(k, nums);

            System.out.println(kthLargest.add(3));   // Expected: 4
            System.out.println(kthLargest.add(5));   // Expected: 5
            System.out.println(kthLargest.add(10));  // Expected: 5
            System.out.println(kthLargest.add(9));   // Expected: 8
            System.out.println(kthLargest.add(4));   // Expected: 8
        }

}
