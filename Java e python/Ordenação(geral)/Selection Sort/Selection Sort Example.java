
import java.util.Arrays;

class main {
    public void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public void test () {
        int[] arr1 = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        int[] arr2 = {7, 5, 2, 14, 5, 67, 23, 432, 42, 14, 324, 23423, 452, 353, 2523, 523, 5423, 52, 431, 1};
        selectionSort(arr1);
        selectionSort(arr2);

        assert Arrays.equals(arr1, new int[]{1, 2, 3, 4, 5, 2, 3, 4, 5}) : "Test case 1 failed";
        assert Arrays.equals(arr2, new int[]{1, 2, 5, 5, 7, 14, 14, 23, 432, 42, 324, 23423, 452, 353, 2523, 523, 5423, 52, 431, 67}) : "Test case 2 failed"; 

        System.out.println("All test cases passed!");
    }
}