class Example {
    public int[] insertionSort(int[] lista){
        for (int i = 1; i < lista.length; i++){
            int chave = lista[i];
            int j = i - 1;

            while (j >= 0 && lista[j] > chave){
                lista[j+1] = lista[j];
                j--;
            }
            lista[j+1] = chave;
        }
        return lista;
    }

    public void test(){
        int[] ex1 = {12,11,13,5,6};
        int[] ex2 = {14,12,9,8,6};
        int[] ex3 = {123,214,12,4,134,32,5,325,235426,43,6,453,76,345,7,57,547457,54,75437542,7,54276,457,54,76547,542,754};

        System.out.println("Exemplo 1: " + java.util.Arrays.toString(insertionSort(ex1)));
        System.out.println("Exemplo 2: " + java.util.Arrays.toString(insertionSort(ex2)));
        System.out.println("Exemplo 3: " + java.util.Arrays.toString(insertionSort(ex3)));
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.test();
    }
}