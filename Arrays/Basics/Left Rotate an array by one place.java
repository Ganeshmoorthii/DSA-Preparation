// 1. Brute Force – Using Extra Space
public void leftRotateByOne(int[] arr) {
    int n = arr.length;
    int first = arr[0];

    for (int i = 0; i < n - 1; i++) {
        arr[i] = arr[i + 1];
    }

    arr[n - 1] = first;
}


// 2. Using a Temporary Array
public void leftRotateByOne(int[] arr) {
    int n = arr.length;
    int[] temp = new int[n];

    for (int i = 0; i < n - 1; i++) {
        temp[i] = arr[i + 1];
    }
    temp[n - 1] = arr[0];

    for (int i = 0; i < n; i++) {
        arr[i] = temp[i];
    }
}

// 3. Using Collections.rotate() (Java Collections Utility)
import java.util.*;

public void leftRotateByOneUsingCollections(List<Integer> list) {
    Collections.rotate(list, -1);  // -1 for left rotate
}


// 4. Using Reverse (for K Rotations but also works for 1)
public void leftRotateByOne(int[] arr) {
    int n = arr.length;

    reverse(arr, 1, n - 1);
    reverse(arr, 0, n - 1);
}

private void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

// 5. Using Queue (for Educational Purpose)
import java.util.*;

public void leftRotateByOne(int[] arr) {
    Queue<Integer> q = new LinkedList<>();
    for (int num : arr) q.add(num);
    q.add(q.poll());

    int i = 0;
    for (int num : q) arr[i++] = num;
}

// 6. Recursive Method (Fun / Practice)
public void leftRotateByOne(int[] arr, int index, int first) {
    if (index == arr.length) {
        arr[arr.length - 1] = first;
        return;
    }
    int temp = arr[index];
    arr[index - 1] = temp;
    leftRotateByOne(arr, index + 1, first);
}

public void startRotate(int[] arr) {
    leftRotateByOne(arr, 1, arr[0]);
}
