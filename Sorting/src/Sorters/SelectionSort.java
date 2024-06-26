package Sorters;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minValue = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minValue] > array[j]) {
                    minValue = j;
                }
            }
            int temp = array[i];
            array[i] = array[minValue];
            array[minValue] = temp;
        }
    }
}
