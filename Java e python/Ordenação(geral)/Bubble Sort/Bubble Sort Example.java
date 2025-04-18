class BubbleSortExample {
    public static void bubbleSort(int[] ent) {
        int n = ent.length;
        for (int i = 0; i < n; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (ent[j] > ent[j + 1]) {
                    int temp = ent[j + 1];
                    ent[j + 1] = ent[j];
                    ent[j] = temp;
                    trocou = true;
                }
            }
            if (!trocou)
                break;
        }
    }

    public static void test() {
        int[] arr1 = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        int[] arr2 = {7, 5, 2, 14, 5, 67, 23, 432, 42, 14, 324, 23423, 452, 353, 2523, 523, 5423, 52, 431, 1};
        int[] arr3 = {51, 5435, 451, 454, 534, 541, 5142, 5, 1541, 5, 143, 54, 315, 143, 5, 4135, 143, 5, 34, 543, 5, 413, 56134643, 65, 4316, 43, 6, 346143, 6436, 34, 6, 143, 643, 6, 43, 65, 42, 6543, 6, 36, 135, 6, 41, 6, 46, 43, 64361, 46, 134};

        int[] expected1 = {1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] expected2 = {1, 2, 5, 5, 7, 14, 14, 23, 42, 52, 67, 324, 353, 432, 452, 523, 2523, 5423, 23423};
        int[] expected3 = {5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 34, 34, 35, 36, 36, 41, 42, 43, 43, 43, 46, 46, 51, 54, 54, 65, 65, 134, 135, 143, 143, 143, 143, 143, 143, 451, 454, 513, 514, 523, 534, 541, 543, 5435, 1541, 3154, 346143, 4316, 43161, 56134643};

        bubbleSort(arr1);
        bubbleSort(arr2);
        bubbleSort(arr3);

        assert Arrays.equals(arr1, expected1) : "Erro no teste 1";
        assert Arrays.equals(arr2, expected2) : "Erro no teste 2";
        assert Arrays.equals(arr3, expected3) : "Erro no teste 3";

        System.out.println("Todos os testes passaram com sucesso!");
    }

    public static void main(String[] args) {
        test();
    }
}
