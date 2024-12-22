package tubes.tubesaka;

public class TubesAKA {

    // Recursive Bubble Sort implementation
    public static void bubbleSort(int[] arr, int n) {
        // Base case: If the size of the array is 1, return
        if (n == 1) {
            return;
        }

        // One pass of bubble sort, push the largest element to the end
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for the remaining array
        bubbleSort(arr, n - 1);
    }

    // Selection Sort implementation
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Main method to test both algorithms
    public static void main(String[] args) {
        int[] bubbleSortArray = {64, 34, 25, 12, 22, 11, 90, 45, 67, 89, 2, 17, 99, 73, 31};
        int[] selectionSortArray = {64, 25, 12, 22, 11, 45, 67, 89, 2, 17, 99, 73, 31, 90, 34};

        System.out.println("Original Array for Recursive Bubble Sort: ");
        printArray(bubbleSortArray);
        bubbleSort(bubbleSortArray, bubbleSortArray.length);
        System.out.println("Sorted Array using Recursive Bubble Sort: ");
        printArray(bubbleSortArray);

        System.out.println("Original Array for Selection Sort: ");
        printArray(selectionSortArray);
        selectionSort(selectionSortArray);
        System.out.println("Sorted Array using Selection Sort: ");
        printArray(selectionSortArray);
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
