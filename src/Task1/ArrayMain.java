package Task1;

import java.util.Arrays;
import java.util.Random;

public class ArrayMain {
    public static void main(String[] args) {

        long start = System.nanoTime();

        int [] mainArray = new int[1000];
        Random random = new Random();
        for (int i = 0; i < mainArray.length; i++) {
            mainArray[i] = random.nextInt();
        }

        quickSort(mainArray, 0, mainArray.length - 1);
        //Arrays.sort(mainArray);
        System.out.println(Arrays.toString(mainArray));

        long end = System.nanoTime();
        System.out.println(end - start);

    }
    static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex);

            quickSort(array, lowIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, highIndex);
        }
    }
    static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int i = (lowIndex - 1);

        for (int j = lowIndex; j < highIndex; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, highIndex);
        return (i + 1);
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
