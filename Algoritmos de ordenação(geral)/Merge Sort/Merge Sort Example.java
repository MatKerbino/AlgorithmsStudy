import java.util.Arrays;

public class MergeSort {

    // Método principal para testar o Merge Sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(array));
    }

    // Função recursiva que divide o array e depois o merge ordena
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Encontrar o meio do array
            int mid = left + (right - left) / 2;
            // Ordenar a primeira metade
            mergeSort(arr, left, mid);
            // Ordenar a segunda metade
            mergeSort(arr, mid + 1, right);
            // Mesclar as duas metades ordenadas
            merge(arr, left, mid, right);
        }
    }

    // Função que mescla dois subarrays: arr[left..mid] e arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        // Tamanho dos dois subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporários para armazenar as duas metades
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copiar os dados para os arrays temporários
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Índices iniciais para os arrays temporários e para o array principal
        int i = 0, j = 0, k = left;

        // Mesclar os arrays temporários de volta no array principal, em ordem
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiar quaisquer elementos restantes do leftArray, se existirem
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copiar quaisquer elementos restantes do rightArray, se existirem
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
