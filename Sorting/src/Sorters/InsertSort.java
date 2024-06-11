package Sorters;

public class InsertSort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int valueI = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > valueI) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = valueI;
        }
    }
}
