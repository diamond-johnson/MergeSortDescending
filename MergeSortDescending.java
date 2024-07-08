package TestProject;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortDescending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        try {
            System.out.print("Enter the number of integers: ");
            n = scanner.nextInt();
            if (n <= 0) {
                throw new RuntimeException("Number of integers must be a positive integer");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        int[] array = new int[n];

        try {
            System.out.println("Enter the integers:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            return;
        }

        mergeSort(array, 0, n - 1);

        System.out.println("Sorted array in descending order:");
        System.out.println(Arrays.toString(array));
    }

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (array[i] >= array[j]) {
                temp[k] = array[i];
                k += 1; i += 1;
            } else {
                temp[k] = array[j];
                k += 1; j += 1;
            }
        }

        while (i <= mid) {
            temp[k] = array[i];
            k += 1; i += 1;
        }

        while (j <= end) {
            temp[k] = array[j];
            k += 1; j += 1;
        }

        for (i = start; i <= end; i += 1) {
            array[i] = temp[i - start];
        }
    }
}