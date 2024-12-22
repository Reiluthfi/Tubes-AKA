package tubes.tubesaka;

public class TubesAKA {
    public static void bubbleSort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort(arr, n - 1);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] recommendUsingBubbleSort(int[] ratings) {
        int[] recommendations = ratings.clone();
        bubbleSort(recommendations, recommendations.length);
        return recommendations;
    }
    public static int[] recommendUsingSelectionSort(int[] ratings) {
        int[] recommendations = ratings.clone();
        selectionSort(recommendations);
        return recommendations;
    }

    public static void main(String[] args) {
        int[] userRatings = {3, 5, 1, 4, 2, 5, 3, 4, 1, 2, 5, 4, 3, 1, 2};

        System.out.println("Original User Ratings: ");
        printArray(userRatings);

        int[] bubbleRecommendations = recommendUsingBubbleSort(userRatings);
        System.out.println("Recommendations using Bubble Sort: ");
        printArray(bubbleRecommendations);

        int[] selectionRecommendations = recommendUsingSelectionSort(userRatings);
        System.out.println("Recommendations using Selection Sort: ");
        printArray(selectionRecommendations);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}