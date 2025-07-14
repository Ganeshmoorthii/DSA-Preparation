//1. Basic Iterative Approach
public class Main {
    public static int findMax(int[] arr) {
        int max = arr[0]; // assume first element is max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
//2. Using Arrays.sort()
import java.util.Arrays;

public class Main {
    public static int findMax(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1]; // last element after sorting
    }
}

//3. Using Java Streams (Java 8+)

import java.util.*;

public class Main {
    public static int findMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
//4. Using Recursion

public class Main {
    public static int findMaxRec(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        return Math.max(arr[index], findMaxRec(arr, index + 1));
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 5, 60, 40};
        System.out.println(findMaxRec(arr, 0)); // Output: 60
    }
}
// 5. Using Collections (for Wrapper Integer[])

import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {3, 10, 6, 8, 21};
        int max = Collections.max(Arrays.asList(arr));
        System.out.println("Max: " + max);
    }
}
