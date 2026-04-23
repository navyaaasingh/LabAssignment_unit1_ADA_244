import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class sorting_analysis {

    // ---------- CASE GENERATORS ----------
    static int[] generateBestCase(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        return arr;
    }

    static int[] generateWorstCase(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    static int[] generateAverageCase(int n) {
        int[] arr = generateBestCase(n);
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(n);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    // ---------- BUBBLE SORT ----------
    static Result bubbleSort(int[] arr, boolean ascending) {
        int steps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                steps++;

                if ((ascending && arr[j] > arr[j + 1]) ||
                    (!ascending && arr[j] < arr[j + 1])) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    steps += 3;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return new Result(arr, steps);
    }

    // ---------- SELECTION SORT ----------
    static Result selectionSort(int[] arr, boolean ascending) {
        int steps = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int idx = i;

            for (int j = i + 1; j < n; j++) {
                steps++;

                if ((ascending && arr[j] < arr[idx]) ||
                    (!ascending && arr[j] > arr[idx])) {
                    idx = j;
                }
            }

            if (idx != i) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                steps += 3;
            }
        }

        return new Result(arr, steps);
    }

    // ---------- INSERTION SORT ----------
    static Result insertionSort(int[] arr, boolean ascending) {
        int steps = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            steps++;
            int j = i - 1;

            while (j >= 0) {
                steps++;

                if ((ascending && arr[j] > key) ||
                    (!ascending && arr[j] < key)) {
                    arr[j + 1] = arr[j];
                    steps++;
                    j--;
                } else break;
            }

            arr[j + 1] = key;
            steps++;
        }

        return new Result(arr, steps);
    }

    // ---------- ANALYSIS ----------
    static void analyzeSorting() {
        int[] sizes = {10, 20, 30, 40};

        for (String order : new String[]{"Ascending", "Descending"}) {
            boolean ascending = order.equals("Ascending");

            for (String caseType : new String[]{"Best", "Average", "Worst"}) {

                for (int n : sizes) {
                    int[] original;

                    if (caseType.equals("Best"))
                        original = generateBestCase(n);
                    else if (caseType.equals("Average"))
                        original = generateAverageCase(n);
                    else
                        original = generateWorstCase(n);

                    System.out.println("\nSize: " + n + " | " + caseType + " | " + order);

                    runAlgo("Bubble", original, ascending);
                    runAlgo("Selection", original, ascending);
                    runAlgo("Insertion", original, ascending);
                }
            }
        }
    }

    static void runAlgo(String name, int[] original, boolean asc) {
        int[] arr = Arrays.copyOf(original, original.length);
        Result res;

        switch (name) {
            case "Bubble":
                res = bubbleSort(arr, asc);
                break;
            case "Selection":
                res = selectionSort(arr, asc);
                break;
            default:
                res = insertionSort(arr, asc);
        }

        try {
            FileWriter fw = new FileWriter("results.csv", true);
            fw.write(name + "," + original.length + "," + res.steps + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(name + " Output: " + Arrays.toString(res.arr));
        System.out.println(name + " Steps: " + res.steps);
    }

    // ---------- RESULT CLASS ----------
    static class Result {
        int[] arr;
        int steps;

        Result(int[] arr, int steps) {
            this.arr = arr;
            this.steps = steps;
        }
    }

    try {
        FileWriter fw = new FileWriter("results.csv");
        fw.write(""); // clear file
        fw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    public static void main(String[] args) {
        analyzeSorting();
    }
}

