import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] list) {
        int n = list.length;

        // Step 1: Turn the unsorted array into a max-heap.
        // Start at the last parent node (n / 2 - 1) and work backwards to the root (0).
        for (int i = n / 2 - 1; i >= 0; i--) {
            reheapDownward(list, n, i);
        }

        // Step 2: Sort the array one element at a time.
        for (int end = n - 1; end > 0; end--) {
            // The biggest number is always at index 0, so swap it to the end of the unsorted part
            int temp = list[0];
            list[0] = list[end];
            list[end] = temp;

            // Fix the heap for the remaining unsorted elements
            reheapDownward(list, end, 0);
        }
    }

    // Helper method to push a smaller parent node down until it's bigger than its children
    private static void reheapDownward(int[] list, int heapSize, int parent) {
        int largest = parent;
        int left = 2 * parent + 1;   // left child index
        int right = 2 * parent + 2;  // right child index

        // Check if the left child exists and is bigger than the current largest
        if (left < heapSize && list[left] > list[largest]) {
            largest = left;
        }

        // Check if the right child exists and is bigger than the current largest
        if (right < heapSize && list[right] > list[largest]) {
            largest = right;
        }

        // If one of the children was bigger than the parent, swap them and keep going down
        if (largest != parent) {
            int temp = list[parent];
            list[parent] = list[largest];
            list[largest] = temp;

            // Recursively check the subtree we just swapped into
            reheapDownward(list, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        // Test array from the lab assignment
        int[] data = {5, 22, 9, 76, 63, 81, 48, 92, 54, 28};

        System.out.println("Before sorting: " + Arrays.toString(data));
        heapSort(data);
        System.out.println("After sorting:  " + Arrays.toString(data));
    }
}