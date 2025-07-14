// Approach 1: Basic Iteration (Ascending)

public static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return false;
        }
    }
    return true;
}

//Approach 2: Support Both Ascending or Descending

public static boolean isSorted(int[] arr) {
    boolean asc = true, desc = true;

    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) asc = false;
        if (arr[i] < arr[i + 1]) desc = false;
    }

    return asc || desc;
}

//Approach 3: Recursive Approach

public static boolean isSortedRec(int[] arr, int index) {
    if (index == arr.length - 1) return true;
    if (arr[index] > arr[index + 1]) return false;
    return isSortedRec(arr, index + 1);
}

//Approach 4: Using Java Streams (Java 8+)

import java.util.stream.IntStream;

public static boolean isSorted(int[] arr) {
    return IntStream.range(0, arr.length - 1)
                    .allMatch(i -> arr[i] <= arr[i + 1]);
}

//Approach 5: Using Arrays.sort() for Validation
import java.util.Arrays;

public static boolean isSorted(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(copy);
    return Arrays.equals(arr, copy);
}
