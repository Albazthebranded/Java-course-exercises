import java.util.Arrays;
import java.util.Random;

import static Sorters.BubbleSort.bubbleSort;
import static Sorters.InsertSort.insertSort;

public class Main {
    public static void main (String[] args) {

        int[] array = setUpArray();
        System.out.println(Arrays.toString(array));

        sortArray(array);
        System.out.println(Arrays.toString(array));

    }

    public static int[] setUpArray () {

        Random random = new Random();

        int arrayLength = random.nextInt(0,10000);
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int valueI = random.nextInt(0, 10000);
            array[i] = valueI;
        }
        return array;
    }
    public static void sortArray (int[] array) {

        if (array.length >= 1000) {
            insertSort(array);
            System.out.println("Insertion Sort was used.");
        } else {
            bubbleSort(array);
            System.out.println("Bubble Sort was used.");
        }
    }
}
